package DAO;
import Models.Curso;
import Models.Faculdade;
import Models.Trabalho;
import Models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabalhoDAO {

    private Conexao dao = new Conexao();
    private FaculdadeDAO faculdadeDAO;
    private UsuarioDAO usuarioDAO;
    private CursoDAO cursoDAO;

    public void adicionarTrabalho(Trabalho trabalho) throws SQLException {
        String sql = "INSERT INTO Trabalho (titulo, faculdade_cod, data_conclusao, aluno_id, orientador_id, curso_cod, local_arquivo, score, quantidade_votos) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dao.getConnection().prepareStatement(sql)) {
            stmt.setString(1, trabalho.getTitulo());
            stmt.setLong(2, trabalho.getFaculdade().getCod());
            stmt.setDate(3, Date.valueOf(trabalho.getDataConclusao()));
            stmt.setInt(4, trabalho.getId());
            stmt.setInt(5, trabalho.getId());
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
        try (Statement stmt = dao.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Faculdade faculdade = faculdadeDAO.buscarFaculdadePorId(rs.getInt("faculdade_cod"));
                int estudante = usuarioDAO.buscarUsuarioPorId(rs.getInt("aluno_id"));
                int orientador = usuarioDAO.buscarUsuarioPorId(rs.getInt("orientador_id"));
                Curso curso = cursoDAO.buscarCursoPorId(rs.getLong("curso_cod"));

                Trabalho trabalho = new Trabalho(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        faculdade,
                        rs.getDate("data_conclusao").toLocalDate(),
                        estudante,
                        orientador,
                        curso,
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
