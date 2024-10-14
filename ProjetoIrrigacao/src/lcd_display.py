
from RPLCD.i2c import CharLCD
import time

class LCDDisplay:
    def __init__(self, address=0x27, cols=16, rows=2):
        self.lcd = CharLCD(i2c_expander='PCF8574', address=address, port=1, cols=cols, rows=rows, dotsize=8)
        self.lcd.clear()

    def display_message(self, line1, line2=None):
        self.lcd.clear()
        self.lcd.write_string(line1)
        if line2:
            self.lcd.crlf()
            self.lcd.write_string(line2)
        time.sleep(5)

    def clear(self):
        self.lcd.clear()
