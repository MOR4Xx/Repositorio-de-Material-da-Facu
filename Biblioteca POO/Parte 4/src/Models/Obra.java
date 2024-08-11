package Models;
public abstract class Obra 
{
    private String titulo, area, autores, editora;
    private int ano;
    
    public Obra() {
    }

    public Obra(String titulo, String area, String autores, String editora, int ano) {
        this.titulo = titulo;
        this.area = area;
        this.autores = autores;
        this.editora = editora;
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
    public void abrir()
    {
        System.out.println("Abrir");
    }
    
    public void fechar()
    {
        System.out.println("Fechar");
    }
}