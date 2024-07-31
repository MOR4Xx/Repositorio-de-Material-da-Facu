package Parte2;

import java.util.ArrayList;

public class Livro extends Obra implements DAO{

    private String area, editora;
    private int ano, edicao, nPaginas;
    private Boolean emprestimo;
    private ArrayList<Livro> lista_Livros = new ArrayList<>();

    public Livro(String titulo, String autor, String area, String editora, int ano, int edicao, int nPaginas) {
        super(titulo, autor);
        this.area = area;
        this.editora = editora;
        this.ano = ano;
        this.edicao = edicao;
        this.nPaginas = nPaginas;
        this.emprestimo = false;
    }

    @Override
    public void atualizar() {
        System.out.println("Atualizar...");

    }

    @Override
    public void excluir(Object x) {
        System.out.println("Excluindo...");
        for(Livro i: lista_Livros){
            if (x.equals(i)){
                lista_Livros.remove(i);
                break;
            }
        }
    }

    @Override
    public void gravar(Object x) {
        lista_Livros.add((Livro) x);
    }

    @Override
    public void ler() {
        System.out.println("Lendo...");

    }

    public void abreLivro() {
        System.out.println("O livro está aberto!");
        System.out.println("O usuário está lendo o livro...");
    }

    public void fechaLivro() {
        System.out.println("O livro está fechado!");
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

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public Boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

}
