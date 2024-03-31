package Exemplo_Real;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;

    private List<Endereco> enderecosList;

    public Cliente(int id, String nome, String cpf, List<Endereco> enderecoList) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.enderecosList= enderecoList;
    }
    public void adicionarEndereco(Endereco endereco){
        if(endereco ==null){
            throw new NullPointerException("Endereço não pode ser nulo!");
        }else {getEnderecosList().add(endereco);}
    }
    private List<Endereco> getEnderecosList() {
        if(enderecosList == null){
            enderecosList = new ArrayList<>();
        }
        return enderecosList;
    }

    public void setEnderecosList(List<Endereco> enderecosList) {
        this.enderecosList = enderecosList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
