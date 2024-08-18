package DAO;
import Models.Estudante;
import Models.Funcionario;
import Models.Professor;
import Models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public int adicionarUsuario(Usuario usuario, String tipoUsuario) throws SQLException {
        String sql = "INSERT INTO Usuarios (nome, idade, sexo, telefone, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, usuario.getNome());
            stmt.setInt(2, usuario.getIdade());
            stmt.setString(3, String.valueOf(usuario.getSexo()));
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, tipoUsuario);
            stmt.executeUpdate();

            try (var rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void adicionarEstudante(Estudante estudante) throws SQLException {
        String usuario = "estudante";
        int usuarioId = adicionarUsuario(estudante, usuario);

        String sql = "INSERT INTO Estudantes (id, curso) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setString(2, estudante.getCurso());
            stmt.executeUpdate();
        }
    }

    public void adicionarProfessor(Professor professor) throws SQLException {
        String usuario = "professor";
        int usuarioId = adicionarUsuario(professor, usuario);

        String sql = "INSERT INTO Professores (id, departamento) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setString(2, professor.getDepartamento());
            stmt.executeUpdate();
        }
    }

    public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        String usuario = "funcionario";
        int usuarioId = adicionarUsuario(funcionario, usuario);

        String sql = "INSERT INTO Funcionarios (id, cargo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setString(2, funcionario.getCargo());
            stmt.executeUpdate();
        }
    }

    public Usuario buscarUsuarioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Usuarios WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"),
                            rs.getString("telefone"));
                    return usuario;
                }
            }
        }
        return null;  // Retorna null se o usuário não for encontrado
    }

}
