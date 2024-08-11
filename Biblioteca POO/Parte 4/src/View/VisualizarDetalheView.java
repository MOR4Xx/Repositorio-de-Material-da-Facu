package View;

import javax.swing.*;

public class VisualizarDetalheView extends JPanel {

    public VisualizarDetalheView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Visualizar Detalhes"));
        JTextArea detalhesArea = new JTextArea(10, 40);
        detalhesArea.setText("Detalhes da Obra...");
        add(new JScrollPane(detalhesArea));
        add(new JButton("Emprestar"));
    }
}
