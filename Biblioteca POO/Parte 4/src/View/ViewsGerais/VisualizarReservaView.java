package View.ViewsGerais;

import javax.swing.*;
import java.awt.*;

public class VisualizarReservaView extends JFrame {

    public VisualizarReservaView(JLabel idReserva, JLabel idUsuario, JLabel idObra, JLabel dataReserva) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel detalhesPanel = new JPanel();
        detalhesPanel.setLayout(new GridLayout(20, 1));

        detalhesPanel.add(new JLabel(idReserva.getText()));
        detalhesPanel.add(new JLabel(idUsuario.getText()));
        detalhesPanel.add(new JLabel(idObra.getText()));
        detalhesPanel.add(new JLabel(dataReserva.getText()));

        JButton Cancelar = new JButton("Cancelar");
        add(Cancelar, BorderLayout.SOUTH);

        add(detalhesPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
