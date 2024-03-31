
public class Aluno extends Pessoa {

    private String curso;
    private String matricula;
    private String email;

    public Aluno(String nome, String dataNasc, long cpf, String curso, String matricula, String email) {
        super(nome, dataNasc, cpf);
        this.curso = curso;
        this.matricula = matricula;
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
