package View.ViewsGerais;

import Models.Emprestimo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarEmprestimoView extends JPanel {
    private JTable tabelaEmprestimos;
    private DefaultTableModel tabelaModelo;

    public ListarEmprestimoView() {
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Lista de Empréstimos", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        tabelaModelo = new DefaultTableModel(new Object[]{"ID", "Usuário", "Livro", "Data Empréstimo", "Data Devolução"}, 0);
        tabelaEmprestimos = new JTable(tabelaModelo);
        JScrollPane scrollPane = new JScrollPane(tabelaEmprestimos);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void exibirEmprestimos(List<Emprestimo> emprestimos) {
        tabelaModelo.setRowCount(0);
        for (Emprestimo emprestimo : emprestimos) {
            tabelaModelo.addRow(new Object[]{
                    emprestimo.getId(),
                    emprestimo.getUsuario(),
                    emprestimo.getLivro(),
                    emprestimo.getDataEmprestimo(),
                    emprestimo.getDataDevolucao()
            });
        }
    }
}
