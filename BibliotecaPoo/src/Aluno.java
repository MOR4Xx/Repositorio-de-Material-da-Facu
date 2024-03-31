
public class Aluno extends Usuario {
    private String curso;
    private String matricula;
    private String email;

    public Aluno(int id, String login, String senha, String nome, String sexo, String telefone, int idade, String curso,
            String matricula, String email) {
        super(id, login, senha, nome, sexo, telefone, idade);
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
