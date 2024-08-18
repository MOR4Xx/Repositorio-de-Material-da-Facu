package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class RenovacaoDevolucaoView extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public RenovacaoDevolucaoView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Renovação/Devolução de Empréstimos", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));

        JButton renovarEmprestimoBtn = new JButton("Renovar Empréstimo");
        JButton devolverEmprestimoBtn = new JButton("Devolver Empréstimo");

        buttonsPanel.add(renovarEmprestimoBtn);
        buttonsPanel.add(devolverEmprestimoBtn);

        add(buttonsPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(RenovarEmprestimoPanel(), "Renovar Empréstimo");
        cardPanel.add(DevolverEmprestimoPanel(), "Devolver Empréstimo");

        add(cardPanel, BorderLayout.CENTER);

        renovarEmprestimoBtn.addActionListener(e -> cardLayout.show(cardPanel, "Renovar Empréstimo"));
        devolverEmprestimoBtn.addActionListener(e -> cardLayout.show(cardPanel, "Devolver Empréstimo"));
    }

    public JPanel RenovarEmprestimoPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Empréstimo:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Data Atual de Devolução:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Nova Data de Devolução:"));
        panel.add(new JTextField());
        JButton renovarBtn = new JButton("Renovar");
        panel.add(renovarBtn);

        // Aqui você pode adicionar a lógica de renovação de empréstimo
        renovarBtn.addActionListener(e -> {
            // Lógica de renovação
            JOptionPane.showMessageDialog(this, "Empréstimo renovado com sucesso!");
        });

        return panel;
    }

    public JPanel DevolverEmprestimoPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Empréstimo:"));
        panel.add(new JTextField());
        JButton devolverBtn = new JButton("Devolver");
        panel.add(devolverBtn);

        // Aqui você pode adicionar a lógica de devolução de empréstimo
        devolverBtn.addActionListener(e -> {
            // Lógica de devolução
            JOptionPane.showMessageDialog(this, "Empréstimo devolvido com sucesso!");
        });

        return panel;
    }
}
