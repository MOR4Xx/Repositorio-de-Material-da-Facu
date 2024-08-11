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
        setVisible(true);
        setLayout(new BorderLayout());
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(null);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(5, 50, 50, 20);
        panelCentral.add(loginLabel);

        loginField = new JTextField();
        loginField.setBounds(5, 70, 200, 20);
        panelCentral.add(loginField);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setBounds(5, 90, 60, 20);
        panelCentral.add(senhaLabel);

        senhaField = new JPasswordField();
        senhaField.setBounds(5, 110, 200, 20);
        panelCentral.add(senhaField);

        JLabel logado = new JLabel();
        logado.setBounds(5, 140, 200, 20);
        add(logado);


        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(25, 20));
        loginButton.setBounds(35, 170, 120, 20);
        panelCentral.add(loginButton);

        add(panelCentral, BorderLayout.CENTER);
        loginButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = senhaField.getText();


                if ("admin".equals(login) && "admin".equals(senha)) {
//                    if (menuPrincipal != null) {
//                        menuPrincipal.mostrarAdmMenu(true);
//                        logado.setText("Login efetuado com sucesso");
//                    }

                    loginField.setText("");
                    senhaField.setText("");
                } else {
                    System.out.println("Login falhou");
                }
            }

        });
    }
}