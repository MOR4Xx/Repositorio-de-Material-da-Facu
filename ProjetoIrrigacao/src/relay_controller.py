
import RPi.GPIO as GPIO

class RelayController:
    def __init__(self, pin):
        self.pin = pin
        GPIO.setmode(GPIO.BCM)
        GPIO.setup(self.pin, GPIO.OUT)
        GPIO.output(self.pin, GPIO.LOW)

    def control_relay(self, on):
        if on:
            GPIO.output(self.pin, GPIO.HIGH)
            print("Relé ligado")
        else:
            GPIO.output(self.pin, GPIO.LOW)
            print("Relé desligado")

    def cleanup(self):
        GPIO.cleanup()
