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
            emprestimoPanel.setPreferredSize(new Dimension(380, 80));

            JPanel infoEmprestimos = new JPanel();
            infoEmprestimos.setLayout(new GridLayout(4, 1));

            JLabel idEmprestimo = new JLabel("ID: " + i);
            idEmprestimo.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel nomeCliente = new JLabel("Nome do Cliente " + i);
            nomeCliente.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel dataEmprestimo = new JLabel("Data do Empréstimo " + i);
            dataEmprestimo.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel dataDevolucao = new JLabel("Data de Devolução " + i);
            dataDevolucao.setFont(new Font("Arial", Font.PLAIN, 12));

            infoEmprestimos.add(idEmprestimo);
            infoEmprestimos.add(nomeCliente);
            infoEmprestimos.add(dataEmprestimo);
            infoEmprestimos.add(dataDevolucao);
            emprestimoPanel.add(infoEmprestimos, BorderLayout.CENTER);

            JButton visualizarButton = new JButton("Visualizar");
            int finalI = i;
            visualizarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(ListarEmprestimoView.this, "Você selecionou o Empréstimo ID: " + finalI);
                }
            });
            emprestimoPanel.add(visualizarButton, BorderLayout.EAST);

            emprestimoList.add(emprestimoPanel);
        }

        JScrollPane scrollPane = new JScrollPane(emprestimoList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }
}
