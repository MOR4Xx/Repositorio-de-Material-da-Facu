import java.io.*;

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

    public void gravar(Livro livro) {
        try {
            FileOutputStream file = new FileOutputStream( "Biblioteca POO/Parte 2/Livros/livro"+ livro.getId());
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(livro);
            stream.flush();
            stream.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) {
        File file = new File("Biblioteca POO/Parte 2/Livros/livro" + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Livro excluído com sucesso!";
            } else {
                return "Falha ao excluir o Livro.";
            }
        } else {
            return "Livro não encontrado.";
        }
    }

    @Override
    public void atualizar() {

    }

    @Override
    public Livro ler(int id) {
        try {
            FileInputStream file = new FileInputStream( "Biblioteca POO/Parte 2/Livros/livro"+ id);
            ObjectInputStream stream = new ObjectInputStream(file);
            Livro livro = (Livro) stream.readObject();
            stream.close();
            file.close();
            return livro;
        } catch (Exception erro) {
            System.out.println("Falha na leitura\n " + erro.toString());
            return null;
        }
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
