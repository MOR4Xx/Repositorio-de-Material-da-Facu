package View.ViewsGerais;

import javax.swing.*;
import java.awt.*;

public class BuscarObraView extends JPanel {

    private JTextField pesquisaField;
    private JButton pesquisarButton;

    public BuscarObraView() {
        setLayout(new BorderLayout());

        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new GridLayout(20, 1));

        pesquisaField = new JTextField();
        buscaPanel.add(new JLabel("Digite o nome da obra:"));
        buscaPanel.add(pesquisaField);

        add(buscaPanel, BorderLayout.CENTER);

        pesquisarButton = new JButton("Pesquisar");
        add(pesquisarButton, BorderLayout.SOUTH);
    }

    public JTextField getPesquisaField() {
        return pesquisaField;
    }

    public JButton getPesquisarButton() {
        return pesquisarButton;
    }

    public void mostrarResultado(String resultado) {
        JFrame resultadoFrame = new JFrame("Resultado da Pesquisa");
        resultadoFrame.setSize(400, 200);
        resultadoFrame.setLayout(new BorderLayout());

        JTextArea resultadoTextArea = new JTextArea(resultado);
        resultadoTextArea.setEditable(false);
        resultadoTextArea.setLineWrap(true);
        resultadoTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        resultadoFrame.add(scrollPane, BorderLayout.CENTER);
        resultadoFrame.setVisible(true);
    }
}
