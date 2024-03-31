public class Fotografia extends Obra {
    private String resolucao;
    private String tipo_imagem;

    public Fotografia(String titulo, String autor, String resolucao, String tipo_imagem) {
        super(titulo, autor);
        this.resolucao = resolucao;
        this.tipo_imagem = tipo_imagem;
    }

    public void vizualizar() {
        System.out.println("Vizualizando");
    }

    public void darZoom() {
        System.out.println("Dando zoom");
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getTipo_imagem() {
        return tipo_imagem;
    }

    public void setTipo_imagem(String tipo_imagem) {
        this.tipo_imagem = tipo_imagem;
    }

}
