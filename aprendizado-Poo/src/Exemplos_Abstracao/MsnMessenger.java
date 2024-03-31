package Exemplos_Abstracao;

public class MsnMessenger extends ServicoMensagemInstantanea {
    public void enviarMensagem() {
        System.out.println("Enviando mensagem pelo MSN Messenger");
    }

    public void receberMensagem() {
        System.out.println("Recebendo mensagem pelo MSN Messenger");
    }
}
