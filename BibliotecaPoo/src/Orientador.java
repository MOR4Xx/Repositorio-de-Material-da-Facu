public class Orientador extends Pessoa{
    private int id;
    private String email;

    public Orientador(String nome, String data_Nasc, long cpf, int id, String email) {
        super(nome, data_Nasc, cpf);
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
