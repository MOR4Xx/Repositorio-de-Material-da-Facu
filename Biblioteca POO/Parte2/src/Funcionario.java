import java.io.*;

public class Funcionario extends Usuario {

    public Funcionario(int id, String nome, int idade, String sexo, String telefone) {
        super(id,nome, idade, sexo, telefone);
    }

    public void gravar(Usuario usuario) {
        try {
            FileOutputStream file = new FileOutputStream( "Biblioteca POO/Parte 2/Funcionarios/funcionario"+ usuario.getId());
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
        File file = new File("Biblioteca POO/Parte 2/Funcionarios/funcionario" + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Funcionario excluído com sucesso!";
            } else {
                return "Falha ao excluir o Funcionario.";
            }
        } else {
            return "Funcionario não encontrado.";
        }
    }

    @Override
    public void atualizar() {

    }

    @Override
    public Usuario ler(int id) {
        try {
            FileInputStream file = new FileInputStream( "Biblioteca POO/Parte 2/Funcionarios/funcionario"+ id);
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
