package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarAcervoView extends JPanel {

    public ListarAcervoView() {
        setLayout(new BorderLayout()); // Define o layout do painel principal

        // Criar o painel que conterá a lista de obras
        JPanel acervoList = new JPanel();
        acervoList.setLayout(new BoxLayout(acervoList, BoxLayout.Y_AXIS)); // Layout para organizar componentes verticalmente

        // Adiciona exemplos de componentes ao acervoList
        for (int i = 0; i < 40; i++) {
            JPanel obraPanel = new JPanel();
            obraPanel.setLayout(new BorderLayout());
            obraPanel.setPreferredSize(new Dimension(380, 80)); // Tamanho do retângulo para cada produto

            JPanel infoObras = new JPanel();
            infoObras.setLayout(new GridLayout(4, 1)); // Layout para os componentes do produto

            JLabel idObra = new JLabel("ID: " + i); // Exemplo de conteúdo
            idObra.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel nomeObra = new JLabel("Nome da Obra " + i); // Exemplo de conteúdo
            nomeObra.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel editora = new JLabel("Editora " + i); // Exemplo de conteúdo
            editora.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel edicao = new JLabel("Edição " + i); // Exemplo de conteúdo
            edicao.setFont(new Font("Arial", Font.PLAIN, 12));

            infoObras.add(nomeObra);
            infoObras.add(idObra);
            infoObras.add(editora);
            infoObras.add(edicao);
            obraPanel.add(infoObras, BorderLayout.CENTER); // Adiciona o painel infoObras ao BorderLayout.CENTER


            JButton selecionarButton = new JButton("Visualizar");
            int finalI = i;
            selecionarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ação quando o botão é clicado
                    JOptionPane.showMessageDialog(ListarAcervoView.this, "Você selecionou a Obra ID: "+ finalI);
                }
            });
            obraPanel.add(selecionarButton, BorderLayout.EAST); // Adiciona o botão ao lado direito

            acervoList.add(obraPanel);
        }

        // Criação do JScrollPane para o acervoList
        JScrollPane scrollPane = new JScrollPane(acervoList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostra a barra de rolagem horizontal

        // Adiciona o JScrollPane ao painel principal
        add(scrollPane, BorderLayout.CENTER);

    }
}
