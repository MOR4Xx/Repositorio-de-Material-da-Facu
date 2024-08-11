package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarReservaView extends JPanel {

    public ListarReservaView() {
        setLayout(new BorderLayout());

        JPanel reservaList = new JPanel();
        reservaList.setLayout(new BoxLayout(reservaList, BoxLayout.Y_AXIS));

        for (int i = 0; i < 40; i++) {
            JPanel reservaPanel = new JPanel();
            reservaPanel.setLayout(new BorderLayout());
            reservaPanel.setPreferredSize(new Dimension(300, 80));

            JPanel infoReservas = new JPanel();
            infoReservas.setLayout(new GridLayout(4, 1));
            JLabel idReserva = new JLabel("ID: " + i);
            idReserva.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel idUsuario = new JLabel("Nome do Usuario " + i);
            idUsuario.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel idObra = new JLabel("Id Obra " + i);
            idObra.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel dataReserva = new JLabel("Data Reserva " + i);
            dataReserva.setFont(new Font("Arial", Font.PLAIN, 12));

            infoReservas.add(idReserva);
            infoReservas.add(idUsuario);
            infoReservas.add(idObra);
            infoReservas.add(dataReserva);
            reservaPanel.add(infoReservas, BorderLayout.CENTER);

            JButton visualizarButton = new JButton("Visualizar");
            visualizarButton.addActionListener(e -> new VisualizarReservaView(idReserva, idUsuario, idObra, dataReserva));
            reservaPanel.add(visualizarButton, BorderLayout.EAST);

            reservaList.add(reservaPanel);
        }

        JScrollPane scrollPane = new JScrollPane(reservaList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }

}
