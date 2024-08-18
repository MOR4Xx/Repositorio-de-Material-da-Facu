package View.ViewsGerais;

import javax.swing.*;
import java.awt.*;

public class DepositarTrabalhoView extends JPanel {

    private JTextField tituloField;
    private JTextField autorField;
    private JTextField anoField;
    private JTextField editoraField;
    private JTextField orientadorField;
    private JTextField cursoField;
    private JTextField palavrasChaveField;
    private JTextArea resumoArea;
    private JButton depositarButton;

    public DepositarTrabalhoView() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(20, 1, 10, 10));

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

        inputPanel.add(new JLabel("Orientador:"));
        orientadorField = new JTextField();
        inputPanel.add(orientadorField);

        inputPanel.add(new JLabel("Curso:"));
        cursoField = new JTextField();
        inputPanel.add(cursoField);

        inputPanel.add(new JLabel("Palavras-chave:"));
        palavrasChaveField = new JTextField();
        inputPanel.add(palavrasChaveField);

        inputPanel.add(new JLabel("Resumo:"));
        resumoArea = new JTextArea(5, 20);
        JScrollPane resumoScrollPane = new JScrollPane(resumoArea);
        inputPanel.add(resumoScrollPane);

        depositarButton = new JButton("Depositar");
        add(depositarButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.CENTER);
    }

    // Getters para acessar os componentes no controller
    public JTextField getTituloField() {
        return tituloField;
    }

    public JTextField getAutorField() {
        return autorField;
    }

    public JTextField getAnoField() {
        return anoField;
    }

    public JTextField getEditoraField() {
        return editoraField;
    }

    public JTextField getOrientadorField() {
        return orientadorField;
    }

    public JTextField getCursoField() {
        return cursoField;
    }

    public JTextField getPalavrasChaveField() {
        return palavrasChaveField;
    }

    public JTextArea getResumoArea() {
        return resumoArea;
    }

    public JButton getDepositarButton() {
        return depositarButton;
    }
}
