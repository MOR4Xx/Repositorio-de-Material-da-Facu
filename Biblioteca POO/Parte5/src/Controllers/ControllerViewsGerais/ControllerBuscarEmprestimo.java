package Controllers.ControllerViewsGerais;

import DAO.EmprestimoDAO;
import Models.Emprestimo;
import View.ViewsGerais.BuscarEmprestimoView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ControllerBuscarEmprestimo {
    private BuscarEmprestimoView view;
    private EmprestimoDAO emprestimoDAO;

    public ControllerBuscarEmprestimo(BuscarEmprestimoView view) {
        this.view = view;
        this.emprestimoDAO = new EmprestimoDAO();
        initView();
        initController();
    }

    private void initView() {
        view.setVisible(true);
    }

    private void initController() {
        view.getPesquisarButton().addActionListener(e -> buscarEmprestimo());
        view.getPesquisaField().addActionListener(e -> buscarEmprestimo());
    }

    private void buscarEmprestimo() {
        int codigoEmprestimo = Integer.parseInt(view.getPesquisaField().getText());

        try {
            Emprestimo emprestimo = emprestimoDAO.buscarEmprestimoPorId(codigoEmprestimo);

            if (emprestimo != null) {
                String resultado = formatarResultado(emprestimo);
                view.mostrarResultado(resultado);
            } else {
                view.mostrarResultado("Empréstimo não encontrado.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao buscar empréstimo: " + e.getMessage());
        } catch (NumberFormatException e) {
            view.mostrarResultado("ID de Empréstimo inválido.");
        }
    }

    private String formatarResultado(Emprestimo emprestimo) {
        return "Empréstimo encontrado:\n" +
                "Código: " + emprestimo.getId() + "\n" +
                "Usuário: " + emprestimo.getUsuario() + "\n" +
                "Livro: " + emprestimo.getLivro() + "\n" +
                "Data: " + emprestimo.getDataEmprestimo().toString();
    }
}
