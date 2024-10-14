
import time
import board
import adafruit_dht
import busio
import adafruit_ads1x15.ads1015 as ADS
from adafruit_ads1x15.analog_in import AnalogIn

class SensorReader:
    def __init__(self, relay_controller, lcd_display):
        self.dht_device = adafruit_dht.DHT11(board.D17, use_pulseio=False)
        self.i2c = busio.I2C(board.SCL, board.SDA)
        self.ads = ADS.ADS1015(self.i2c)
        self.chan = AnalogIn(self.ads, ADS.P0)
        self.relay_controller = relay_controller
        self.lcd_display = lcd_display

    def read_and_display(self, temperature, humidity, soil_moisture):
        while True:
            try:
                self.lcd_display.display_message(
                    f'Temp = {temperature:.1f} C',
                    f'Hum = {humidity:.1f} %'
                )

                self.lcd_display.display_message(
                    f'Soil = {soil_moisture:.1f} %'
                )

                self.relay_controller.control_relay(soil_moisture)

                print(f'Temp = {temperature:.1f} C, Hum = {humidity:.1f} %, Solo = {soil_moisture:.1f} %')
            except Exception as e:
                print(f"Error ao ler o sensor: {e}")
            time.sleep(10)

    def read_dht_sensor(self):
        for _ in range(5):
            try:
                humidity = self.dht_device.humidity
                temperature = self.dht_device.temperature
                if humidity is not None and temperature is not None:
                    return humidity, temperature
                time.sleep(2)
            except RuntimeError as e:
                print(f"Lendo novamente o sensor DHT11: {e}")
        raise RuntimeError("Falha ao obter leitura válida do sensor DHT11")

    def read_and_publish(self):
        while True:
            humidity, temperature = self.read_dht_sensor()
            soil_moisture = self.read_soil_sensor()

            self.mqtt_client.publish("sensor/temperature", temperature)
            self.mqtt_client.publish("sensor/humidity", humidity)
            self.mqtt_client.publish("sensor/soil_moisture", soil_moisture)

            self.lcd_display.display_message(humidity, temperature, soil_moisture)

            # if soil_moisture < 50:
            #     self.relay_controller.turn_on()
            # else:
            #     self.relay_controller.turn_off()

            time.sleep(10)

    def read_soil_sensor(self):
        MAX_VOLTAGE = 4.094
        MIN_VOLTAGE = 2.000
        voltage = self.chan.voltage
        soil_moisture = ((MAX_VOLTAGE - voltage) / (MAX_VOLTAGE - MIN_VOLTAGE)) * 100
        return soil_moisture

    def cleanup(self):
        self.dht_device.exit()
