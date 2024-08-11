package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarAcervoView extends JPanel {

    public ListarAcervoView() {
        setLayout(new BorderLayout());
        JPanel acervoList = new JPanel();
        acervoList.setLayout(new BoxLayout(acervoList, BoxLayout.Y_AXIS));


        for (int i = 0; i < 40; i++) {
            JPanel obraPanel = new JPanel();
            obraPanel.setLayout(new BorderLayout());
            obraPanel.setPreferredSize(new Dimension(300, 80));

            JPanel infoObras = new JPanel();
            infoObras.setLayout(new GridLayout(6, 1));

            JLabel idObra = new JLabel("ID: " + i);
            idObra.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel nomeObra = new JLabel("Nome da Obra " + i);
            nomeObra.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel autor = new JLabel("Autor " + i);
            autor.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel editora = new JLabel("Editora " + i);
            editora.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel edicao = new JLabel("Edição " + i);
            edicao.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel ano = new JLabel("Ano: 2024");
            ano.setFont(new Font("Arial", Font.PLAIN, 11));

            infoObras.add(nomeObra);
            infoObras.add(idObra);
            infoObras.add(autor);
            infoObras.add(editora);
            infoObras.add(edicao);
            obraPanel.add(infoObras, BorderLayout.CENTER);


            JButton visualizarButton = new JButton("Visualizar");
            visualizarButton.addActionListener(e -> new VisualizarDetalheView(nomeObra, idObra, autor, editora, edicao, ano));
            obraPanel.add(visualizarButton, BorderLayout.EAST);
            acervoList.add(obraPanel);
        }

        JScrollPane scrollPane = new JScrollPane(acervoList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

    }
}
