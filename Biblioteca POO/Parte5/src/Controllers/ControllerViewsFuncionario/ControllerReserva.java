package Controllers.ControllerViewsFuncionario;

import DAO.ReservaDAO;
import DAO.UsuarioDAO;
import DAO.LivroDAO;
import Models.Reserva;
import View.ViewsFuncionario.ReservaView;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControllerReserva {
    private ReservaView view;
    private ReservaDAO reservaDAO;
    private UsuarioDAO usuarioDAO;
    private LivroDAO livroDAO;

    public ControllerReserva(ReservaView view) {
        this.view = view;
        this.reservaDAO = new ReservaDAO();
        this.usuarioDAO = new UsuarioDAO();
        this.livroDAO = new LivroDAO();
        initView();
        initController();
    }

    private void initView() {
        view.setVisible(true);
    }


    private void initController() {
        view.getReservaButton().addActionListener(e -> realizarReserva());
    }

    private void realizarReserva() {
        int idUsuario = Integer.parseInt(view.getUsuarioField().getText());
        int idObra = Integer.parseInt(view.getObraField().getText());

        try {
            int usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);
            if (-1 == usuario) {
                JOptionPane.showMessageDialog(view, "Usuário não encontrado!");
                return;
            }

            int livro = livroDAO.buscarLivroPorId(idObra);
            if (livro == -1) {
                JOptionPane.showMessageDialog(view, "Obra não encontrada!");
                return;
            }

            Reserva reserva = new Reserva();
            reserva.setIdUsuario(idUsuario);
            reserva.setIdObra(idObra);
            reserva.setDataReserva(LocalDate.now());

            reservaDAO.adicionarReserva(reserva);
            JOptionPane.showMessageDialog(view, "Reserva realizada com sucesso!");

            view.getUsuarioField().setText("");
            view.getObraField().setText("");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao realizar a reserva: " + ex.getMessage());
        }
    }
}
