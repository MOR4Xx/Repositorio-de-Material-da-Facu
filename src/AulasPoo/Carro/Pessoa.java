package AulasPoo.Carro;

import AulasPoo.Carro.Carro;

public class Pessoa {
    private String Nome;
    private String CorCabelo;
    private String Biotipo;
    private Integer idade;
    private Carro carro;

    public Pessoa() {
    }

    public Pessoa(String nome, String corCabelo, String biotipo, Integer idade) {
        this.Nome = nome;
        this.CorCabelo = corCabelo;
        this.Biotipo = biotipo;
        this.idade = idade;
    }

    public Carro getCarro() {
        return carro;
    }
    public void setCarro(Carro carro) {
        this.carro = carro;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCorCabelo() {
        return CorCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.CorCabelo = corCabelo;
    }

    public String getBiotipo() {
        return Biotipo;
    }

    public void setBiotipo(String biotipo) {
        this.Biotipo = biotipo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    void ligarCarro(){
        carro.ligar();
    }
    void desligarCarro(){
        carro.desligar();
    }
    void acelerarCarro(){
        carro.acelerar();
    }
    void frearCarro(){
        carro.frear();
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
