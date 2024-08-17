import java.io.*;

public class Livro extends Obra implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean emprestimo;
    private int edicao;
    private int numFolhas;
    private int id;

    public Livro() {
    }

    public Livro(int id, String titulo, String area, String autores, String editora, int ano, int edicao, int numFolhas, boolean emprestimo) {
        super(titulo, area, autores, editora, ano);
        this.emprestimo = emprestimo;
        this.edicao = edicao;
        this.numFolhas = numFolhas;
        this.id = id;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumFolhas() {
        return numFolhas;
    }

    public void setNumFolhas(int numFolhas) {
        this.numFolhas = numFolhas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos adicionais
    public void abrirLivro() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fecharLivro() {
        System.out.println("O livro está fechado para leitura.");
    }

}
