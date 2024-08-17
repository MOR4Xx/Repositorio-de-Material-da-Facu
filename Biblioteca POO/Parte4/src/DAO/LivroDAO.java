package DAO;
import Models.Livro;

import java.io.*;

public class LivroDAO implements DAO<Livro> {

    private static final String FILE_PATH = "Biblioteca POO\\Parte 3\\Livros\\livro";

    @Override
    public void salvar(Livro livro) {
        try {
            FileOutputStream file = new FileOutputStream(FILE_PATH + livro.getId());
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
        File file = new File(FILE_PATH + id);
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
            FileInputStream file = new FileInputStream(FILE_PATH + id);
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
}

