
import java.io.*;

public class UsuarioDAO implements DAO<Usuario> {

    @Override
    public void salvar(Usuario usuario) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true));
            writer.write(usuario.getId() + "," + usuario.getNome() + "," + usuario.getIdade() + "," + usuario.getSexo() + ","
                    + usuario.getTelefone() + "," + getUsuarioType(usuario) + "," + getUserSpecificInfo(usuario));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void excluir(int id){

        try {
            File inputFile = new File("usuarios.txt");
            File tempFile = new File("usuarios_temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (Integer.parseInt(data[0]) == id) {
                    continue;
                }
                writer.write(currentLine);
                writer.newLine();
                reader.close();
                tempFile.renameTo(inputFile);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Usuario ler(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (Integer.parseInt(data[0]) == id) {
                    reader.close();
                    return createUserFromData(data);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void atualizar(Usuario usuario) {
        excluir(usuario.getId());
        salvar(usuario);
    }

    private String getUsuarioType(Usuario usuario) {
        if (usuario instanceof Estudante) {
            return "Aluno";
        } else if (usuario instanceof Professor) {
            return "Professor";
        } else if (usuario instanceof Funcionario) {
            return "Funcionario";
        }
        return "";
    }

    private String getUserSpecificInfo(Usuario usuario) {
        if (usuario instanceof Estudante) {
            Estudante aluno = (Estudante) usuario;
            return aluno.getCurso() + "," + aluno.getAnoDeIngresso();
        } else if (usuario instanceof Professor) {
            Professor professor = (Professor) usuario;
            return professor.getDepartamento() + "," + professor.getEspecializacao();
        } else if (usuario instanceof Funcionario) {
            Funcionario funcionario = (Funcionario) usuario;
            return funcionario.getSetor() + "," + funcionario.getCargo();
        }
        return "";
    }

    private Usuario createUserFromData(String[] data) {
        int id = Integer.parseInt(data[0]);
        String nome = data[1];
        int idade = Integer.parseInt(data[2]);
        String sexo = data[3];
        String telefone = data[4];
        String tipo = data[5];

        switch (tipo) {
            case "Aluno":
                String curso = data[6];
                int anoDeIngresso = Integer.parseInt(data[7]);
                return new Estudante(id, nome, idade, sexo, telefone, curso, anoDeIngresso);
            case "Professor":
                String departamento = data[6];
                String especializacao = data[7];
                return new Professor(id, nome, idade, sexo, telefone, departamento, especializacao);
            case "Funcionario":
                String setor = data[6];
                String cargo = data[7];
                return new Funcionario(id, nome, idade, sexo, telefone, setor, cargo);
            default:
                return null;
        }
    }
}
