package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimo {

    private int id;
    private LocalDate dataEmprestimo;
    private LocalTime horaEmprestimo;
    private int livro;
    private int usuario;
    private LocalDate dataDevolucao;

    public Emprestimo(int id, LocalDate dataEmprestimo, LocalTime horaEmprestimo, int livro, int usuario, LocalDate dataDevolucao) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataDoEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalTime getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(LocalTime horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getLivro() {
        return livro;
    }

    public int getUsuario() {
        return usuario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}