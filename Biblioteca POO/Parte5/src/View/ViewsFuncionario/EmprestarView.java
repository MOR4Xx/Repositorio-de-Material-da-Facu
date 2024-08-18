package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class EmprestarView extends JPanel {
    public EmprestarView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Emprestar Obra", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        // Formulário básico para realizar o empréstimo
        JPanel formPanel = new JPanel(new GridLayout(20, 1, 10, 10));

        formPanel.add(new JLabel("Nome do Usuário:"));
        JTextField usuarioField = new JTextField();
        formPanel.add(usuarioField);

        formPanel.add(new JLabel("ID da Obra:"));
        JTextField obraField = new JTextField();
        formPanel.add(obraField);

        JButton emprestarBtn = new JButton("Realizar Empréstimo");

        add(formPanel, BorderLayout.CENTER);
        add(emprestarBtn, BorderLayout.SOUTH);
    }
}
