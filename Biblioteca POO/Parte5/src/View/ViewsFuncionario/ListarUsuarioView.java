package View.ViewsFuncionario;

import Models.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ListarUsuarioView extends JPanel {
    private JPanel userList;
    private JLabel idUsuario;
    private JLabel nomeUsuario;
    private JLabel idade;
    private JLabel sexo;
    private JLabel telefone;
    private JLabel cpf;

    public ListarUsuarioView() {
        setLayout(new BorderLayout());
        userList = new JPanel();
        userList.setLayout(new BoxLayout(userList, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void exibirUsuarios(List<Usuario> usuarios) {
        userList.removeAll();

        for (Usuario usuario : usuarios) {
            JPanel userPanel = new JPanel();
            userPanel.setLayout(new BorderLayout());
            userPanel.setPreferredSize(new Dimension(300, 80));

            JPanel infoUsuario = new JPanel();
            infoUsuario.setLayout(new GridLayout(6, 1));

            idUsuario = new JLabel("ID: " + usuario.getId());
            idUsuario.setFont(new Font("Arial", Font.BOLD, 11));
            nomeUsuario = new JLabel("Nome: " + usuario.getNome());
            nomeUsuario.setFont(new Font("Arial", Font.BOLD, 11));
            idade = new JLabel("Idade: " + usuario.getIdade());
            idade.setFont(new Font("Arial", Font.PLAIN, 11));
            sexo = new JLabel("Sexo: " + usuario.getSexo());
            sexo.setFont(new Font("Arial", Font.PLAIN, 11));
            telefone = new JLabel("Telefone: " + usuario.getTelefone());
            telefone.setFont(new Font("Arial", Font.PLAIN, 11));
            cpf = new JLabel("CPF: " + usuario.getCpf());
            cpf.setFont(new Font("Arial", Font.PLAIN, 11));

            infoUsuario.add(nomeUsuario);
            infoUsuario.add(idUsuario);
            infoUsuario.add(idade);
            infoUsuario.add(sexo);
            infoUsuario.add(telefone);
            infoUsuario.add(cpf);

            userPanel.add(infoUsuario, BorderLayout.CENTER);
            userList.add(userPanel);
        }

        userList.revalidate();
        userList.repaint();
    }
}
