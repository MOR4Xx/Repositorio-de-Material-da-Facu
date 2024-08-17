
import java.io.*;

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
            FileOutputStream file = new FileOutputStream( "Biblioteca POO/Parte 2/Emprestimos/emprestimo"+ emprestimo.getId());
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(emprestimo);
            stream.flush();
            stream.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) {
        File file = new File("Biblioteca POO/Parte 2/Emprestimos/emprestimo" + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Empréstimo excluído com sucesso!";
            } else {
                return "Falha ao excluir o empréstimo.";
            }
        } else {
            return "Empréstimo não encontrado.";
        }
    }

    @Override
    public Emprestimo ler(int ID) {
        try {
            FileInputStream file = new FileInputStream( "Biblioteca POO/Parte 2/Emprestimos/emprestimo"+ id);
            ObjectInputStream stream = new ObjectInputStream(file);
            Emprestimo emprestimo = (Emprestimo) stream.readObject();
            stream.close();
            file.close();
            return emprestimo;
        } catch (Exception erro) {
            System.out.println("Falha na leitura\n " + erro.toString());
            return null;
        }
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
