package Models;

import java.util.Date;

public class Orientador extends Usuario{
    private String email;

    public Orientador(int id, String nome, int idade, String sexo, String telefone, String email, String cpf) {
        super(id, nome, idade, sexo, telefone, cpf);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
