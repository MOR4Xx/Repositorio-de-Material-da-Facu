//Aluno: Jorge Afonso Rabelo de Araujo
//Disciplina: Estrutura de Dados 1
//Data da ultima modificação: 18/03/2024
//Resumo da Classe: Essa classe cria o objeto aluno, que vai ser armazenado dentro da lista, contem a nota e a matricula do aluno

package ListaSimplismenteEncadeada;

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
