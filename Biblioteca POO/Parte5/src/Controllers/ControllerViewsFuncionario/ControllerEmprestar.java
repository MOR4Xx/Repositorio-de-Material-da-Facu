package Controllers.ControllerViewsFuncionario;

import DAO.EmprestimoDAO;
import DAO.UsuarioDAO;
import Models.Emprestimo;
import View.ViewsFuncionario.EmprestarView;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class ControllerEmprestar {
    private EmprestarView view;
    private EmprestimoDAO emprestimoDAO;
    private UsuarioDAO usuarioDAO;

    public ControllerEmprestar(EmprestarView view) {
        this.view = view;
        this.emprestimoDAO = new EmprestimoDAO();
        this.usuarioDAO = new UsuarioDAO();
        initView();
        initController();
    }
    private  void initView(){
        view.setVisible(true);
    }

    private void initController() {
        view.getEmprestarBtn().addActionListener(e -> realizarEmprestimo());
    }

    private void realizarEmprestimo() {
        int idUsuario = Integer.parseInt(view.getUsuarioField().getText());
        String idObra = view.getObraField().getText();

        try {
            int usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);

            Emprestimo emprestimo = new Emprestimo();
            emprestimo.setUsuario(usuario);
            emprestimo.setDataEmprestimo(LocalDate.now());
            emprestimo.setHoraEmprestimo(LocalTime.now());
            emprestimo.setLivro(Integer.parseInt(idObra));

            emprestimoDAO.adicionarEmprestimo(emprestimo);
            JOptionPane.showMessageDialog(view, "Empréstimo realizado com sucesso!");

            view.getUsuarioField().setText("");
            view.getObraField().setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao realizar o empréstimo: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "ID da Obra inválido.");
        }
    }
}
