package Models;
public class MidiaAudio extends Obra
{
    private String tamanho, duracao;

    public MidiaAudio() {
    }

    public MidiaAudio(String tamanho, String duracao) {
        this.tamanho = tamanho;
        this.duracao = duracao;
    }

    public MidiaAudio(String tamanho, String duracao, String titulo, String area, String autores, String editora, int ano) {
        super(titulo, area, autores, editora, ano);
        this.tamanho = tamanho;
        this.duracao = duracao;
    }
    
    public void abrir()
    {
        System.out.println("Vendo Midia Audio");
    }
    
    public void fechar()
    {
        System.out.println("Parando de ver Midia Audio!");
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}