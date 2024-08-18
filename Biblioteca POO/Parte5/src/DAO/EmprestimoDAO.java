package DAO;

import Models.Emprestimo;
import Models.Livro;
import Models.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    private Conexao dao = new Conexao();
    private LivroDAO livroDAO;
    private UsuarioDAO usuarioDAO;

    public void adicionarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO Emprestimos (data_emprestimo, hora_emprestimo, id_livro, id_usuario, data_devolucao) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setTime(2, Time.valueOf(emprestimo.getHoraEmprestimo()));
            stmt.setInt(3, emprestimo.getId());
            stmt.setInt(4, emprestimo.getUsuario());
            stmt.setDate(5, emprestimo.getDataDevolucao() != null ? Date.valueOf(emprestimo.getDataDevolucao()) : null);
            stmt.executeUpdate();
        }

        String updateLivroSql = "UPDATE Livros SET emprestado = TRUE WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(updateLivroSql)) {
            stmt.setInt(1, emprestimo.getId());
            stmt.executeUpdate();
        }
    }

    public void devolverLivro(int emprestimoId) throws SQLException {
        String sql = "UPDATE Emprestimos SET data_devolucao = CURRENT_DATE WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }

        String updateLivroSql = "UPDATE Livros SET emprestado = FALSE WHERE id = (SELECT id_livro FROM Emprestimos WHERE id = ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(updateLivroSql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }
    }

    public List<Emprestimo> listarEmprestimos() throws SQLException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimos";
        try (Statement stmt = dao.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int livro = livroDAO.buscarLivroPorId(rs.getInt("id_livro"));
                int usuario = usuarioDAO.buscarUsuarioPorId(rs.getInt("id_usuario"));

                Emprestimo emprestimo = new Emprestimo(
                        rs.getInt("id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getTime("hora_emprestimo").toLocalTime(),
                        livro,
                        usuario,
                        rs.getDate("data_devolucao") != null ? rs.getDate("data_devolucao").toLocalDate() : null
                );
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }

    public void renovarEmprestimo(int emprestimoId, LocalDate novaDataDevolucao) throws SQLException {
        String sql = "UPDATE Emprestimos SET data_devolucao = ? WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(novaDataDevolucao));
            stmt.setInt(2, emprestimoId);
            stmt.executeUpdate();
        }
    }

    public void devolverEmprestimo(int emprestimoId) throws SQLException {
        String sql = "UPDATE Emprestimos SET data_devolucao = CURRENT_DATE WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }
        String updateLivroSql = "UPDATE Livros SET emprestado = FALSE WHERE id = (SELECT id_livro FROM Emprestimos WHERE id = ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(updateLivroSql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }
    }

    public Emprestimo buscarEmprestimoPorId(int emprestimoId) throws SQLException {
        String sql = "SELECT * FROM Emprestimos WHERE id = ?";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, emprestimoId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int livro = livroDAO.buscarLivroPorId(rs.getInt("id_livro"));
                    int usuario = usuarioDAO.buscarUsuarioPorId(rs.getInt("id_usuario"));

                    return new Emprestimo(
                            rs.getInt("id"),
                            rs.getDate("data_emprestimo").toLocalDate(),
                            rs.getTime("hora_emprestimo").toLocalTime(),
                            livro,
                            usuario,
                            rs.getDate("data_devolucao") != null ? rs.getDate("data_devolucao").toLocalDate() : null
                    );
                }
            }
        }
        return null;
    }
}
