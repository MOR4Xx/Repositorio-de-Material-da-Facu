package Parte2;

import java.util.ArrayList;

abstract class Usuario implements DAO {

    private int id;
    private String login;
    private String senha;
    private String nome;
    private String sexo;
    private String telefone;
    private int idade;
    private Livro livros_emp;
    private ArrayList<Usuario> lista_usuario = new ArrayList<>();

    public Usuario(int id, String login, String senha, String nome, String sexo, String telefone, int idade) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.idade = idade;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Livro getLivros_emp() {
        return livros_emp;
    }

    public void setLivros_emp(Livro livros_emp) {
        this.livros_emp = livros_emp;
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
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", idade=" + idade +
                ", livros_emp=" + livros_emp +
                '}';
    }
}
