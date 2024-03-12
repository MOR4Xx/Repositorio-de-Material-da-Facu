package AulasPoo.Polimorfismo.Exemplo1;

public class Brinquedo {
    private Double velocidade;
    private Double aceleracao;

    public Brinquedo(){

    }
    public Brinquedo(int velocidade){
        this.velocidade = (double) velocidade;
    }

    public Brinquedo(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Brinquedo(Float velocidade, Double aceleracao) {
        this.velocidade = Double.valueOf(velocidade);
        this.aceleracao = aceleracao;
    }

    public void mover(){

    }
    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(Double aceleracao) {
        this.aceleracao = aceleracao;
    }
}
