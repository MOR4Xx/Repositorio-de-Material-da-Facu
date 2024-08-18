package View.ViewsFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AcessarObraDigitalView extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton abrirArquivoBtn;
    private JButton voltarBtn;

    public AcessarObraDigitalView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Pesquisar Obras Digitais", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        String[] columnNames = {"ID", "Título", "Autor", "Ano", "Formato", "Caminho do Arquivo"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        abrirArquivoBtn = new JButton("Abrir Arquivo");
        voltarBtn = new JButton("Voltar");

        buttonsPanel.add(abrirArquivoBtn);


        add(buttonsPanel, BorderLayout.SOUTH);

        adicionarObraDigital(1, "Livro Digital A", "Autor A", 2020, "PDF", "caminho/para/livroA.pdf");
        adicionarObraDigital(2, "Livro Digital B", "Autor B", 2019, "EPUB", "caminho/para/livroB.pdf");
    }

    public void adicionarObraDigital(int id, String titulo, String autor, int ano, String formato, String caminho) {
        tableModel.addRow(new Object[]{id, titulo, autor, ano, formato, caminho});
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JButton getAbrirArquivoBtn() {
        return abrirArquivoBtn;
    }
}
