import time
from board import D3
import adafruit_dht

# inicializando o sensor no pino D3
dhtDevice = adafruit_dht.DHT11(D3)

# Set the LCD's second line to input mo
while True:
    try:
        #Lendo os dados temperatura e umidade pelo sensor DHT11
        temperature_c = dhtDevice.temperature
        humidity = dhtDevice.humidity

        #checando se os dados é valido
        #Display de temperatura e umidade transmite
        print("Temperature = {0:0.1f}°C \nUmidade = {1:0.1f}%".format(temperature_c, humidity))

        #Espera por 5s antes da próxima leitura do sensor

        time.sleep(5)

            # lidar com quaisquer erros que possam ocorrer durante a leitura do sensor
    except RuntimeError as error:
        print(error.args[0])
        time.sleep(2.0)
        continue
