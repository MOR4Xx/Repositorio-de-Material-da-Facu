import java.io.*;

public class Professor extends Usuario {
    public Professor(int id, String nome, int idade, String sexo, String telefone) {
        super(id, nome, idade, sexo, telefone);
    }

    public void gravar(Usuario usuario) {
        try {
            FileOutputStream file = new FileOutputStream( "Biblioteca POO/Parte 2/Professores/professor"+ usuario.getId());
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
        File file = new File("Biblioteca POO/Parte 2/Professores/professor" + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Professor excluído com sucesso!";
            } else {
                return "Falha ao excluir o professor.";
            }
        } else {
            return "Professor não encontrado.";
        }
    }

    @Override
    public void atualizar() {

    }

    @Override
    public Professor ler(int id) {
        try {
            FileInputStream file = new FileInputStream( "Biblioteca POO/Parte 2/Professores/professor"+ id);
            ObjectInputStream stream = new ObjectInputStream(file);
            Professor professor = (Professor) stream.readObject();
            stream.close();
            file.close();
            return professor;
        } catch (Exception erro) {
            System.out.println("Falha na leitura\n " + erro.toString());
            return null;
        }
    }
}
