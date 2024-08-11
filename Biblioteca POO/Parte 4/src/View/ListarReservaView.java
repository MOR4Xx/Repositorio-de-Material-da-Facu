package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarReservaView extends JPanel {

    public ListarReservaView() {
        setLayout(new BorderLayout()); // Define o layout do painel principal

        // Criar o painel que conterá a lista de reservas
        JPanel reservaList = new JPanel();
        reservaList.setLayout(new BoxLayout(reservaList, BoxLayout.Y_AXIS)); // Layout para organizar componentes verticalmente

        // Adiciona exemplos de componentes ao reservaList
        for (int i = 0; i < 40; i++) {
            JPanel reservaPanel = new JPanel();
            reservaPanel.setLayout(new BorderLayout());
            reservaPanel.setPreferredSize(new Dimension(380, 80)); // Tamanho do retângulo para cada item

            JPanel infoReservas = new JPanel();
            infoReservas.setLayout(new GridLayout(4, 1)); // Layout para os componentes do item

            JLabel idReserva = new JLabel("ID: " + i); // Exemplo de conteúdo
            idReserva.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel nomeCliente = new JLabel("Nome do Usuario " + i); // Exemplo de conteúdo
            nomeCliente.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel dataReserva = new JLabel("Data da Reserva " + i); // Exemplo de conteúdo
            dataReserva.setFont(new Font("Arial", Font.PLAIN, 12));
            JLabel dataExpiracao = new JLabel("Data de Expiração " + i); // Exemplo de conteúdo
            dataExpiracao.setFont(new Font("Arial", Font.PLAIN, 12));

            infoReservas.add(idReserva);
            infoReservas.add(nomeCliente);
            infoReservas.add(dataReserva);
            infoReservas.add(dataExpiracao);
            reservaPanel.add(infoReservas, BorderLayout.CENTER); // Adiciona o painel infoReservas ao BorderLayout.CENTER

            // Botão para visualizar detalhes da reserva
            JButton visualizarButton = new JButton("Visualizar");
            int finalI = i;
            visualizarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ação quando o botão é clicado
                    JOptionPane.showMessageDialog(ListarReservaView.this, "Você selecionou a Reserva ID: " + finalI);
                }
            });
            reservaPanel.add(visualizarButton, BorderLayout.EAST); // Adiciona o botão ao lado direito

            reservaList.add(reservaPanel);
        }

        // Criação do JScrollPane para o reservaList
        JScrollPane scrollPane = new JScrollPane(reservaList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Sempre mostra a barra de rolagem vertical
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Nunca mostra a barra de rolagem horizontal

        // Adiciona o JScrollPane ao painel principal
        add(scrollPane, BorderLayout.CENTER);
    }
}
