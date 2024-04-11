import Adafruit_GPIO.PCF8574 as PCF
import board
import digitalio
import adafruit_character_lcd.character_lcd as character_lcd

# Define os pinos do Raspberry Pi aos quais o LCD está conectado.

lcd_rs = digitalio.DigitalInOut(board.D18)
lcd_en = digitalio.DigitalInOut(board.D23)
lcd_d7 = digitalio.DigitalInOut(board.D21)
lcd_d6 = digitalio.DigitalInOut(board.D20)
lcd_d5 = digitalio.DigitalInOut(board.D16)
lcd_d4 = digitalio.DigitalInOut(board.D12)
lcd_backlight = digitalio.DigitalInOut(board.D13)

# Define o número de colunas e linhas do LCD.

lcd_columns = 16
lcd_rows  = 2

# Inicializa o LCD nos pinos configurados acima.

lcd = character_lcd.Character_LCD_Mono(lcd_rs, lcd_en, lcd_d4, lcd_d5,
                                       lcd_d6, lcd_d7, lcd_columns, lcd_rows,
                                       lcd_backlight)

# Mensagem a ser exibida no LCD.

lcd.message = "IF MAKER\n CAMPUS URUTAI"

