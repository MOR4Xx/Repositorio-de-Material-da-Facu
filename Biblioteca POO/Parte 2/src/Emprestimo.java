
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimo implements DAO<Emprestimo>{
    private int id;
    private String dataEmprestimo;
    private String horaEmprestimo;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(int ID, String dataEmprestimo, String horaEmprestimo, Livro livro, Usuario usuario) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
    }

    @Override
    public void gravar(Emprestimo emprestimo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("estudantes.txt", true));
            writer.write(usuario.getId() + "," + usuario.getNome() + "," + usuario.getIdade() + "," + usuario.getSexo() + "," + usuario.getTelefone());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir() {

    }

    @Override
    public Emprestimo ler(int ID) {
        return null;
    }

    @Override
    public void atualizar() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



    public void devolverLivro() {
        livro.setEmprestimo(false);
        System.out.println("Livro devolvido.");
    }
}
