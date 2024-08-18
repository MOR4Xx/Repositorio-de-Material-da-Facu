package View.ViewsGerais;

import Models.Livro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarAcervoView extends JPanel {
    private JTable tabelaLivros;
    private DefaultTableModel tabelaModelo;

    public ListarAcervoView() {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Acervo da Biblioteca", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        tabelaModelo = new DefaultTableModel(new Object[]{"ID", "Título", "Autor", "Ano", "Editora"}, 0);
        tabelaLivros = new JTable(tabelaModelo);
        JScrollPane scrollPane = new JScrollPane(tabelaLivros);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void exibirLivros(List<Livro> livros) {
        tabelaModelo.setRowCount(0); // Limpar a tabela
        for (Livro livro : livros) {
            tabelaModelo.addRow(new Object[]{
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getAutores(),
                    livro.getAno(),
                    livro.getEditora()
            });
        }
    }
}
