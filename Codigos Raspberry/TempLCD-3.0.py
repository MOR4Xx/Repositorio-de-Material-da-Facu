
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

# Variável para armazenar o modo de irrigação e quantidade de água no modo predefinido
modo = "Manual"
quantidade_agua_predefinida = 0

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
    if command == "true":
        GPIO.output(pino_rele, GPIO.HIGH)
        print("Relé ligado")
    elif command == "false":
        GPIO.output(pino_rele, GPIO.LOW)
        print("Relé desligado")
    else:
        print("Comando de relé desconhecido")


def definir_modo(command):
    """Define o modo de irrigação com base no comando recebido."""
    global modo
    modo = command
    print(f"Modo de irrigação definido para {modo}")


def automatic():
    """Verifica a umidade do solo e ativa/desativa o relé automaticamente."""
    soil = read_soil()
    if soil >= 50:
        control_relay("true")
    else:
        control_relay("false")


def predefinido():
    """Ativa o relé com base na quantidade de água predefinida."""
    print(f"Irrigando com quantidade predefinida: {quantidade_agua_predefinida}")
    control_relay("true")
    time.sleep(quantidade_agua_predefinida)  # Tempo de irrigação simulando a quantidade de água
    control_relay("false")
    print("Irrigaçao predefinida feita")
    


# -------------------- Funções MQTT --------------------

def on_connect(client, userdata, flags, rc):
    """Callback para quando o cliente se conecta ao broker MQTT."""
    print("Conectado ao broker MQTT com código de retorno: " + str(rc))
    client.subscribe("raspberry/relay")
    client.subscribe("raspberry/modo")
    client.subscribe("raspberry/quantidade_agua")


def on_message(client, userdata, msg):
    """Callback para quando uma mensagem é recebida pelo MQTT."""
    global quantidade_agua_predefinida
    topic = msg.topic
    message = msg.payload.decode()
    print("Mensagem recebida: " + message)

    if topic == "raspberry/relay":
        control_relay(message)
    elif topic == "raspberry/modo":
        definir_modo(message)
    elif topic == "raspberry/quantidade_agua":
        # Atualiza a quantidade de água no modo predefinido
        quantidade_agua_predefinida = int(message)
        print(f"Quantidade de água predefinida atualizada para: {quantidade_agua_predefinida} segundos")


# -------------------- Monitoramento de Modo --------------------

def monitorar_modo():
    """Verifica o modo de operação e executa as funções de irrigação apropriadas."""
    while True:
        if modo == "Automatica":
            automatic()
        elif modo == "Predefinida":
            if quantidade_agua_predefinida > 0:
                predefinido()
        time.sleep(5)  # Intervalo entre as verificações


# -------------------- Funções de Exibição e Publicação --------------------

def read_and_display():
    """Lê e exibe os dados dos sensores no LCD e publica os valores no MQTT."""
    while True:
        try:
            # Leitura dos dados do sensor DHT11
            temperature = read_temp()
            humidity = read_humidity()
            humidity_soil = read_soil()

            if temperature is None or humidity is None:
                print("Falha ao obter leitura válida do sensor DHT11")
                continue

            # Exibindo os dados no LCD
            lcd.clear()
            lcd.write_string(f'Temp = {temperature:.2f} C')
            lcd.crlf()
            lcd.write_string(f'Hum = {humidity:.2f} %')
            time.sleep(5)

            # Calculando e exibindo a umidade do solo
            MAX_VOLTAGE = 4.094
            MIN_VOLTAGE = 2.000
            solo = ((MAX_VOLTAGE - humidity_soil) / (MAX_VOLTAGE - MIN_VOLTAGE)) * 100
            lcd.clear()
            lcd.write_string(f'Solo = {solo:.1f} %')

            # Exibindo os valores no console
            print(f'Temp = {temperature:.2f} C')
            print(f'Hum = {humidity:.2f} %')
            print(f'Solo = {solo:.1f} %')

            # Publicando os dados no MQTT
            client.publish("raspberry/sensors/temperature", f"{temperature}")
            client.publish("raspberry/sensors/humidity", f"{humidity}")
            client.publish("raspberry/sensors/soil", f"{solo}")

        except RuntimeError as e:
            print("Erro ao ler o sensor: ", e)

        time.sleep(10)  # Espera antes da próxima leitura


# -------------------- Execução do Programa --------------------

# Inicia as threads
sensor_thread = threading.Thread(target=read_and_display)
monitor_thread = threading.Thread(target=monitorar_modo)
sensor_thread.start()
monitor_thread.start()

# Configurações do MQTT
client.on_connect = on_connect
client.on_message = on_message
client.connect("localhost", 1883, 60)
client.loop_start()

# Loop Principal
try:
    while True:
        time.sleep(1)

except KeyboardInterrupt:
    print("Programa interrompido pelo usuário")

finally:
    dhtDevice.exit()
    lcd.clear()
    GPIO.cleanup()
    print("Recursos liberados")
