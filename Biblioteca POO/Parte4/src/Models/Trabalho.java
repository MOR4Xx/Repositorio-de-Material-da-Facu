package Models;

import java.util.Date;

public class Trabalho {
    private long id;
    private String titTrabalho;
    private Faculdade faculdade;
    private Date dataConclusao;
    private Estudante estudante;
    private Orientador orientador;
    private Curso curso;
    private String localArquivo;
    private int score;
    private int quantVoto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitTrabalho() {
        return titTrabalho;
    }

    public void setTitTrabalho(String titTrabalho) {
        this.titTrabalho = titTrabalho;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
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

    public int getQuantVoto() {
        return quantVoto;
    }

    public void setQuantVoto(int quantVoto) {
        this.quantVoto = quantVoto;
    }
}
