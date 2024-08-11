package View;

import javax.swing.*;

public class VisualizarReservaView extends JPanel {

    public VisualizarReservaView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Visualizar Reserva"));
        JTextArea reservaArea = new JTextArea(10, 40);
        reservaArea.setText("Detalhes da Reserva...");
        add(new JScrollPane(reservaArea));
        add(new JButton("Cancelar Reserva"));
    }
}
