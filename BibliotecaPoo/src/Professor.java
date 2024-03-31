
public class Professor extends Usuario {
    private String materia;
    private String especializacao;

    public Professor(int id, String login, String senha, String nome, String materia, String especializacao) {
        super(id, login, senha, nome);
        this.materia = materia;
        this.especializacao = especializacao;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "\nid=" + super.getId() +
                "\nlogin=" + super.getLogin() +
                "\nsenha=" + super.getSenha() +
                "\nnome=" + super.getNome() +
                "\nmateria=" + materia +
                "\nespecializacao=" + especializacao;
    }
}
