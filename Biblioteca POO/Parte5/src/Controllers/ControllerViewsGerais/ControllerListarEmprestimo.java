package Controllers.ControllerViewsGerais;


import DAO.EmprestimoDAO;
import Models.Emprestimo;
import View.ViewsGerais.ListarEmprestimoView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerListarEmprestimo {
    private ListarEmprestimoView view;
    private EmprestimoDAO emprestimoDAO;

    public ControllerListarEmprestimo(ListarEmprestimoView view) {
        this.view = view;
        this.emprestimoDAO = new EmprestimoDAO();
        initView();
        initController();
    }

    private void initView() {
        view.setVisible(true);
    }

    private void initController() {
        carregarEmprestimos();
    }

    private void carregarEmprestimos() {
        try {
            List<Emprestimo> emprestimos = emprestimoDAO.listarEmprestimos();
            view.exibirEmprestimos(emprestimos);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar os empréstimos: " + e.getMessage());
        }
    }
}
