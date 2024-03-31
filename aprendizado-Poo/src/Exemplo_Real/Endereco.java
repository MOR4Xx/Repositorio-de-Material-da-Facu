package Exemplo_Real;

public class Endereco {

    public enum TipoEndereco{RESIDENCIAL, TRABALHO};
    public String endereço;
    public String numero_end;
    public String complemento;
    public String bairro;
    public String cidade;
    public String pais;
    public Endereco(String endereço, String numero_end, String complemento, String bairro, String cidade, String pais) {
        this.endereço = endereço;
        this.numero_end = numero_end;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.pais = pais;
    }
    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
