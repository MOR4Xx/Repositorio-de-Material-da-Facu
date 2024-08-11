package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        pesquisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pesquisa = pesquisaField.getText();
                // Simular resultados de pesquisa
                String[] resultados = buscarObra(pesquisa);

                // Exibir resultados em uma nova janela
                mostrarResultados(resultados);
            }
        });
    }

    private String[] buscarObra(String pesquisa) {
        // Aqui você implementaria a lógica de busca. Este é um exemplo simulado.
        return new String[]{
                "Obra 1: " + pesquisa,
                "Obra 2: " + pesquisa,
                "Obra 3: " + pesquisa
        };
    }

    private void mostrarResultados(String[] resultados) {
        JFrame resultadosFrame = new JFrame("Resultados da Pesquisa");
        resultadosFrame.setSize(400, 300);
        resultadosFrame.setLayout(new BorderLayout());

        JPanel resultadosPanel = new JPanel();
        resultadosPanel.setLayout(new BoxLayout(resultadosPanel, BoxLayout.Y_AXIS));

        for (String resultado : resultados) {
            JLabel resultadoLabel = new JLabel(resultado);
            resultadosPanel.add(resultadoLabel);
        }

        JScrollPane scrollPane = new JScrollPane(resultadosPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        resultadosFrame.add(scrollPane, BorderLayout.CENTER);
        resultadosFrame.setVisible(true);
    }
}
