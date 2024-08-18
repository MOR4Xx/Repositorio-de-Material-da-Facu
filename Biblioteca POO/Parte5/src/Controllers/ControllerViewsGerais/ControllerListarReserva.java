package Controllers.ControllerViewsGerais;

import DAO.ReservaDAO;
import Models.Reserva;
import View.ViewsGerais.ListarReservaView;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ControllerListarReserva{
    private ListarReservaView view;
    private ReservaDAO reservaDAO;

    public ControllerListarReserva(ListarReservaView view) {
        this.view = view;
        this.reservaDAO = new ReservaDAO();
        iniView();
        initController();
    }

    private void iniView() {
        view.setVisible(true);
    }

    private void initController() {
        carregarReservas();
    }

    private void carregarReservas() {
        try {
            List<Reserva> reservas = reservaDAO.listarReservas();
            view.exibirReservas(reservas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar as reservas: " + e.getMessage());
        }
    }
}
