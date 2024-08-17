package View.ViewsGerais;

import javax.swing.*;
import java.awt.*;

public class VisualizarEmprestimoView extends JFrame {

    public VisualizarEmprestimoView(JLabel id, JLabel dataEmprestimo, JLabel horaEmprestimo, JLabel livro, JLabel usuario, JLabel dataDevolucao) {
        setTitle("Visualizar Empréstimo");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel detalhesPanel = new JPanel();
        detalhesPanel.setLayout(new GridLayout(20, 1));

        detalhesPanel.add(new JLabel(id.getText()));
        detalhesPanel.add(new JLabel(dataEmprestimo.getText()));
        detalhesPanel.add(new JLabel(horaEmprestimo.getText()));
        detalhesPanel.add(new JLabel(livro.getText()));
        detalhesPanel.add(new JLabel(usuario.getText()));
        detalhesPanel.add(new JLabel(dataEmprestimo.getText()));
        detalhesPanel.add(new JLabel(dataDevolucao.getText()));

        JButton devolver = new JButton("Devolver");
        add(devolver, BorderLayout.SOUTH);

        add(detalhesPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
