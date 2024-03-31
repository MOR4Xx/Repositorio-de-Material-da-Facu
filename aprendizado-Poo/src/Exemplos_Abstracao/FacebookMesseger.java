package Exemplos_Abstracao;

public class FacebookMesseger extends ServicoMensagemInstantanea{
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo Facebook Messenger");
    }
    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo Facebook Messenger");
    }
}
