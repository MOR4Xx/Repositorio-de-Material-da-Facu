package DAO;
import Models.Trabalho;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDAO {

    private Connection connection;

    public TrabalhoDAO(Connection connection) {
        this.connection = connection;
    }

    public void adicionarTrabalho(Trabalho trabalho) throws SQLException {
        String sql = "INSERT INTO Trabalho (titulo, faculdade_cod, data_conclusao, aluno_id, orientador_id, curso_cod, local_arquivo, score, quantidade_votos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, trabalho.getTitulo());
            stmt.setLong(2, trabalho.getFaculdade().getCod());
            stmt.setDate(3, Date.valueOf(trabalho.getDataConclusao()));
            stmt.setInt(4, trabalho.getEstudante().getId());
            stmt.setInt(5, trabalho.getOrientador().getId());
            stmt.setLong(6, trabalho.getCurso().getCodCurso());
            stmt.setString(7, trabalho.getLocalArquivo());
            stmt.setInt(8, trabalho.getScore());
            stmt.setInt(9, trabalho.getQuantidadeVotos());
            stmt.executeUpdate();
        }
    }

    public List<Trabalho> listarTrabalhos() throws SQLException {
        List<Trabalho> trabalhos = new ArrayList<>();
        String sql = "SELECT * FROM Trabalho";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Trabalho trabalho = new Trabalho(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        new FaculdadeDAO(connection).buscarFaculdadePorId(rs.getLong("faculdade_cod")),
                        rs.getDate("data_conclusao").toLocalDate(),
                        new UsuarioDAO(connection).buscarUsuarioPorId(rs.getInt("aluno_id")),
                        new UsuarioDAO(connection).buscarUsuarioPorId(rs.getInt("orientador_id")),
                        new CursoDAO(connection).buscarCursoPorId(rs.getLong("curso_cod")),
                        rs.getString("local_arquivo"),
                        rs.getInt("score"),
                        rs.getInt("quantidade_votos")
                );
                trabalhos.add(trabalho);
            }
        }
        return trabalhos;
    }

}
