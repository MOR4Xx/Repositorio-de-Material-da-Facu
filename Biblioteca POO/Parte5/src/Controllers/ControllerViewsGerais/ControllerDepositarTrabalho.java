package Controllers.ControllerViewsGerais;

import DAO.CursoDAO;
import DAO.FaculdadeDAO;
import DAO.TrabalhoDAO;
import DAO.UsuarioDAO;
import Models.Curso;
import Models.Faculdade;
import Models.Trabalho;
import View.ViewsGerais.DepositarTrabalhoView;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerDepositarTrabalho {
    private DepositarTrabalhoView view;
    private TrabalhoDAO trabalhoDAO;
    private FaculdadeDAO faculdadeDAO;
    private UsuarioDAO usuarioDAO;
    private CursoDAO cursoDAO;

    public ControllerDepositarTrabalho(DepositarTrabalhoView view) {
        this.view = view;
        this.trabalhoDAO = new TrabalhoDAO();
        this.faculdadeDAO = new FaculdadeDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.cursoDAO = new CursoDAO();
        initController();
    }

    private void initController() {
        view.getDepositarButton().addActionListener(e -> depositarTrabalho());
    }

    private void depositarTrabalho() {
        String titulo = view.getTituloField().getText();
        String autor = view.getAutorField().getText();
        String ano = view.getAnoField().getText();
        String editora = view.getEditoraField().getText();
        String orientadorNome = view.getOrientadorField().getText();
        String cursoNome = view.getCursoField().getText();
        String palavrasChave = view.getPalavrasChaveField().getText();
        String resumo = view.getResumoArea().getText();

        if (titulo.isEmpty() || autor.isEmpty() || ano.isEmpty() || orientadorNome.isEmpty() || cursoNome.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int aluno = usuarioDAO.buscarUsuarioPorNome(autor);
            int orientador = usuarioDAO.buscarUsuarioPorNome(orientadorNome);

            if (aluno == -1) {
                JOptionPane.showMessageDialog(view, "Aluno não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (orientador == -1) {
                JOptionPane.showMessageDialog(view, "Orientador não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Curso curso = cursoDAO.buscarCursoPorNome(cursoNome);
            Faculdade faculdade = faculdadeDAO.buscarFaculdadePorId(1); // Aqui você pode adaptar para buscar a faculdade correta

            if (curso == null) {
                JOptionPane.showMessageDialog(view, "Curso não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criação do objeto Trabalho
            Trabalho trabalho = new Trabalho();
            trabalho.setTitulo(titulo);
            trabalho.setFaculdade(faculdade);
            trabalho.setDataConclusao(LocalDate.now()); // Usando a data atual para a data de conclusão
            trabalho.setEstudante(aluno);
            trabalho.setOrientador(orientador);
            trabalho.setCurso(curso);
            trabalho.setLocalArquivo(resumo); // Pode-se adicionar lógica para o caminho do arquivo
            trabalho.setScore(0); // Score inicial
            trabalho.setQuantidadeVotos(0); // Nenhum voto inicialmente

            // Adiciona o trabalho ao banco de dados
            trabalhoDAO.adicionarTrabalho(trabalho);

            JOptionPane.showMessageDialog(view, "Trabalho depositado com sucesso!");

            // Limpar os campos após o depósito
            limparCampos();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao depositar o trabalho: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ano inválido. Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        view.getTituloField().setText("");
        view.getAutorField().setText("");
        view.getAnoField().setText("");
        view.getEditoraField().setText("");
        view.getOrientadorField().setText("");
        view.getCursoField().setText("");
        view.getPalavrasChaveField().setText("");
        view.getResumoArea().setText("");
    }
}
