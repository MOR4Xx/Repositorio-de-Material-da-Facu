package Models;

public class Fotografia extends Obra
{
    private int tamanho;
    private String resolucao;
    private String formato;

    public Fotografia() {
    }

    public Fotografia(int tamanho, String resolucao, String formato) {
        this.tamanho = tamanho;
        this.resolucao = resolucao;
        this.formato = formato;
    }

    public Fotografia(int tamanho, String resolucao, String formato, String titulo, String area, String autores, String editora, int ano) {
        super(titulo, area, autores, editora, ano);
        this.tamanho = tamanho;
        this.resolucao = resolucao;
        this.formato = formato;
    }
    
    public void abrir()
    {
        System.out.println("A fotografia está sendo visualizada!");
    }
    
    public void fechar()
    {
        System.out.println("A visualização foi fechada!");
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}