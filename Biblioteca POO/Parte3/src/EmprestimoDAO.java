import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private static final String BASE_PATH = "Biblioteca POO/Parte 3/Emprestimos/";

    @Override
    public void salvar(Emprestimo emprestimo) {
        try {
            File filenew = new File(BASE_PATH + emprestimo.getId() + ".txt");

            FileOutputStream file = new FileOutputStream(filenew);
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
        File file = new File(BASE_PATH + id);
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
    public Emprestimo ler(int id) {
        try {
            FileInputStream file = new FileInputStream(BASE_PATH + id);
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
    public void atualizar(Emprestimo emprestimo) {
        excluir(emprestimo.getId());
        salvar(emprestimo);
    }
    public List<Emprestimo> listarEmprestimos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        File directory = new File(BASE_PATH);

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Emprestimo emprestimo = (Emprestimo) objectInputStream.readObject();
                    emprestimos.add(emprestimo);
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Erro ao ler o arquivo: " + file.getName());
                }
            }
        }

        return emprestimos;
    }
}
