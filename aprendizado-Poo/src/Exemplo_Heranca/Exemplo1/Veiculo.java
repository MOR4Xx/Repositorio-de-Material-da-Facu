package Exemplo_Heranca.Exemplo1;

class Veiculo {
    private String modelo;
    private String marca;
    private String cor;
    private int tanque;

    public Veiculo(String Modelo, String Marca, String Cor, int Tanque) {
        this.modelo = Modelo;
        this.marca = Marca;
        this.cor = Cor;
        this.tanque = Tanque;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public int getTanque() {
        return tanque;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }
}
