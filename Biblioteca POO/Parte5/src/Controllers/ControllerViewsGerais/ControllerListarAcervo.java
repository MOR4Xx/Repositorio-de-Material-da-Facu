package Controllers.ControllerViewsGerais;

import DAO.LivroDAO;
import Models.Livro;
import View.ViewsGerais.ListarAcervoView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerListarAcervo {
    private ListarAcervoView view;
    private LivroDAO livroDAO;

    public ControllerListarAcervo(ListarAcervoView view) {
        this.view = view;
        this.livroDAO = new LivroDAO();
        initController();
        iniView();
    }

    private void iniView() {
        view.setVisible(true);
    }

    private void initController() {
        carregarAcervo();
    }

    private void carregarAcervo() {
        try {
            List<Livro> livros = livroDAO.listarLivros();
            view.exibirLivros(livros);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar o acervo: " + e.getMessage());
        }
    }
}
