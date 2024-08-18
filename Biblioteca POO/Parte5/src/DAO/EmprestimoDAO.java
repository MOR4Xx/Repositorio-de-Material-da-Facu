package DAO;
import Models.Emprestimo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {

    private Connection connection;

    public EmprestimoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para adicionar um empréstimo
    public void adicionarEmprestimo(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO Emprestimos (data_emprestimo, hora_emprestimo, id_livro, id_usuario, data_devolucao) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setTime(2, Time.valueOf(emprestimo.getHoraEmprestimo()));
            stmt.setInt(3, emprestimo.getLivro().getId());
            stmt.setInt(4, emprestimo.getUsuario().getId());
            stmt.setDate(5, emprestimo.getDataDevolucao() != null ? Date.valueOf(emprestimo.getDataDevolucao()) : null);
            stmt.executeUpdate();
        }

        // Atualizar o status do livro para emprestado
        String updateLivroSql = "UPDATE Livros SET emprestado = TRUE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateLivroSql)) {
            stmt.setInt(1, emprestimo.getLivro().getId());
            stmt.executeUpdate();
        }
    }

    // Método para devolver um livro
    public void devolverLivro(int emprestimoId) throws SQLException {
        // Atualizar a data de devolução no empréstimo
        String sql = "UPDATE Emprestimos SET data_devolucao = CURRENT_DATE WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }

        // Marcar o livro como não emprestado
        String updateLivroSql = "UPDATE Livros SET emprestado = FALSE WHERE id = (SELECT id_livro FROM Emprestimos WHERE id = ?)";
        try (PreparedStatement stmt = connection.prepareStatement(updateLivroSql)) {
            stmt.setInt(1, emprestimoId);
            stmt.executeUpdate();
        }
    }

    // Método para listar todos os empréstimos
    public List<Emprestimo> listarEmprestimos() throws SQLException {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo(
                        rs.getInt("id"),
                        rs.getDate("data_emprestimo").toLocalDate(),
                        rs.getTime("hora_emprestimo").toLocalTime(),
                        new LivroDAO(connection).buscarLivroPorId(rs.getInt("id_livro")),
                        new UsuarioDAO(connection).buscarUsuarioPorId(rs.getInt("id_usuario")),
                        rs.getDate("data_devolucao") != null ? String.valueOf(rs.getDate("data_devolucao").toLocalDate()) : null
                );
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }
}
