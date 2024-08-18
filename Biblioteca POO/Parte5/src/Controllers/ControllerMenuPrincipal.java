package Controllers;

import Controllers.ControllerViewsFuncionario.*;
import Controllers.ControllerViewsGerais.*;
import View.MenuPrincipalView;
import View.ViewsFuncionario.*;
import View.ViewsGerais.*;

import javax.swing.*;
import java.awt.*;

public class ControllerMenuPrincipal {
    private MenuPrincipalView view;
    private JPanel mainPanel;

    public ControllerMenuPrincipal() {
        view = new MenuPrincipalView();
        this.mainPanel = view.getMainPanel();
        initView();
        initController();
    }

    public void initView() {
        view.setVisible(true);
        loginView();
    }

    public void initController() {
        view.getLoginItem().addActionListener(e -> loginView());
        view.getListarAcervoItem().addActionListener(e -> listarAcervo());
        view.getListarEmprestimosItem().addActionListener(e -> listarEmprestimo());
        view.getListarReservasItem().addActionListener(e -> listarReserva());
        view.getBuscarEmprestimoItem().addActionListener(e -> buscarEmprestimo());
        view.getBuscarObraItem().addActionListener(e -> buscarObra());
        view.getDepositarTrabalhoItem().addActionListener(e -> depositarTrabalho());

        view.getListarUsuariosItem().addActionListener(e -> listarUsuarios());
        view.getCdeeViewItem().addActionListener(e -> cadVisuEditExclui());
        view.getEmprestarViewItem().addActionListener(e -> emprestar());
        view.getReservaViewItem().addActionListener(e -> reserva());
        view.getRenovacaoDevolucaoViewItem().addActionListener(e -> renovacaoDevolucao());
        view.getVerObraDigitalItem().addActionListener(e -> verObraDigital());
    }


    private void loginView() {
        LoginView loginView = new LoginView();
        mainPanel.add(loginView, "Login");
        switchPanel(mainPanel, "Login");
    }

    private void listarAcervo() {
        ListarAcervoView listarAcervoView = new ListarAcervoView();
        ControllerListarAcervo listarAcervo = new ControllerListarAcervo(listarAcervoView);
        mainPanel.add(listarAcervoView, "Acervo");
        switchPanel(mainPanel, "Acervo");
    }

    private void listarEmprestimo() {
        ListarEmprestimoView listarEmprestimoView = new ListarEmprestimoView();
        ControllerListarEmprestimo controllerListarEmprestimo = new ControllerListarEmprestimo(listarEmprestimoView);
        mainPanel.add(listarEmprestimoView, "Emprestimo");
        switchPanel(mainPanel, "Emprestimo");
    }
    private void listarReserva() {
        ListarReservaView listarReservaView = new ListarReservaView();
        ControllerListarReserva controllerListarReserva = new ControllerListarReserva(listarReservaView);
        mainPanel.add(listarReservaView, "Reservas");
        switchPanel(mainPanel, "Reservas");
    }

    private void buscarEmprestimo() {
        BuscarEmprestimoView buscarEmprestimoView = new BuscarEmprestimoView();
        ControllerBuscarEmprestimo controllerBuscarEmprestimo = new ControllerBuscarEmprestimo(buscarEmprestimoView);
        mainPanel.add(buscarEmprestimoView, "Buscar Emprestimo");
        switchPanel(mainPanel, "Buscar Emprestimo");
    }

    private void buscarObra() {
        BuscarObraView buscarObraView = new BuscarObraView();
        ControllerBuscarObra controllerBuscarObra = new ControllerBuscarObra(buscarObraView);
        mainPanel.add(buscarObraView, "Buscar Obra");
        switchPanel(mainPanel, "Buscar Obra");
    }

    private void depositarTrabalho() {
        DepositarTrabalhoView depositarTrabalhoView = new DepositarTrabalhoView();
        ControllerDepositarTrabalho controllerDepositarTrabalho = new ControllerDepositarTrabalho(depositarTrabalhoView);
        mainPanel.add(depositarTrabalhoView, "Depositar Trabalho");
        switchPanel(mainPanel, "Depositar Trabalho");
    }

    private void listarUsuarios() {
        ListarUsuarioView listarUsuarioView = new ListarUsuarioView();
        ControllerListarUsuario controllerListarUsuarioView = new ControllerListarUsuario(listarUsuarioView);
        mainPanel.add(listarUsuarioView, "Listar Usuarios");
        switchPanel(mainPanel, "Listar Usuarios");
    }

    private void cadVisuEditExclui() {
        CadVisuEditExcluiView cadVisuEditExcluiView = new CadVisuEditExcluiView();
        ControllerCadVisuEditExclui controllerCadVisuEditExclui = new ControllerCadVisuEditExclui(cadVisuEditExcluiView);
        mainPanel.add(cadVisuEditExcluiView, "Cadastrar/Editar/View");
        switchPanel(mainPanel, "Cadastrar/Editar/View");
    }

    private void emprestar() {
        EmprestarView emprestarView = new EmprestarView();
        ControllerEmprestar controllerEmprestar = new ControllerEmprestar(emprestarView);
        mainPanel.add(emprestarView, "Emprestar");
        switchPanel(mainPanel, "Emprestar");
    }

    private void reserva() {
        ReservaView reservaView = new ReservaView();
        ControllerReserva controllerReserva= new ControllerReserva(reservaView);
        mainPanel.add(reservaView, "Reservas");
        switchPanel(mainPanel, "Reservas");
    }

    private void renovacaoDevolucao() {
        RenovacaoDevolucaoView renovacaoDevolucaoView = new RenovacaoDevolucaoView();
        ControllerRenovacaoDevolucao controllerRenovacaoDevolucao = new ControllerRenovacaoDevolucao(renovacaoDevolucaoView);
        mainPanel.add(renovacaoDevolucaoView, "Renovacao/Devolucao");
        switchPanel(mainPanel, "Renovacao/Devolucao");
    }

    private void verObraDigital() {
        AcessarObraDigitalView acessarObraDigitalView = new AcessarObraDigitalView();
        ControllerAcessarObraDigital controllerAcessarObraDigital = new ControllerAcessarObraDigital(acessarObraDigitalView);
        mainPanel.add(acessarObraDigitalView, "Ver Obra Digital");
        switchPanel(mainPanel, "Ver Obra Digital");
    }

    private static void switchPanel(JPanel panel, String name) {
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel, name);
    }
}
