package Exemplo_Polimorfismo;

import Exemplo_Polimorfismo.apps.FacebookMesseger2;
import Exemplo_Polimorfismo.apps.MsnMessenger2;
import Exemplo_Polimorfismo.apps.ServicoMensagemInstantanea;
import Exemplo_Polimorfismo.apps.Telegram2;

import java.util.Scanner;

public class ComputadorPedrinho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ServicoMensagemInstantanea smi = null;

		/*
		    NÃO SE SABE QUAL APP
		    MAS QUALQUER UM DEVERÁ ENVIAR E RECEBER MENSAGEM
		 */
        System.out.print("Digite um app: ");
        String appEscolhido = sc.nextLine();

        if (appEscolhido.equals("msn")) {
            smi = new MsnMessenger2();
        } else if (appEscolhido.equals("fbm")) {
            smi = new FacebookMesseger2();
        } else if (appEscolhido.equals("tlg")) {
            smi = new Telegram2();
        }

        smi.enviarMensagem();
        smi.receberMensagem();

        sc.close();
    }
}
