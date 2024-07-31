package Parte2;

public abstract class Pessoa {
    private String nome;
    private String data_Nasc;
    private String cpf;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData_Nasc() {
        return data_Nasc;
    }
    public void setData_Nasc(String data_Nasc) {
        this.data_Nasc = data_Nasc;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}
