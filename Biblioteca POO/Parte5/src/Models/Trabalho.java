package Models;

import java.time.LocalDate;

public class Trabalho {
    private int id;
    private String titulo;
    private Faculdade faculdade;
    private LocalDate dataConclusao;
    private Usuario estudante;
    private Usuario orientador;
    private Curso curso;
    private String localArquivo;
    private int score;
    private int quantidadeVotos;

    public Trabalho(int id, String titulo, Faculdade faculdadeCod, LocalDate dataConclusao, Usuario alunoId,
                    Usuario orientadorId, Curso cursoCod, String localArquivo, int score, int quantidadeVotos) {
        this.id = id;
        this.titulo = titulo;
        this.faculdade = faculdadeCod;
        this.dataConclusao = dataConclusao;
        this.estudante = alunoId;


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

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Usuario getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Usuario getOrientador() {
        return orientador;
    }

    public void setOrientador(Usuario orientador) {
        this.orientador = orientador;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getLocalArquivo() {
        return localArquivo;
    }

    public void setLocalArquivo(String localArquivo) {
        this.localArquivo = localArquivo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuantidadeVotos() {
        return quantidadeVotos;
    }

    public void setQuantidadeVotos(int quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }
}
