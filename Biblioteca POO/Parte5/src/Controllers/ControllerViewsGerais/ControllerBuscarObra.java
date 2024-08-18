package Controllers.ControllerViewsGerais;

import DAO.LivroDAO;
import Models.Emprestimo;
import Models.Livro;
import View.ViewsGerais.BuscarObraView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerBuscarObra {
    private BuscarObraView view;
    private LivroDAO livroDAO;

    public ControllerBuscarObra(BuscarObraView view) {
        this.view = view;
        this.livroDAO = new LivroDAO();
        initController();
    }

    private void initController() {
        view.getPesquisarButton().addActionListener(e -> buscarObra());
    }

    private void buscarObra() {
        String pesquisa = view.getPesquisaField().getText();

        try {
            Livro livro = livroDAO.buscarLivroPorTitulo(pesquisa);

            if (livro != null) {
                String resultado = formatarResultado();
                view.mostrarResultado(resultado);
            } else {
                view.mostrarResultado("Obra não encontrado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar Obra: " + e.getMessage());
        } catch (NumberFormatException e) {
            view.mostrarResultado("ID de Obra inválido.");
        }
    }
    private String formatarResultado() {
        return null;
    }

}
