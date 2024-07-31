package Parte2;

public class Faculdade {
    private int cod;
    private String nome, cidade, estado;

    public Faculdade(int cod, String nome, String cidade, String estado) {
        this.cod = cod;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
