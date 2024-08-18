package Controllers.ControllerViewsFuncionario;

import DAO.LivroDAO;
import DAO.UsuarioDAO;
import View.ViewsFuncionario.CadVisuEditExcluiView;

import java.sql.Connection;

public class ControllerCadVisuEditExclui {
    private CadVisuEditExcluiView view;
    private LivroDAO livroDAO;
    private UsuarioDAO usuarioDAO;

    public ControllerCadVisuEditExclui(CadVisuEditExcluiView view) {
        this.view = view;
        this.livroDAO = new LivroDAO();
        this.usuarioDAO = new UsuarioDAO();
        initController();
    }

    private void initView(){
        view.setVisible(true);
    }

    private void initController() {
        view.getCadastrarLivroBtn().addActionListener(e -> cadastrarLivro());
        view.getVisualizarLivrosBtn().addActionListener(e -> visualizarLivros());
        view.getEditarLivroBtn().addActionListener(e -> editarLivro());
        view.getExcluirLivroBtn().addActionListener(e -> excluirLivro());

        view.getCadastrarUsuarioBtn().addActionListener(e -> cadastrarUsuario());
        view.getVisualizarUsuariosBtn().addActionListener(e -> visualizarUsuarios());
        view.getEditarUsuarioBtn().addActionListener(e -> editarUsuario());
        view.getExcluirUsuarioBtn().addActionListener(e -> excluirUsuario());
    }

    private void cadastrarLivro() {
    }

    private void visualizarLivros() {
    }

    private void editarLivro() {
    }

    private void excluirLivro() {
    }

    private void cadastrarUsuario() {
    }

    private void visualizarUsuarios() {
    }

    private void editarUsuario() {
    }

    private void excluirUsuario() {
    }

}
