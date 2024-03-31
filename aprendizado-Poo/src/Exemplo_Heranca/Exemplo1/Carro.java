package Exemplo_Heranca.Exemplo1;


public class Carro extends Veiculo {
    private int numeroPortas;

    // Construtor para inicializar os atributos da classe pai e da classe filha
    public Carro(String marca, String cor, String modelo, int tanque, int numeroPortas) {
        // Chamando o construtor da classe pai (Veiculo)
        super(modelo, marca, cor, tanque);

        // Inicializando o atributo específico da classe filha
        this.numeroPortas = numeroPortas;
    }

    // Métodos de acesso para o atributo "numeroPortas"
    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }
}
