package DAO;
import Models.Emprestimo;

import java.io.*;

public class EmprestimoDAO implements DAO<Emprestimo> {

    private static final String BASE_PATH = "Biblioteca POO/Parte 3/Emprestimos/emprestimo";

    @Override
    public void salvar(Emprestimo emprestimo) {
        try {
            FileOutputStream file = new FileOutputStream(BASE_PATH + emprestimo.getId());
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
}
