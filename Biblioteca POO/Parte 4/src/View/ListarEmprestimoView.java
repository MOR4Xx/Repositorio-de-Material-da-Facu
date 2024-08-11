package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarEmprestimoView extends JPanel {

    public ListarEmprestimoView() {
        setLayout(new BorderLayout());

        JPanel emprestimoList = new JPanel();
        emprestimoList.setLayout(new BoxLayout(emprestimoList, BoxLayout.Y_AXIS));

        for (int i = 0; i < 40; i++) {
            JPanel emprestimoPanel = new JPanel();
            emprestimoPanel.setLayout(new BorderLayout());
            emprestimoPanel.setPreferredSize(new Dimension(300, 80));

            JPanel infoEmprestimos = new JPanel();
            infoEmprestimos.setLayout(new GridLayout(4, 1));

            JLabel idEmprestimo = new JLabel("ID: " + i);
            idEmprestimo.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel usuario = new JLabel("Nome do Usuario " + i);
            usuario.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel dataEmprestimo = new JLabel("Data do Empréstimo " + i);
            dataEmprestimo.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel horaEmprestimo = new JLabel("Data do Empréstimo " + i);
            horaEmprestimo.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel livro = new JLabel("Livro " + i);
            livro.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel dataDevolucao = new JLabel("Data de Devolução " + i);
            dataDevolucao.setFont(new Font("Arial", Font.PLAIN, 12));

            infoEmprestimos.add(idEmprestimo);
            infoEmprestimos.add(usuario);
            infoEmprestimos.add(dataEmprestimo);
            infoEmprestimos.add(dataDevolucao);
            emprestimoPanel.add(infoEmprestimos, BorderLayout.CENTER);

            JButton visualizarButton = new JButton("Visualizar");

            visualizarButton.addActionListener(e -> new VisualizarEmprestimoView(idEmprestimo ,dataEmprestimo, horaEmprestimo, livro, usuario,dataDevolucao));
            emprestimoPanel.add(visualizarButton, BorderLayout.EAST);

            emprestimoList.add(emprestimoPanel);
        }

        JScrollPane scrollPane = new JScrollPane(emprestimoList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }
}
