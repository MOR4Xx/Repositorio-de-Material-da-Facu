package View;

import View.ViewsFuncionario.*;
import View.ViewsGerais.*;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipalView extends JFrame {
    private JMenuItem loginItem;
    private JMenuItem listarAcervoItem;
    private JMenuItem listarEmprestimosItem;
    private JMenuItem listarReservasItem;
    private JMenuItem buscarEmprestimoItem;
    private JMenuItem buscarObraItem;
    private JMenuItem depositarTrabalhoItem;

    private JMenuItem listarUsuariosItem;
    private JMenuItem cdeeViewItem;
    private JMenuItem emprestarViewItem;
    private JMenuItem reservaViewItem;
    private JMenuItem renovacaoDevolucaoViewItem;
    private JMenuItem verObraDigitalItem;

    private JPanel mainPanel;

    public MenuPrincipalView() {
        setTitle("Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Criação do JMenuBar e menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenu menuFuncionario = new JMenu("Menu Funcionario");

        // Inicialização dos JMenuItems
        loginItem = new JMenuItem("Login");
        listarAcervoItem = new JMenuItem("Listar Acervo");
        listarEmprestimosItem = new JMenuItem("Listar Empréstimos");
        listarReservasItem = new JMenuItem("Listar Reservas");
        buscarEmprestimoItem = new JMenuItem("Buscar Empréstimo");
        buscarObraItem = new JMenuItem("Buscar Obra");
        depositarTrabalhoItem = new JMenuItem("Depositar Trabalho");

        listarUsuariosItem = new JMenuItem("Listar Usuários");
        cdeeViewItem = new JMenuItem("Cadastrar/Editar/View");
        emprestarViewItem = new JMenuItem("Emprestar");
        reservaViewItem = new JMenuItem("Reservas");
        renovacaoDevolucaoViewItem = new JMenuItem("Renovação/Devolução");
        verObraDigitalItem = new JMenuItem("Ver Obra Digital");

        menu.add(loginItem);
        menu.add(listarAcervoItem);
        menu.add(listarEmprestimosItem);
        menu.add(listarReservasItem);
        menu.add(buscarEmprestimoItem);
        menu.add(buscarObraItem);
        menu.add(depositarTrabalhoItem);

        menuFuncionario.add(listarUsuariosItem);
        menuFuncionario.add(cdeeViewItem);
        menuFuncionario.add(emprestarViewItem);
        menuFuncionario.add(reservaViewItem);
        menuFuncionario.add(renovacaoDevolucaoViewItem);
        menuFuncionario.add(verObraDigitalItem);

        menuBar.add(menu);
        menuBar.add(menuFuncionario);
        setJMenuBar(menuBar);

        mainPanel = new JPanel(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

    }

    public JMenuItem getLoginItem() {
        return loginItem;
    }

    public JMenuItem getListarAcervoItem() {
        return listarAcervoItem;
    }

    public JMenuItem getListarEmprestimosItem() {
        return listarEmprestimosItem;
    }

    public JMenuItem getListarReservasItem() {
        return listarReservasItem;
    }

    public JMenuItem getBuscarEmprestimoItem() {
        return buscarEmprestimoItem;
    }

    public JMenuItem getBuscarObraItem() {
        return buscarObraItem;
    }

    public JMenuItem getDepositarTrabalhoItem() {
        return depositarTrabalhoItem;
    }

    public JMenuItem getListarUsuariosItem() {
        return listarUsuariosItem;
    }

    public JMenuItem getCdeeViewItem() {
        return cdeeViewItem;
    }

    public JMenuItem getEmprestarViewItem() {
        return emprestarViewItem;
    }

    public JMenuItem getReservaViewItem() {
        return reservaViewItem;
    }

    public JMenuItem getRenovacaoDevolucaoViewItem() {
        return renovacaoDevolucaoViewItem;
    }

    public JMenuItem getVerObraDigitalItem() {
        return verObraDigitalItem;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
