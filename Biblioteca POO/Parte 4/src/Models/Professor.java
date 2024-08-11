package Models;
public class Professor extends Usuario
{
    private String departamento;
    private String especializacao;

    public Professor(int id, String nome, int idade, String sexo, String telefone, String departamento, String especializacao) {
        super(id, nome, idade, sexo, telefone);
        this.departamento = departamento;
        this.especializacao = especializacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}