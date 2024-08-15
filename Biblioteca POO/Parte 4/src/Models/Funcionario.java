package Models;
public class Funcionario extends Usuario
{
    private String setor;
    private String cargo;

    public Funcionario(int id, String nome, int idade, String sexo, String telefone, String setor, String cargo) {
        super(id, nome, idade, sexo, telefone);
        this.setor = setor;
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}