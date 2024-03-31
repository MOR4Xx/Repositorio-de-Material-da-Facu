import java.util.ArrayList;

public class Emprestimos implements DAO {

    private String dataEmprestimo, horaEmprestimo;
    public Livro livro;
    private Usuario usuario;
    private ArrayList<Emprestimos> lista_emp = new ArrayList<>();

    public Emprestimos(String dataEmprestimo, String horaEmprestimo, Livro livro, Usuario usuario) {
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
    }

    @Override
    public void atualizar() {
        System.out.println("Atualizar...");

    }

    @Override
    public void excluir(Object x) {
        System.out.println("Excluindo...");
        for(Emprestimos i: lista_emp){
            if (x.equals(i)){
                lista_emp.remove(i);
                break;
            }
        }
    }

    @Override
    public void gravar(Object x) {
        System.out.println("Gravar...");
        lista_emp.add((Emprestimos) x);

    }

    @Override
    public void ler() {
        System.out.println("Lendo...");

    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(String horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean devolverLivro() {
        System.out.println("O livro foi devolvido!");
        return false;
    }

}
