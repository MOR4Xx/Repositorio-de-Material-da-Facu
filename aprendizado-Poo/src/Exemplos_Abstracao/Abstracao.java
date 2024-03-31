package Exemplos_Abstracao;

public class Abstracao {
    /**
     *Abstração: Envolve a criação de interfaces ou classes abstratas que representam conceitos genéricos,
     * simplificando complexidades e destacando apenas o necessário.
     *
     * Um exemplo é uma "classe abstract animal" que tem a seguinte função: fazer som, porém temos dois objetos, um gato e um cachorro
     * esses dois animais fazem sons diferentes, ai que a abstração entra em ação, ele vai ser usada de maneira diferente para cada animal,
     * funcionando como uma classe genérica.
     */
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Facebook");
        FacebookMesseger face = new FacebookMesseger();
        face.enviarMensagem();
        face.receberMensagem();
        System.out.println();

        System.out.println("MSN");
        MsnMessenger msn = new MsnMessenger();
        msn.enviarMensagem();
        msn.receberMensagem();
        System.out.println();

        System.out.println("telegram");
        Telegram tlg = new Telegram();
        tlg.enviarMensagem();
        tlg.receberMensagem();
        System.out.println();
    }
}
