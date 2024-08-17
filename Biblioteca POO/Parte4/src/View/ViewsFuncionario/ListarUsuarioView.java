package View.ViewsFuncionario;

import View.ViewsGerais.VisualizarDetalheView;

import javax.swing.*;
import java.awt.*;

public class ListarUsuarioView extends JPanel {

    public ListarUsuarioView() {
        setLayout(new BorderLayout());
        JPanel userList = new JPanel();
        userList.setLayout(new BoxLayout(userList, BoxLayout.Y_AXIS));


        for (int i = 0; i < 40; i++) {
            JPanel usserPanel = new JPanel();
            usserPanel.setLayout(new BorderLayout());
            usserPanel.setPreferredSize(new Dimension(300, 80));

            JPanel infoUsuario = new JPanel();
            infoUsuario.setLayout(new GridLayout(6, 1));

            JLabel idUsuario = new JLabel("ID: " + i);
            idUsuario.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel nomeUsuario = new JLabel("Nome Usuario " + i);
            nomeUsuario.setFont(new Font("Arial", Font.BOLD, 11));
            JLabel idade = new JLabel("Idade: " + i);
            idade.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel sexo = new JLabel("Sexo: " + i);
            sexo.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel telefone = new JLabel("Telefone " + i);
            telefone.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel cpf = new JLabel("Cpf: "+i);
            cpf.setFont(new Font("Arial", Font.PLAIN, 11));
            JLabel label = new JLabel();


            infoUsuario.add(nomeUsuario);
            infoUsuario.add(idUsuario);
            infoUsuario.add(idade);
            infoUsuario.add(sexo);
            infoUsuario.add(telefone);
            infoUsuario.add(cpf);
            infoUsuario.add(label);
            usserPanel.add(infoUsuario, BorderLayout.CENTER);
            userList.add(usserPanel);
        }

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

    }
}
