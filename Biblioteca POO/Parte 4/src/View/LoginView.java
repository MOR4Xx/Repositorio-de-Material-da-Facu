package View;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
    private JTextField loginField;
    private JPasswordField senhaField;
    private JButton loginButton;

    public LoginView(){
        frame();
    }
    private void frame() {
        setLayout(null);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(5, 50, 50, 20);
        add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(5, 70, 200, 20);
        add(loginField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(5, 90, 60, 20);
        add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(5, 110, 200, 20);
        add(senhaField);

        JLabel logado = new JLabel();
        logado.setBounds(5, 140, 200, 20);
        add(logado);


        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25, 20));
        loginButton.setBounds(35, 170, 120, 20);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = senhaField.getText();

                // Verifica se o login e senha são corretos
                // Lógica de autenticação
                if ("admin".equals(login) && "admin".equals(senha)) {
                    // Login bem-sucedido: mostra a JMenuBar do JFrame principal
//                    if (menuPrincipal != null) {
//                        menuPrincipal.mostrarAdmMenu(true);
//                        logado.setText("Login efetuado com sucesso");
//                    }

                    loginField.setText("");
                    senhaField.setText("");

                    // Ações adicionais após o login, como mudar de tela, etc.
                } else {
                    // Login falhou: ações de feedback ao usuário, se necessário
                    System.out.println("Login falhou");
                }
            }

        });
    }
}