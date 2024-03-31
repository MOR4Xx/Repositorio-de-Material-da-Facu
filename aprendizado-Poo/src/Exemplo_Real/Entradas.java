package Exemplo_Real;

import java.util.Scanner;

public class Entradas {
    public static int entradaInt(String mensagem) {
        int entrada = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(mensagem);
            entrada = sc.nextInt();
            return entrada;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static double entradaFloat(String mensagem) {
        double entrada = 0;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(mensagem);
            entrada = sc.nextDouble();
            return entrada;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String entradaString(String mensagem) {
        String entrada = "";
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print(mensagem);
            entrada = sc.nextLine();
            return entrada;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
