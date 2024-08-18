package DAO;
import Models.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO Livros (titulo, autores, area, editora, ano, edicao, num_folhas, emprestado, digital) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutores());
            stmt.setString(3, livro.getArea());
            stmt.setString(4, livro.getEditora());
            stmt.setInt(5, livro.getAno());
            stmt.setString(6, livro.getEdicao());
            stmt.setInt(7, livro.getNumFolhas());
            stmt.setBoolean(8, livro.isEmprestimo());
            stmt.setBoolean(9, livro.isDigital());
            stmt.executeUpdate();
        }
    }

    public void atualizarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE Livros SET titulo = ?, autores = ?, area = ?, editora = ?, ano = ?, edicao = ?, num_folhas = ?, emprestado = ?, digital = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutores());
            stmt.setString(3, livro.getArea());
            stmt.setString(4, livro.getEditora());
            stmt.setInt(5, livro.getAno());
            stmt.setString(6, livro.getEdicao());
            stmt.setInt(7, livro.getNumFolhas());
            stmt.setBoolean(8, livro.isEmprestimo());
            stmt.setBoolean(9, livro.isDigital());
            stmt.setInt(10, livro.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarLivro(int id) throws SQLException {
        String sql = "DELETE FROM Livros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Livro> listarLivros() throws SQLException {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livros";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Livro livro = new Livro(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autores"),
                        rs.getString("area"),
                        rs.getString("editora"),
                        rs.getInt("ano"),
                        rs.getString("edicao"),
                        rs.getInt("num_folhas"),
                        rs.getBoolean("emprestado"),
                        rs.getBoolean("digital")
                );
                livros.add(livro);
            }
        }
        return livros;
    }

    public int buscarLivroPorId(int id) throws SQLException {
        String sql = "SELECT * FROM Livros WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

}


