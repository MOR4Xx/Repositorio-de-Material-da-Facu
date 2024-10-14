
import threading
import time
from src.relay_controller import RelayController
from src.lcd_display import LCDDisplay
from src.sensor_reader import SensorReader
from src.mqtt_client import MQTTClient

def main():
    relay_controller = RelayController(pin=20)
    lcd_display = LCDDisplay()
    sensor_reader = SensorReader(relay_controller, lcd_display)
    mqtt_client = MQTTClient()
    sensor_thread = threading.Thread(target=sensor_reader.read_and_display)
    sensor_thread.start()

    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        print("Programa interrompido pelo usuário")
    finally:
        sensor_reader.cleanup()
        relay_controller.cleanup()
        lcd_display.clear()
        print("Recursos liberados")

if __name__ == "__main__":
    main()
