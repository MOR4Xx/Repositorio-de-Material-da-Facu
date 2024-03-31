import java.util.ArrayList;

abstract class Usuario implements DAO {

    private int id;
    private String login;
    private String senha;
    private String nome;

    private ArrayList<Usuario> lista_usuario = new ArrayList<>();

    public Usuario(int id, String login, String senha, String nome) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;

    }

    @Override
    public void atualizar() {
        System.out.println("Atualizar...");
    }


    @Override
    public void excluir(Object x) {
        System.out.println("Excluindo...");
        for(Usuario i: lista_usuario){
            if (x.equals(i)){
                lista_usuario.remove(i);
                break;
            }
        }
    }

    @Override
    public void gravar(Object x) {
        lista_usuario.add((Usuario) x);
    }

    @Override
    public void ler() {
        System.out.println("Lendo...");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void lerLivro() {
        System.out.println("O usuário está lendo o livro");
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
