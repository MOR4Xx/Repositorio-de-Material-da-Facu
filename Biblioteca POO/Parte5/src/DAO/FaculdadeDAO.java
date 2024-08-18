package DAO;

import Models.Faculdade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FaculdadeDAO {

    private Connection connection;

    public FaculdadeDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarFaculdade(Faculdade faculdade) throws SQLException {
        String sql = "INSERT INTO Faculdade (nome, estado, cidade) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, faculdade.getNome());
            stmt.setString(2, faculdade.getEstado());
            stmt.setString(3, faculdade.getCidade());
            stmt.executeUpdate();
        }
    }

    public Faculdade buscarFaculdadePorId(long id) throws SQLException {
        String sql = "SELECT * FROM Faculdade WHERE cod = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Faculdade(
                            rs.getLong("cod"),
                            rs.getString("nome"),
                            rs.getString("estado"),
                            rs.getString("cidade")
                    );
                }
            }
        }
        return null; // Retorna null se a faculdade não for encontrada
    }
}
