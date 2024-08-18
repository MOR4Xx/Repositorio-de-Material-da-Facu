package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class ReservaView extends JPanel {
    public ReservaView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Reservar Obra", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        // Formulário básico para realizar a reserva
        JPanel formPanel = new JPanel(new GridLayout(20, 1, 10, 10));

        formPanel.add(new JLabel("Nome do Usuário:"));
        JTextField usuarioField = new JTextField();
        formPanel.add(usuarioField);

        formPanel.add(new JLabel("Título da Obra:"));
        JTextField obraField = new JTextField();
        formPanel.add(obraField);

        JButton reservarBtn = new JButton("Realizar Reserva");

        add(formPanel, BorderLayout.CENTER);
        add(reservarBtn, BorderLayout.SOUTH);
    }
}

