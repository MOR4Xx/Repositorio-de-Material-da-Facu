package Controllers.ControllerViewsFuncionario;

import DAO.EmprestimoDAO;
import View.ViewsFuncionario.RenovacaoDevolucaoView;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerRenovacaoDevolucao {
    private RenovacaoDevolucaoView view;
    private EmprestimoDAO emprestimoDAO;

    public ControllerRenovacaoDevolucao(RenovacaoDevolucaoView view) {
        this.view = view;
        this.emprestimoDAO = new EmprestimoDAO();
        initController();
    }

    private void initController() {
        view.getRenovarBtn().addActionListener(e -> renovarEmprestimo());

        view.getDevolverBtn().addActionListener(e -> devolverEmprestimo());
    }

    private void renovarEmprestimo() {
        String idEmprestimo = view.getRenovarEmprestimoIdField().getText();
        String novaDataDevolucaoStr = view.getNovaDataDevolucaoField().getText();

        try {
            LocalDate novaDataDevolucao = LocalDate.parse(novaDataDevolucaoStr);
            emprestimoDAO.renovarEmprestimo(Integer.parseInt(idEmprestimo), novaDataDevolucao);
            JOptionPane.showMessageDialog(view, "Empréstimo renovado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao renovar empréstimo: " + ex.getMessage());
        } catch (NumberFormatException | java.time.format.DateTimeParseException ex) {
            JOptionPane.showMessageDialog(view, "Dados inválidos: " + ex.getMessage());
        }
    }

    private void devolverEmprestimo() {
        String idEmprestimo = view.getDevolverEmprestimoIdField().getText();

        try {
            emprestimoDAO.devolverEmprestimo(Integer.parseInt(idEmprestimo));
            JOptionPane.showMessageDialog(view, "Empréstimo devolvido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao devolver empréstimo: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "ID do Empréstimo inválido.");
        }
    }
}
