import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Professor extends Usuario {
    public Professor(int id, String nome, int idade, String sexo, String telefone) {
        super(id, nome, idade, sexo, telefone);
    }

    @Override
    public void gravar(Usuario usuario) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("professores.txt", true));
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
    public Usuario ler(int ID) {
        return null;
    }

    @Override
    public void atualizar() {

    }
}
