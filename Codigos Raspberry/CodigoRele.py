#
# Controle de relé em Python (IDLE 3.5.3) e Tkinter para Raspberry Pi.


# Data: 29/04/2019
# --------------------------------------------------------------------

from tkinter import *
import RPi.GPIO as GPIO

# Configuração das GPIOs (BCM)
pino_rele_1 = 20

GPIO.setmode(GPIO.BCM)
GPIO.setup(pino_rele_1, GPIO.OUT)

class App:
    def __init__(self, master=None):
        
        #Configurar nomes dos relés e app de sua preferência
        self.tituloRele1 = "Rele Solenoide"
        ##self.tituloApp = "If Maker - Irrigação"
        self.fonteApp = ("Calibri", "12")
        
        #Container e widget Título
        self.containerTitulo = Frame(master)
        self.containerTitulo["pady"] = 10
        self.containerTitulo["padx"] = 50
        self.containerTitulo.pack()
        
        self.tituloApp = Label(self.containerTitulo, font=self.fonteApp)
        self.tituloApp.pack()

        #Container e widgets Relé 1
        self.containerRele1 = Frame(master)
        self.containerRele1["padx"] = 50
        self.containerRele1["pady"] = 5
        self.containerRele1.pack()
        
        self.tituloRele1 = Label(self.containerRele1, text=self.tituloRele1, font=self.fonteApp)
        self.tituloRele1.pack(side=LEFT)
  
        self.btnRele1 = Button(self.containerRele1, font=self.fonteApp)
        self.btnRele1["text"] = "Status"
        self.btnRele1["width"] = 12
        self.btnRele1["command"] = self.rele1
        self.btnRele1.pack()

        self.lerStatus()

    def rele1(self):
        if(GPIO.input(pino_rele_1) == 0):
            GPIO.output(pino_rele_1,1)
            self.btnRele1["text"] = "Desligar"
            self.btnRele1["bg"] = "#ef5350"
        elif(GPIO.input(pino_rele_1) == 1):
            GPIO.output(pino_rele_1,0)
            self.btnRele1["text"] = "Ligar"
            self.btnRele1["bg"] = "#66BB6A"

    def lerStatus(self):
        if(GPIO.input(pino_rele_1) == 1):      
            self.btnRele1["text"] = "Desligar"
            self.btnRele1["bg"] = "#ef5350"
        elif(GPIO.input(pino_rele_1) == 0):    
            self.btnRele1["text"] = "Ligar"
            self.btnRele1["bg"] = "#66BB6A"
            

root = Tk()
App(root)
# Título do app
root.title('If Maker - Irrigação')
# Bloquear janela
root.resizable(width=False, height=False)
# Tamanho da janela
root.geometry("400x200")
root.mainloop()
# Limpa as GPIOs
GPIO.cleanup()
