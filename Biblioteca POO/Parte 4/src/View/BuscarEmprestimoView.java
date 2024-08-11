package View;

import javax.swing.*;
import java.awt.*;

public class BuscarEmprestimoView extends JPanel {

    public BuscarEmprestimoView() {
        setLayout(new BorderLayout());
        add(new JLabel("Buscar Empréstimo"), BorderLayout.NORTH);
        JTextField buscarEmprestimoField = new JTextField("Digite o código do Empréstimo", 20);
        add(buscarEmprestimoField, BorderLayout.CENTER);
        add(new JButton("Buscar"), BorderLayout.SOUTH);
    }
}
