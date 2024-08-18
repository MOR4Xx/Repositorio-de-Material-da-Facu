package View.ViewsFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class AcessarObraDigitalView extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public AcessarObraDigitalView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Pesquisar Obras Digitais", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        // Modelo da tabela para listar as obras digitais
        String[] columnNames = {"ID", "Título", "Autor", "Ano", "Formato", "Caminho do Arquivo"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        // Adicionando botões na parte inferior
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton abrirArquivoBtn = new JButton("Abrir Arquivo");
        JButton voltarBtn = new JButton("Voltar");

        buttonsPanel.add(abrirArquivoBtn);
        buttonsPanel.add(voltarBtn);

        add(buttonsPanel, BorderLayout.SOUTH);

        // Exemplo de dados fictícios de obras digitais
        adicionarObraDigital(1, "Livro Digital A", "Autor A", 2020, "PDF", "caminho/para/livroA.pdf");
        adicionarObraDigital(2, "Livro Digital B", "Autor B", 2019, "EPUB", "caminho/para/livroB.pdf");

        // Ação ao clicar no botão "Abrir Arquivo"
        abrirArquivoBtn.addActionListener(this::abrirArquivoSelecionado);

        // Ação ao clicar no botão "Voltar"
        voltarBtn.addActionListener(e -> {
            // Lógica para voltar ao menu anterior
            JOptionPane.showMessageDialog(this, "Voltando ao menu anterior...");
        });
    }

    private void adicionarObraDigital(int id, String titulo, String autor, int ano, String formato, String caminho) {
        tableModel.addRow(new Object[]{id, titulo, autor, ano, formato, caminho});
    }

    private void abrirArquivoSelecionado(ActionEvent e) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String caminhoDoArquivo = (String) tableModel.getValueAt(selectedRow, 5);
            abrirArquivo(caminhoDoArquivo);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma obra digital para abrir.");
        }
    }

    private void abrirArquivo(String caminhoDoArquivo) {
        try {
            Desktop desktop = Desktop.getDesktop();
            File arquivo = new File(caminhoDoArquivo);
            if (arquivo.exists()) {
                desktop.open(arquivo);
            } else {
                JOptionPane.showMessageDialog(this, "Arquivo não encontrado: " + caminhoDoArquivo);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo: " + ex.getMessage());
        }
    }
}
