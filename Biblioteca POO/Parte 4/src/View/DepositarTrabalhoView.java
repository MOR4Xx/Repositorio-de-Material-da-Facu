package View;

import javax.swing.*;

public class DepositarTrabalhoView extends JPanel {

    public DepositarTrabalhoView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Depositar Trabalho"));
        JTextField tituloField = new JTextField("Título do Trabalho", 20);
        add(tituloField);
        JTextArea descricaoArea = new JTextArea(5, 40);
        descricaoArea.setText("Descrição do Trabalho...");
        add(new JScrollPane(descricaoArea));
        add(new JButton("Depositar"));
    }
}
