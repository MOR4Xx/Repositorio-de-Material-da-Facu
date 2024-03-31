
public class Funcionario extends Usuario {
    private String cargo;
    private String cpf;

    public Funcionario(int id, String login, String senha, String nome, String sexo, String telefone, int idade,
            String cargo, String cpf) {
        super(id, login, senha, nome, sexo, telefone, idade);
        this.cargo = cargo;
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
