package AulasPoo.Polimorfismo.Exemplo1;

public class Main {
    public static void main(String[] args) {
        Aviao aviao = new Aviao();
        Carro carro = new Carro();
        Barco barco = new Barco();

        aviao.mover();
        carro.mover();
        barco.mover();

        ControleRemoto controlecarro = new ControleRemoto(carro);
        controlecarro.mover();
    }
}
