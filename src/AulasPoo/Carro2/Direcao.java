package AulasPoo.Carro2;

public class Direcao {
    private String cor;
    private int tamRaio;
    private boolean kitMultimidia;

    public Direcao() {
    }

    public Direcao(String cor, int tamRaio, boolean kitMultimidia) {
        this.cor = cor;
        this.tamRaio = tamRaio;
        this.kitMultimidia = kitMultimidia;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamRaio() {
        return tamRaio;
    }

    public void setTamRaio(int tamRaio) {
        this.tamRaio = tamRaio;
    }

    public boolean isKitMultimidia() {
        return kitMultimidia;
    }

    public void setKitMultimidia(boolean kitMultimidia) {
        this.kitMultimidia = kitMultimidia;
    }
}
