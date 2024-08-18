package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class RenovacaoDevolucaoView extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    private JTextField renovarEmprestimoIdField;
    private JTextField novaDataDevolucaoField;
    private JButton renovarBtn;

    private JTextField devolverEmprestimoIdField;
    private JButton devolverBtn;

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
        renovarEmprestimoIdField = new JTextField();
        panel.add(renovarEmprestimoIdField);

        panel.add(new JLabel("Nova Data de Devolução:"));
        novaDataDevolucaoField = new JTextField();
        panel.add(novaDataDevolucaoField);

        renovarBtn = new JButton("Renovar");
        panel.add(renovarBtn);

        return panel;
    }

    public JPanel DevolverEmprestimoPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Empréstimo:"));
        devolverEmprestimoIdField = new JTextField();
        panel.add(devolverEmprestimoIdField);

        devolverBtn = new JButton("Devolver");
        panel.add(devolverBtn);

        return panel;
    }

    public JTextField getRenovarEmprestimoIdField() {
        return renovarEmprestimoIdField;
    }

    public JTextField getNovaDataDevolucaoField() {
        return novaDataDevolucaoField;
    }

    public JButton getRenovarBtn() {
        return renovarBtn;
    }

    public JTextField getDevolverEmprestimoIdField() {
        return devolverEmprestimoIdField;
    }

    public JButton getDevolverBtn() {
        return devolverBtn;
    }
}
