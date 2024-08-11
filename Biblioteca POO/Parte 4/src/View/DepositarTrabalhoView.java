package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositarTrabalhoView extends JPanel {

    private JTextField tituloField;
    private JTextField autorField;
    private JTextField anoField;
    private JTextField editoraField;
    private JButton depositarButton;

    public DepositarTrabalhoView() {
        setLayout(new BorderLayout());

        // Painel para os campos de entrada
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(20, 2));

        inputPanel.add(new JLabel("Título:"));
        tituloField = new JTextField();
        inputPanel.add(tituloField);

        inputPanel.add(new JLabel("Autor:"));
        autorField = new JTextField();
        inputPanel.add(autorField);

        inputPanel.add(new JLabel("Ano:"));
        anoField = new JTextField();
        inputPanel.add(anoField);

        inputPanel.add(new JLabel("Editora:"));
        editoraField = new JTextField();
        inputPanel.add(editoraField);

        depositarButton = new JButton("Depositar");
        add(depositarButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.CENTER);

        // Ação do botão de depositar
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String autor = autorField.getText();
                String ano = anoField.getText();
                String editora = editoraField.getText();

                // Validar e processar os dados
                if (titulo.isEmpty() || autor.isEmpty() || ano.isEmpty() || editora.isEmpty()) {
                    JOptionPane.showMessageDialog(DepositarTrabalhoView.this,
                            "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    String resultado = processarDeposito(titulo, autor, ano, editora);

                    // Exibir resultado
                    mostrarResultado(resultado);
                }
            }
        });
    }

    private String processarDeposito(String titulo, String autor, String ano, String editora) {
        // Simular o processamento do depósito do trabalho
        // Na prática, você implementaria a lógica de inserção no banco de dados aqui.
        return "Trabalho depositado com sucesso:\nTítulo: " + titulo + "\nAutor: " + autor + "\nAno: " + ano + "\nEditora: " + editora;
    }

    private void mostrarResultado(String resultado) {
        JFrame resultadoFrame = new JFrame("Resultado do Depósito");
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
