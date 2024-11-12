import paho.mqtt.client as mqtt
from RPLCD.i2c import CharLCD
import time
import board
import adafruit_dht
import busio
import adafruit_ads1x15.ads1015 as ADS
from adafruit_ads1x15.analog_in import AnalogIn
import RPi.GPIO as GPIO
import threading

# -------------------- Configurações Iniciais --------------------

# Configuração do GPIO
pino_rele = 20
GPIO.setmode(GPIO.BCM)
GPIO.setup(pino_rele, GPIO.OUT)
GPIO.output(pino_rele, GPIO.LOW)

# Inicializando o LCD
lcd = CharLCD(i2c_expander='PCF8574', address=0x27, port=1, cols=16, rows=2, dotsize=8)
lcd.clear()

# Inicializando o sensor DHT11
dhtDevice = adafruit_dht.DHT11(board.D17, use_pulseio=False)

# Inicializando o módulo de Digital/Analógico
i2c = busio.I2C(board.SCL, board.SDA)
ads = ADS.ADS1015(i2c)
chan = AnalogIn(ads, ADS.P0)

# Configuração do cliente MQTT
client = mqtt.Client()

# Variáveis de modo e quantidade de água
modo = "Manual"
quantidade_agua_predefinida = 0
quantidade_agua_manual = 0  # Certifique-se de que esta variável é um inteiro
cooldown_predefinido = 10  # Cooldown em segundos após irrigação no modo Predefinida
nivel_umidade_solo_minimo = 50  # Umidade mínima para ativar a irrigação
irrigacao_ativa = False  # Estado da irrigação para evitar ativações não solicitadas

# -------------------- Funções de Sensor --------------------

def read_soil():
    """Lê a tensão do sensor de umidade do solo."""
    return chan.voltage


def read_temp():
    """Tenta ler a temperatura do DHT11. Retorna None se falhar após 5 tentativas."""
    for _ in range(5):
        try:
            return dhtDevice.temperature
        except RuntimeError as e:
            print(f"Erro ao ler temperatura do DHT11: {e}")
            time.sleep(2)
    return None


def read_humidity():
    """Tenta ler a umidade do DHT11. Retorna None se falhar após 5 tentativas."""
    for _ in range(5):
        try:
            return dhtDevice.humidity
        except RuntimeError as e:
            print(f"Erro ao ler umidade do DHT11: {e}")
            time.sleep(2)
    return None


# -------------------- Controles --------------------

def control_relay(command):
    """Controla o estado do relé (ligar ou desligar) com base no comando recebido."""
    global irrigacao_ativa
    if command == "true":
        GPIO.output(pino_rele, GPIO.HIGH)
        irrigacao_ativa = True
        print("\nRelé ligado\n")
    elif command == "false":
        GPIO.output(pino_rele, GPIO.LOW)
        irrigacao_ativa = False
        print("\nRelé desligado\n")
    else:
        print("\nComando de relé desconhecido\n")


def definir_modo(command):
    """Define o modo de irrigação com base no comando recebido."""
    global modo
    modo = command
    print(f"\nModo de irrigação definido para {modo}\n")


def automatic():
    """Verifica a umidade do solo e ativa o relé automaticamente se necessário."""
    soil = read_soil()
    if not irrigacao_ativa and soil < nivel_umidade_solo_minimo:
        print("Umidade do solo baixa. Iniciando irrigação automática.")
        control_relay("true")
    elif irrigacao_ativa and soil >= nivel_umidade_solo_minimo:
        print("Umidade do solo adequada. Parando irrigação automática.")
        control_relay("false")


def predefinido():
    """Irriga se a umidade do solo estiver baixa e ativa o cooldown após a irrigação."""
    global irrigacao_ativa
    soil = read_soil()
    if not irrigacao_ativa and soil < nivel_umidade_solo_minimo:
        print(f"Iniciando irrigação predefinida por {quantidade_agua_predefinida} segundos.")
        control_relay("true")
        time.sleep(quantidade_agua_predefinida)
        control_relay("false")
        print("Irrigação predefinida concluída.")
        irrigacao_ativa = False
        time.sleep(cooldown_predefinido)


def manual():
    """Executa a irrigação manualmente com a quantidade de água definida."""
    global irrigacao_ativa
    if quantidade_agua_manual > 0 and not irrigacao_ativa:
        print(f"Iniciando irrigação manual por {quantidade_agua_manual} segundos.")
        control_relay("true")
        time.sleep(quantidade_agua_manual)
        control_relay("false")
        irrigacao_ativa = False
    else:
        print("Quantidade de água para irrigação manual não definida ou irrigação já ativa.")


# -------------------- Funções MQTT --------------------

def on_connect(client, userdata, flags, rc):
    """Callback para quando o cliente se conecta ao broker MQTT."""
    print(f"\nConectado ao broker MQTT com código de retorno: {rc}\n")
    client.subscribe("raspberry/relay")
    client.subscribe("raspberry/modo")
    client.subscribe("raspberry/quantidade_agua")
    client.subscribe("raspberry/quantidade_agua_manual")


def on_message(client, userdata, msg):
    """Callback para quando uma mensagem é recebida pelo MQTT."""
    global quantidade_agua_predefinida
    global quantidade_agua_manual
    topic = msg.topic
    message = msg.payload.decode()
    print(f"\nTópico: {topic} - Mensagem recebida: {message}\n")

    if topic == "raspberry/relay":
        if message == "true" and modo == "Manual":
            manual()
    elif topic == "raspberry/modo":
        definir_modo(message)
    elif topic == "raspberry/quantidade_agua":
        quantidade_agua_predefinida = int(message)
        print(f"Quantidade de água predefinida atualizada para: {quantidade_agua_predefinida} segundos\n")
    elif topic == "raspberry/quantidade_agua_manual":
        quantidade_agua_manual = int(message)  # Converte para inteiro para evitar problemas
        print(f"Quantidade de água manual atualizada para: {quantidade_agua_manual} segundos\n")


# -------------------- Monitoramento de Modo --------------------

def monitorar_modo():
    """Verifica o modo de operação e executa as funções de irrigação apropriadas."""
    while True:
        if modo == "Automatica":
            automatic()
        elif modo == "Predefinida":
            predefinido()
        time.sleep(10)  # Intervalo entre as verificações


# -------------------- Funções de Exibição e Publicação --------------------

def read_and_display():
    """Lê e exibe os dados dos sensores no LCD e publica os valores no MQTT."""
    while True:
        try:
            temperature = read_temp()
            humidity = read_humidity()
            humidity_soil = read_soil()

            if temperature is None or humidity is None:
                print("\nFalha ao obter leitura válida do sensor DHT11\n")
                continue

            lcd.clear()
            lcd.write_string(f'Temp = {temperature:.2f} C')
            lcd.crlf()
            lcd.write_string(f'Hum = {humidity:.2f} %')
            time.sleep(5)

            MAX_VOLTAGE = 4.094
            MIN_VOLTAGE = 2.000
            solo = ((MAX_VOLTAGE - humidity_soil) / (MAX_VOLTAGE - MIN_VOLTAGE)) * 100
            lcd.clear()
            lcd.write_string(f'Solo = {solo:.1f} %')

            print(f"\nTemperatura: {temperature:.2f} C")
            print(f"Umidade: {humidity:.2f} %")
            print(f"Solo: {solo:.1f} %\n")

            client.publish("raspberry/sensors/temperature", f"{temperature}")
            client.publish("raspberry/sensors/humidity", f"{humidity}")
            client.publish("raspberry/sensors/soil", f"{solo}")

        except RuntimeError as e:
            print(f"\nErro ao ler o sensor: {e}\n")

        time.sleep(10)  # Espera antes da próxima leitura


# -------------------- Execução do Programa --------------------

sensor_thread = threading.Thread(target=read_and_display)
monitor_thread = threading.Thread(target=monitorar_modo)
sensor_thread.start()
monitor_thread.start()

client.on_connect = on_connect
client.on_message = on_message
client.connect("localhost", 1883, 60)
client.loop_start()

try:
    while True:
        time.sleep(1)
except KeyboardInterrupt:
    print("\nPrograma interrompido pelo usuário\n")
finally:
    dhtDevice.exit()
    lcd.clear()
    GPIO.cleanup()
    print("\nRecursos liberados\n")
