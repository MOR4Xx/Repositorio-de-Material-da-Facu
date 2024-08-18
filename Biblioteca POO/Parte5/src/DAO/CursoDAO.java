package DAO;

import Models.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAO {
    private Conexao dao = new Conexao();

    public void adicionarCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO Curso (tituloCurso, areaConhecimento) VALUES (?, ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setString(1, curso.getTituloCurso());
            stmt.setString(2, String.valueOf(curso.getAreaConhecimento()));
            stmt.executeUpdate();
        }
    }

    public Curso buscarCursoPorId(long id) throws SQLException {
        String sql = "SELECT * FROM Curso WHERE codCurso = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Curso(
                            rs.getInt("codCurso"),
                            rs.getString("tituloCurso"),
                            rs.getString("areaConhecimento")
                    );
                }
            }
        }
        return null;
    }

    public Curso buscarCursoPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM Cursos WHERE nome LIKE ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");  // Usando LIKE para permitir buscas parciais
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Curso(
                            rs.getInt("codCurso"),
                            rs.getString("tituloCurso"),
                            rs.getString("areaConhecimento")
                    );
                }
            }
        }
        return null;  // Retorna null se nenhum curso for encontrado
    }
}

