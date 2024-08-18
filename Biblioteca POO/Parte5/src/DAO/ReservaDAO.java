package DAO;
import Models.Reserva;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    private Conexao dao = new Conexao();

    public void adicionarReserva(Reserva reserva) throws SQLException {
        String sql = "INSERT INTO Reservas (id_livro, id_usuario) VALUES (?, ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, reserva.getId());
            stmt.setInt(2, reserva.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarReserva(int id) throws SQLException {
        String sql = "DELETE FROM Reservas WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Reserva> listarReservas() throws SQLException {
        List<Reserva> reservas = new ArrayList<>();
        String sql = "SELECT * FROM Reservas";
        try (Statement stmt = dao.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reserva reserva = new Reserva(rs.getInt("id"),rs.getInt("id_livro"),
                        rs.getInt("id_usuario"), rs.getDate("data_reserva").toLocalDate());
                reservas.add(reserva);
            }
        }
        return reservas;
    }
}
