import time #import time for creating delay
import board
import digitalio
import pulseio
import adafruit_character_lcd.character_lcd as characterlcd #Import LCD library 
import adafruit_dht #Import DHT Library for sensor

print("Passou aq 0")

lcd_rs = digitalio.DigitalInOut(board.D7)
lcd_en = digitalio.DigitalInOut(board.D8)
lcd_d7 = digitalio.DigitalInOut(board.D18)
lcd_d6 = digitalio.DigitalInOut(board.D23)
lcd_d5 = digitalio.DigitalInOut(board.D24)
lcd_d4 = digitalio.DigitalInOut(board.D25)

lcd_columns = 16 #for 16*2 LCD
lcd_rows    = 2 #for 16*2 LCD
print("Set pinos Sucesso")

lcd = characterlcd.Character_LCD_Mono(lcd_rs, lcd_en, lcd_d4, lcd_d5, lcd_d6, lcd_d7, 
                           lcd_columns, lcd_rows)   #Send all the pin details to library 
print ("Setou lcd")

time.sleep(2) #wait for 2 secs
print("Antes do while")

while True: #Infinite Loop
    print("Dentro do loop")
    try:
        print ("dentro do try")
        dhtDevice = adafruit_dht.DHT11(board.D17, use_pulseio=False) #we are using the DHT11 sensor
        humidity = dhtDevice.humidity
        temperature = dhtDevice.temperature #read from sensor and save respective values in temperature and humidity varibale  
        if temperature is None:
            raise
    except:
        print('Error: Adafruit read error')
        dhtDevice.exit()
    
    dhtDevice.exit()
    lcd.clear() #Clear the LCD screen
    print("Passou aq 3")
    lcd.message ='Temp = %.1f C' % temperature # Display the value of temperature
    lcd.message ='\nUmi = %.1f %%' % humidity  #Display the value of Humidity 
    
    time.sleep(5) #Wait for 2 sec then update the values