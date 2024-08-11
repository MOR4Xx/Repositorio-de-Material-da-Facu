package View;

import javax.swing.*;

public class VisualizarEmprestimoView extends JPanel {

    public VisualizarEmprestimoView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Visualizar Empréstimo"));
        JTextArea emprestimoArea = new JTextArea(10, 40);
        emprestimoArea.setText("Detalhes do Empréstimo...");
        add(new JScrollPane(emprestimoArea));
        add(new JButton("Renovar"));
        add(new JButton("Devolver"));
    }
}
