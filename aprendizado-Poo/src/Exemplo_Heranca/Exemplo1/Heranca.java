package Exemplo_Heranca.Exemplo1;

public class Heranca {
    public static void main(String[] args) {

        Carro carro1 = new Carro("Civic", "Honda", "Preto", 60, 4);

        System.out.println("Modelo: " + carro1.getModelo());
        System.out.println("Marca: " + carro1.getMarca());
        System.out.println("Cor: " + carro1.getCor());
        System.out.println("Capacidade Tanque: " + carro1.getTanque());
        System.out.println("Numero de portas: " + carro1.getNumeroPortas());
        System.out.println();

        Moto moto1 = new Moto("Honda", "Biz", "Preta", 10, 125);

        System.out.println("Modelo: " + moto1.getModelo());
        System.out.println("Marca: " + moto1.getMarca());
        System.out.println("Cor: " + moto1.getCor());
        System.out.println("Capacidade Tanque: " + moto1.getTanque());
        System.out.println("Cilindradas: " + moto1.getCilindrada());
    }
}