package AulasPoo.Polimorfismo.Exemplo1;

public class Carro extends Brinquedo{
    public Carro(){

    }

    @Override
    public void mover() {
        System.out.println("Correr!");
    }
}
