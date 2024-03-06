package AulasPoo.Carro;

public class Carro {
    private String Cor;
    private String Tipo;
    private String Placa;
    private Integer NumPorta;
    private Pessoa Dono;

    public Carro() {

    }
    public Carro(String cor, String tipo, String placa, Integer numPorta) {
        this.Cor = cor;
        this.Tipo = tipo;
        this.Placa = placa;
        this.NumPorta = numPorta;
    }



    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        this.Cor = cor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        this.Placa = placa;
    }

    public Integer getNumPorta() {
        return NumPorta;
    }

    public void setNumPorta(Integer numPorta) {
        this.NumPorta = numPorta;
    }

    public Pessoa getDono() {
        return Dono;
    }

    public void setDono(Pessoa dono) {
        this.Dono = dono;
    }

    public void ligar(){
        System.out.println("Carro Ligado!");
    }
    public void desligar(){
        System.out.println("Carro Desligado!");
    }
    public void acelerar(){
        System.out.println("Carro Acelerando!");
    }
    public void frear(){
        System.out.println("Carro Freando!");
    }
    int cambio;
    public int getCambio() {
         System.out.println("Marcha: " + this.cambio);
        return this.cambio;
    }

    public void setCambio(int marcha) {
        this.cambio = marcha;
    }
}


