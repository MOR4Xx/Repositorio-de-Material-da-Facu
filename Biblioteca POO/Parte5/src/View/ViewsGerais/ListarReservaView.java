package View.ViewsGerais;

import Models.Reserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListarReservaView extends JPanel {
    private JTable tabelaReservas;
    private DefaultTableModel tabelaModelo;

    public ListarReservaView() {
        setLayout(new BorderLayout());

        // Título da tela
        JLabel titulo = new JLabel("Lista de Reservas", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Criação da tabela
        tabelaModelo = new DefaultTableModel(new Object[]{"ID", "Usuário", "Livro", "Data Reserva"}, 0);
        tabelaReservas = new JTable(tabelaModelo);
        JScrollPane scrollPane = new JScrollPane(tabelaReservas);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para exibir as reservas na tabela
    public void exibirReservas(List<Reserva> reservas) {
        tabelaModelo.setRowCount(0); // Limpar a tabela
        for (Reserva reserva : reservas) {
            tabelaModelo.addRow(new Object[]{
                    reserva.getId(),
                    reserva.getIdUsuario(),
                    reserva.getIdObra(),
                    reserva.getDataReserva()
            });
        }
    }
}
