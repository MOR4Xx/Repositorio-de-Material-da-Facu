package Exemplo_Heranca.Exemplo1;

public class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String marca, String cor, String modelo, int tanque, int cilindrada) {

        super(modelo, marca, cor, tanque);

        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
