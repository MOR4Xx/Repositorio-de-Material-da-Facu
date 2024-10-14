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

# Configuração do GPIO
pino_rele = 20
GPIO.setmode(GPIO.BCM)
GPIO.setup(pino_rele, GPIO.OUT)
GPIO.output(pino_rele, GPIO.LOW)

# Inicializando o LCD
lcd = CharLCD(i2c_expander='PCF8574', address=0x27, port=1, cols=16, rows=2, dotsize=8)
lcd.clear()

# Inicializando o DHT11
dhtDevice = adafruit_dht.DHT11(board.D17, use_pulseio=False)

# Inicializando o módulo de Digital/Analógico
i2c = busio.I2C(board.SCL, board.SDA)
ads = ADS.ADS1015(i2c)
chan = AnalogIn(ads, ADS.P0)

# Configuração do cliente MQTT
client = mqtt.Client()

# Função de callback quando o cliente se conecta ao broker MQTT
def on_connect(client, userdata, flags, rc):
    print("Conectado ao broker MQTT com código de retorno: " + str(rc))
    client.subscribe("raspberry/relay")  # Inscreve-se no tópico para comandos do relé

# Função de callback para quando uma mensagem for recebida
def on_message(client, userdata, msg):
    message = msg.payload.decode()
    print("Mensagem recebida: " + message)
    
    if message == "ligar":
        GPIO.output(pino_rele, GPIO.HIGH)
        print("Relé ligado")
    elif message == "desligar":
        GPIO.output(pino_rele, GPIO.LOW)
        print("Relé desligado")

# Configurações do MQTT
client.on_connect = on_connect
client.on_message = on_message
client.connect("localhost", 1883, 60)  # Conecta-se ao broker MQTT no localhost

# Função para ler e mostrar as informações no LCD, e publicar no MQTT
def read_and_display():
    while True:
        try:
            # Tenta ler os dados do sensor DHT11
            for _ in range(5):  # Tenta até 5 vezes
                try:
                    print("Lendo os dados do Sensores")
                    humidity = dhtDevice.humidity
                    temperature = dhtDevice.temperature
                    voltagem = chan.voltage
                    
                    if temperature is not None and humidity is not None:
                        break  # Sai do loop se a leitura for bem-sucedida
                    time.sleep(2)  # Espera 2 segundos antes de tentar novamente
                except RuntimeError as e:
                    print(f"Lendo novamente o sensor: {e}")
            else:
                # Se não obter leituras válidas após 5 tentativas, exibe erro
                print("Falha ao obter leitura válida do sensor DHT11")
                continue  # Pula para a próxima iteração do loop principal

            # Exibindo os dados no LCD
            lcd.clear()
            lcd.write_string(f'Temp = {temperature:.1f} C')
            lcd.crlf()
            lcd.write_string(f'Hum = {humidity:.1f} %')
            time.sleep(5)
            
            lcd.clear()
            MAX_VOLTAGE = 4.094
            MIN_VOLTAGE = 2.000
            solo = ((MAX_VOLTAGE - voltagem) / (MAX_VOLTAGE - MIN_VOLTAGE)) * 100
            lcd.write_string(f'Soil = {solo:.1f} %')

            # Controle do relé com base na leitura de solo
            control_relay(solo)
            
            # Exibindo os valores no console
            print(f'Temp = {temperature:.1f} C')
            print(f'Hum = {humidity:.1f} %')
            print(f'Solo = {solo:.1f} %')
            
            # Publica os dados no MQTT
            client.publish("raspberry/sensors/temperature", f"{temperature}")
            client.publish("raspberry/sensors/humidity", f"{humidity}")
            client.publish("raspberry/sensors/soil", f"{solo}")

        except RuntimeError as e:
            print("Erro ao ler o sensor: ", e)
        
        time.sleep(10)  # Espera antes da próxima leitura

def control_relay(solo):
    if solo < 50:
        GPIO.output(pino_rele, GPIO.HIGH)
        print("Relé ligado")
    else:
        GPIO.output(pino_rele, GPIO.LOW)
        print("Relé desligado")

# Executa as funções em threads
sensor_thread = threading.Thread(target=read_and_display)
sensor_thread.start()

client.loop_start()  # Inicia o loop MQTT em segundo plano

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
