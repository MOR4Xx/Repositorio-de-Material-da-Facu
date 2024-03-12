package AulasPoo.Polimorfismo.Exemplo1;

public class ControleRemoto {
    private Brinquedo brinquedo;
    public ControleRemoto (Brinquedo b){
        this.brinquedo = b;
    }
    public void mover(){
        brinquedo.mover();
    }
}
