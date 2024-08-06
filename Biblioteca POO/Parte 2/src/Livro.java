import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Livro extends Obra implements DAO<Livro> {

    private int id;
    private String titulo;
    private String autores;
    private String area;
    private String editora;
    private int ano;
    private int edicao;
    private int numeroFolhas;
    private boolean emprestimo;

    public Livro(int id, String titulo, String autores, String area, String editora, int ano, int edicao, int numeroFolhas) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.area = area;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
        this.numeroFolhas = numeroFolhas;
        this.emprestimo = false;
    }

    @Override
    public void gravar(Livro livro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt", true));
            writer.write(livro.getId() + "," + livro.getTitulo()+","+ livro.getAutores()+","+livro.getArea()+","+livro.getEditora()+","+livro.getAno()+","+livro.getEdicao()+","+livro.getNumeroFolhas()+","+livro.isEmprestimo()+"\n");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir() {

    }

    @Override
    public Livro ler(int ID) {
        return null;
    }

    @Override
    public void atualizar() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumeroFolhas() {
        return numeroFolhas;
    }

    public void setNumeroFolhas(int numeroFolhas) {
        this.numeroFolhas = numeroFolhas;
    }

    public void abrir() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fechar() {
        System.out.println("O livro está fechado.");
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }
}
