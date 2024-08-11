package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarEmprestimoView extends JPanel {
    private JTextField pesquisaField;
    private JButton pesquisarButton;

    public BuscarEmprestimoView() {
        setLayout(new BorderLayout());

        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new GridLayout(20, 1));

        pesquisaField = new JTextField();
        buscaPanel.add(new JLabel("Digite o id do emprestimo:"));
        buscaPanel.add(pesquisaField);

        add(buscaPanel, BorderLayout.CENTER);

        pesquisarButton = new JButton("Pesquisar");
        add(pesquisarButton, BorderLayout.SOUTH);

        // Ação do botão de busca
        pesquisaField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoEmprestimo = pesquisaField.getText();
                // Simular resultado da pesquisa
                String resultado = buscarEmprestimo(codigoEmprestimo);

                // Exibir o resultado em uma nova janela
                mostrarResultado(resultado);
            }
        });
    }

    private String buscarEmprestimo(String codigoEmprestimo) {
        // Aqui você implementaria a lógica de busca. Este é um exemplo simulado.
        // Vamos supor que se o código for "123", existe um empréstimo.
        if ("123".equals(codigoEmprestimo)) {
            return "Empréstimo encontrado:\nCódigo: 123\nUsuário: João Silva\nLivro: Aprendendo Java\nData: 10/08/2023";
        } else {
            return "Empréstimo não encontrado.";
        }
    }

    private void mostrarResultado(String resultado) {
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
