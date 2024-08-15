package View;

import View.ViewsGerais.*;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem listarAcervoItem = new JMenuItem("Listar Acervo");
        JMenuItem listarEmprestimosItem = new JMenuItem("Listar Empréstimos");
        JMenuItem listarReservasItem = new JMenuItem("Listar Reservas");

        JMenuItem buscarEmprestimoItem = new JMenuItem("Buscar Empréstimo");
        JMenuItem buscarObraItem = new JMenuItem("Buscar Obra");
        JMenuItem depositarTrabalhoItem = new JMenuItem("Depositar Trabalho");

        menu.add(loginItem);
        menu.add(listarAcervoItem);
        menu.add(listarEmprestimosItem);
        menu.add(listarReservasItem);
        menu.add(buscarEmprestimoItem);
        menu.add(buscarObraItem);
        menu.add(depositarTrabalhoItem);

        menuBar.add(menu, BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        mainPanel.add(new LoginView(), "Login");
        mainPanel.add(new ListarAcervoView(), "Listar Acervo");
        mainPanel.add(new ListarEmprestimoView(), "Listar Empréstimos");
        mainPanel.add(new ListarReservaView(), "Listar Reservas");
        mainPanel.add(new BuscarEmprestimoView(), "Buscar Empréstimo");
        mainPanel.add(new BuscarObraView(), "Buscar Obra");
        mainPanel.add(new DepositarTrabalhoView(), "Depositar Trabalho");

        loginItem.addActionListener(e -> switchPanel(mainPanel, "Login"));
        listarAcervoItem.addActionListener(e -> switchPanel(mainPanel, "Listar Acervo"));
        listarEmprestimosItem.addActionListener(e -> switchPanel(mainPanel, "Listar Empréstimos"));
        listarReservasItem.addActionListener(e -> switchPanel(mainPanel, "Listar Reservas"));
        buscarEmprestimoItem.addActionListener(e -> switchPanel(mainPanel, "Buscar Empréstimo"));
        buscarObraItem.addActionListener(e -> switchPanel(mainPanel, "Buscar Obra"));
        depositarTrabalhoItem.addActionListener(e -> switchPanel(mainPanel, "Depositar Trabalho"));

        frame.setVisible(true);
    }

    private static void switchPanel(JPanel panel, String name) {
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel, name);
    }
}
