from RPLCD.i2c import CharLCD
import time
import board
import adafruit_dht

print("Initializing...")

# Initialize the LCD
lcd = CharLCD(i2c_expander='PCF8574', address=0x27, port=1, cols=16, rows=2, dotsize=8)
lcd.clear()
print("LCD initialized")

# Initialize the DHT11 sensor
dhtDevice = adafruit_dht.DHT11(board.D17, use_pulseio=False)
print("DHT11 sensor initialized")

time.sleep(2)  # wait for 2 secs

print("Entering the loop")

try:
    while True:  # Infinite Loop
        try:
            print("Reading sensor data...")
            humidity = dhtDevice.humidity
            temperature = dhtDevice.temperature  # read from sensor and save respective values in temperature and humidity variable
            if temperature is None or humidity is None:
                raise ValueError("Sensor returned None values")
        except Exception as e:
            print(f"Error: {e}")
        else:
            lcd.clear()  # Clear the LCD screen
            print("Displaying data on LCD")

            lcd.write_string('Temp = %.1f C' % temperature)  # Display the value of temperature
            lcd.crlf()
            lcd.write_string('Hum = %.1f %%' % humidity)  # Display the value of Humidity

        time.sleep(3)  # Wait for 5 seconds then update the values

except KeyboardInterrupt:
    print("Program interrupted by user")

finally:
    dhtDevice.exit()
    lcd.clear()
    print("Cleaned up resources")
