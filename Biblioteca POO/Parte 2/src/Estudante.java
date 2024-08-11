import java.io.*;

public class Estudante extends Usuario {

    public Estudante(int id, String nome, int idade, String sexo, String telefone) {
        super(id, nome, idade, sexo, telefone);
    }

    @Override
    public void gravar(Usuario usuario) {
        try {
            FileOutputStream file = new FileOutputStream( "Biblioteca POO/Parte 2/Estudantes/estudante"+ usuario.getId());
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(usuario);
            stream.flush();
            stream.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) {
        File file = new File("Biblioteca POO/Parte 2/Estudantes/estudante" + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Estudante excluído com sucesso!";
            } else {
                return "Falha ao excluir o estudante.";
            }
        } else {
            return "Estudante não encontrado.";
        }
    }

    @Override
    public void atualizar() {

    }

    @Override
    public Usuario ler(int id) {
        try {
            FileInputStream file = new FileInputStream( "Biblioteca POO/Parte 2/Estudantes/estudante"+ id);
            ObjectInputStream stream = new ObjectInputStream(file);
            Usuario usuario = (Usuario) stream.readObject();
            stream.close();
            file.close();
            return usuario;
        } catch (Exception erro) {
            System.out.println("Falha na leitura\n " + erro.toString());
            return null;
        }
    }
}
