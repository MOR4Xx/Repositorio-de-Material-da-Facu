package View.ViewsGerais;

import View.ViewsFuncionario.*;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView {

    public MenuPrincipalView() {
        // Criação do JFrame
        JFrame frame = new JFrame("Biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Criação do JMenuBar e menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenu menuFuncionario = new JMenu("Menu Funcionario");

        // Criação dos JMenuItems
        JMenuItem loginItem = new JMenuItem("Login");
        JMenuItem listarAcervoItem = new JMenuItem("Listar Acervo");
        JMenuItem listarEmprestimosItem = new JMenuItem("Listar Empréstimos");
        JMenuItem listarReservasItem = new JMenuItem("Listar Reservas");
        JMenuItem buscarEmprestimoItem = new JMenuItem("Buscar Empréstimo");
        JMenuItem buscarObraItem = new JMenuItem("Buscar Obra");
        JMenuItem depositarTrabalhoItem = new JMenuItem("Depositar Trabalho");

        JMenuItem listarUsuarios = new JMenuItem("Listar Usuários");
        JMenuItem cdeeViewItem = new JMenuItem("Cadastrar/Editar/View");
        JMenuItem emprestarViewItem = new JMenuItem("Emprestar");
        JMenuItem reservaViewItem = new JMenuItem("Reservas");
        JMenuItem renovacaoDevolucaoViewItem = new JMenuItem("Renovação/Devolução");
        JMenuItem verObraDigitalItem = new JMenuItem("Ver Obra Digital");  // Novo item de menu

        // Adicionando JMenuItems aos menus
        menu.add(loginItem);
        menu.add(listarAcervoItem);
        menu.add(listarEmprestimosItem);
        menu.add(listarReservasItem);
        menu.add(buscarEmprestimoItem);
        menu.add(buscarObraItem);
        menu.add(depositarTrabalhoItem);

        menuFuncionario.add(listarUsuarios);
        menuFuncionario.add(cdeeViewItem);
        menuFuncionario.add(emprestarViewItem);
        menuFuncionario.add(reservaViewItem);
        menuFuncionario.add(renovacaoDevolucaoViewItem);
        menuFuncionario.add(verObraDigitalItem);  // Adicionando o novo item ao menu

        // Adicionando menus à barra de menus
        menuBar.add(menu);
        menuBar.add(menuFuncionario);
        frame.setJMenuBar(menuBar);

        // Criação do painel principal
        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel, BorderLayout.CENTER);

        // Adicionando as views ao mainPanel
        mainPanel.add(new LoginView(), "Login");
        mainPanel.add(new ListarAcervoView(), "Listar Acervo");
        mainPanel.add(new ListarEmprestimoView(), "Listar Empréstimos");
        mainPanel.add(new ListarReservaView(), "Listar Reservas");
        mainPanel.add(new BuscarEmprestimoView(), "Buscar Empréstimo");
        mainPanel.add(new BuscarObraView(), "Buscar Obra");
        mainPanel.add(new DepositarTrabalhoView(), "Depositar Trabalho");

        mainPanel.add(new ListarUsuarioView(), "Listar Usuários");
        mainPanel.add(new CadVisuEditExcluiView(), "Cadastrar/Editar/View");
        mainPanel.add(new EmprestarView(), "Emprestar");
        mainPanel.add(new ReservaView(), "Reservas");
        mainPanel.add(new RenovacaoDevolucaoView(), "Renovação/Devolução");
        mainPanel.add(new AcessarObraDigitalView(), "Ver Obra Digital");  // Adicionando a ViewObraDigital

        // Associando ações aos JMenuItems
        loginItem.addActionListener(e -> switchPanel(mainPanel, "Login"));
        listarAcervoItem.addActionListener(e -> switchPanel(mainPanel, "Listar Acervo"));
        listarEmprestimosItem.addActionListener(e -> switchPanel(mainPanel, "Listar Empréstimos"));
        listarReservasItem.addActionListener(e -> switchPanel(mainPanel, "Listar Reservas"));
        buscarEmprestimoItem.addActionListener(e -> switchPanel(mainPanel, "Buscar Empréstimo"));
        buscarObraItem.addActionListener(e -> switchPanel(mainPanel, "Buscar Obra"));
        depositarTrabalhoItem.addActionListener(e -> switchPanel(mainPanel, "Depositar Trabalho"));

        listarUsuarios.addActionListener(e -> switchPanel(mainPanel, "Listar Usuários"));
        cdeeViewItem.addActionListener(e -> switchPanel(mainPanel, "Cadastrar/Editar/View"));
        emprestarViewItem.addActionListener(e -> switchPanel(mainPanel, "Emprestar"));
        reservaViewItem.addActionListener(e -> switchPanel(mainPanel, "Reservas"));
        renovacaoDevolucaoViewItem.addActionListener(e -> switchPanel(mainPanel, "Renovação/Devolução"));
        verObraDigitalItem.addActionListener(e -> switchPanel(mainPanel, "Ver Obra Digital"));  // Ação para ver obras digitais

        // Exibindo o frame
        frame.setVisible(true);
    }

    // Método para alternar entre os paineis
    private static void switchPanel(JPanel panel, String name) {
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel, name);
    }
}
