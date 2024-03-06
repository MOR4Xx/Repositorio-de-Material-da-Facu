package AulasED1.ListaSimplesmenteEncadeada;

public class Aluno {
    private Integer matricula;
    private Double nota;

    public Aluno(Integer matricula, Double nota) {
        this.matricula = matricula;
        this.nota = nota;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "matricula: " + matricula +
                ", nota: " + nota;
    }
}
