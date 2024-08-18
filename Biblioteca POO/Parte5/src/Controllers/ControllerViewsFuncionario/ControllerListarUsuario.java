package Controllers.ControllerViewsFuncionario;

import DAO.UsuarioDAO;
import Models.Usuario;
import View.ViewsFuncionario.ListarUsuarioView;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ControllerListarUsuario {
    private ListarUsuarioView view;
    private UsuarioDAO usuarioDAO;

    public ControllerListarUsuario(ListarUsuarioView view) {
        this.view = view;
        this.usuarioDAO = new UsuarioDAO();
        initView();
    }

    private void initView() {
        view.setVisible(true);
        carregarUsuarios();
    }

    private void carregarUsuarios() {
        try {
            List<Usuario> usuarios = usuarioDAO.listarUsuarios();

            if (usuarios.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Nenhum usuário encontrado.");
            } else {
                view.exibirUsuarios(usuarios);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar usuários: " + e.getMessage());
        }
    }
}
