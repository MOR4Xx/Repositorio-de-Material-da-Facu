package DAO;
import Models.Estudante;
import Models.Funcionario;
import Models.Professor;
import Models.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {

    private static final String BASE_PATH = "Biblioteca POO/Parte 3/Usuarios/usuario";

    @Override
    public void salvar(Usuario usuario) {
        try {
            FileOutputStream file = new FileOutputStream(BASE_PATH + usuario.getId());
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
    public String excluir(int id){
        File file = new File(BASE_PATH + id);
        if (file.exists()) {
            if (file.delete()) {
                return "Usuário excluído com sucesso!";
            } else {
                return "Falha ao excluir o usuário.";
            }
        } else {
            return "Usuário não encontrado.";
        }
    }

    @Override
    public Usuario ler(int id) {
        try {
            FileInputStream file = new FileInputStream(BASE_PATH + id);
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

    @Override
    public void atualizar(Usuario usuario) {
        excluir(usuario.getId());
        salvar(usuario);
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        File dir = new File("Biblioteca POO/Parte 3/Usuarios/");
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("usuario"));

        if (files != null) {
            for (File file : files) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Usuario usuario = (Usuario) ois.readObject();
                    usuarios.add(usuario);
                    ois.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return usuarios;
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
