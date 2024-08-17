import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements DAO<Livro> {

    private static final String FILE_PATH = ("Biblioteca POO/Parte 3/Livros/");

    @Override
    public void salvar(Livro livro) {
        try {
            File filenew = new File(FILE_PATH + livro.getId() + ".txt");

            FileOutputStream file = new FileOutputStream(filenew);
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(livro);
            stream.flush();
            stream.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) {
        File file = new File(FILE_PATH + id + ".txt");
        if (file.exists()) {
            if (file.delete()) {
                return "Livro excluído com sucesso!";
            } else {
                return "Falha ao excluir o livro.";
            }
        } else {
            return "Livro não encontrado.";
        }
    }

    @Override
    public Livro ler(int id) {
        try {
            FileInputStream file = new FileInputStream(FILE_PATH + id + ".txt");
            ObjectInputStream stream = new ObjectInputStream(file);
            return (Livro) stream.readObject();
        } catch (Exception erro) {
            System.out.println("Falha na leitura\n " + erro.toString());
            return null;
        }
    }

    @Override
    public void atualizar(Livro livro) {
        excluir(livro.getId());
        salvar(livro);
    }

    public List<Livro> listarLivros() {
        List<Livro> livros = new ArrayList<>();
        File directory = new File(FILE_PATH);

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    // Deserializa o objeto Livro
                    FileInputStream fileInputStream = new FileInputStream(file);
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Livro livro = (Livro) objectInputStream.readObject();
                    livros.add(livro);
                    objectInputStream.close();
                    fileInputStream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("Erro ao ler o arquivo: " + file.getName());
                }
            }
        }

        return livros;
    }
}

