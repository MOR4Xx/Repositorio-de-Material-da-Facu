from RPLCD.i2c import CharLCD
import time
import board
import adafruit_dht
import busio
import adafruit_ads1x15.ads1015 as ADS
from adafruit_ads1x15.analog_in import AnalogIn
import RPi.GPIO as GPIO
import threading

print("Inicializando...")

# Configurando GPIO
pino_rele = 20
GPIO.setmode(GPIO.BCM)
GPIO.setup(pino_rele, GPIO.OUT)
GPIO.output(pino_rele, GPIO.LOW)

# inicializando o LCD
lcd = CharLCD(i2c_expander='PCF8574', address=0x27, port=1, cols=16, rows=2, dotsize=8)
lcd.clear()
print("LCD inicializado")

# inicializando o DHT11
dhtDevice = adafruit_dht.DHT11(board.D17, use_pulseio=False)
print("DHT11 inicializado")

# inicializando o modulo de Digiatal/Analogico
i2c = busio.I2C(board.SCL, board.SDA)
ads = ADS.ADS1015(i2c)
chan = AnalogIn(ads, ADS.P0)
print('ADS inicializado')

time.sleep(2)  # espere por 2 segundos

# função para cntrolar o rele da irrigacao
def control_relay(solo):
    if solo < 50:  # Ativa o Rele da valvula solenoide
        GPIO.output(pino_rele, GPIO.HIGH)
        print("Relé ligado")
    else:
        GPIO.output(pino_rele, GPIO.LOW)
        print("Relé desligado")

# função para ler o e mostrar as informações no lcd
def read_and_display():
    while True:
        try:
            for _ in range(5):  # Tenta até 5 vezes
                try:
                    print("Lendo os dados do Sensores")
                    #Lendo valores sensor DHT11
                    humidity = dhtDevice.humidity
                    temperature = dhtDevice.temperature
                    
                    #Lendo valores sensor de umidade do solo
                    voltagem = chan.voltage
                    
                    if temperature is not None and humidity is not None:
                        break  # Sair do loop se a leitura for bem-sucedida
                    time.sleep(2)  # Esperar 2 segundos antes de tentar novamente
                except RuntimeError as e:
                    print(f"Lendo novamente o sensor: {e}")
            else:
                # Se não obter leituras válidas após 5 tentativas, exibir erro
                print("Failed to get valid reading from DHT11 sensor")
                continue  # Pular para a próxima iteração do loop principal

            #informando os dados
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
            control_relay(solo)
            
            print(f'Temp = {temperature:.1f} C')
            print(f'Hum = {humidity:.1f} %')
            print(f'Solo = {solo:.1f} %') 
            
        except Exception as e:
            print(f"Error reading sensor: {e}")
        
        time.sleep(10)  # Atualizado para 10 segundos

sensor_thread = threading.Thread(target=read_and_display)
sensor_thread.start()

try:
    while True:
        time.sleep(1)

except KeyboardInterrupt:
    print("Program interrupted by user")

finally:
    dhtDevice.exit()
    lcd.clear()
    GPIO.cleanup()
    print("Cleaned up resources")
