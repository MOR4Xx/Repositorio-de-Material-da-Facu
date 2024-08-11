package View;

import javax.swing.*;
import java.awt.*;

public class VisualizarDetalheView extends JFrame {

    public VisualizarDetalheView(JLabel nomeObra, JLabel idObra, JLabel autor, JLabel editora, JLabel edicao, JLabel ano) {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel detalhesPanel = new JPanel();


        detalhesPanel.setLayout(new GridLayout(10, 1));
        detalhesPanel.add(new JLabel(nomeObra.getText()));
        detalhesPanel.add(new JLabel(idObra.getText()));
        detalhesPanel.add(new JLabel(autor.getText()));
        detalhesPanel.add(new JLabel(editora.getText()));
        detalhesPanel.add(new JLabel(edicao.getText()));
        detalhesPanel.add(new JLabel(ano.getText()));

        JButton emprestar = new JButton("Emprestimo");
        add(emprestar, BorderLayout.SOUTH);

        add(detalhesPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
