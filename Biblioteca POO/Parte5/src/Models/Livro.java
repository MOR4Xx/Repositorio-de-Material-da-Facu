package Models;

public class Livro extends Obra {

    private boolean emprestimo;
    private boolean digital;
    private String edicao;
    private int numFolhas;
    private int id;

    public Livro(int id, String titulo, String autores, String area, String editora, int ano,
                 String edicao, int numFolhas, boolean emprestado, boolean digital) {
        super(titulo, autores, area, editora, ano);
        this.id = id;
        this.edicao = edicao;
        this.numFolhas = numFolhas;
        this.emprestimo = emprestado;
        this.digital = digital;

    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public boolean isDigital() {
        return digital;
    }

    public String getEdicao() {
        return edicao;
    }

    public int getNumFolhas() {
        return numFolhas;
    }

    public int getId() {
        return id;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public void abrirLivro() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fecharLivro() {
        System.out.println("O livro está fechado para leitura.");
    }

}
