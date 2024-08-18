package DAO;

import Models.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAO {

    private Connection connection;

    public CursoDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarCurso(Curso curso) throws SQLException {
        String sql = "INSERT INTO Curso (tituloCurso, areaConhecimento) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, curso.getTituloCurso());
            stmt.setString(2, String.valueOf(curso.getAreaConhecimento()));
            stmt.executeUpdate();
        }
    }

    public Curso buscarCursoPorId(long id) throws SQLException {
        String sql = "SELECT * FROM Curso WHERE codCurso = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
}
