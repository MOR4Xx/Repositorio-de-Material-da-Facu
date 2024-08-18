package View.ViewsFuncionario;

import Models.Reserva;

import javax.swing.*;
import java.awt.*;

public class ReservaView extends JPanel {
    private JTextField usuarioField;
    private JTextField obraField;
    private JButton reservaButton;

    public ReservaView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Reservar Obra", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(20, 1, 10, 10));

        formPanel.add(new JLabel("Nome do Usuário:"));
        usuarioField = new JTextField();
        formPanel.add(usuarioField);

        formPanel.add(new JLabel("Título da Obra:"));
        obraField = new JTextField();
        formPanel.add(obraField);

        reservaButton = new JButton("Realizar Reserva");

        add(formPanel, BorderLayout.CENTER);
        add(reservaButton, BorderLayout.SOUTH);
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public JTextField getObraField() {
        return obraField;
    }

    public JButton getReservaButton() {
        return reservaButton;
    }
}

