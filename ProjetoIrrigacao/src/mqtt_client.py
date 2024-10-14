import paho.mqtt.client as mqtt

class MQTTClient:
    def __init__(self, broker_address="localhost", broker_port=1883):
        self.client = mqtt.Client()
        self.client.on_connect = self.on_connect
        self.client.on_message = self.on_message
        self.client.connect(broker_address, broker_port)
        self.client.loop_start()

    def on_connect(self, client, userdata, flags, rc):
        print(f"Conectado ao broker MQTT com código")
        client.subscribe("control/rele")  # Subscreve no tópico para controle do relé


    def on_message(self, client, userdata, msg):
        print(f"Mensagem recebida: {msg.topic} - {msg.payload.decode()}")
        if msg.topic == "control/rele":
            comando = msg.payload.decode()
            if comando == "on":
                self.set_control_relay_callback(True)
            elif comando == "off":
                self.set_control_relay_callback(False)

    def set_control_relay_callback(self, callback):
        # Define a função de callback para controle do relé
        self.control_relay_callback = callback

    def publish(self, topic, message):
        self.client.publish(topic, message)

    def loop_start(self):
        self.client.loop_start()

    def loop_stop(self):
        self.client.loop_stop()
