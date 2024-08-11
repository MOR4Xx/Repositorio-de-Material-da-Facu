package View;

import javax.swing.*;
import java.awt.*;

public class BuscarObraView extends JPanel {

    public BuscarObraView() {
        setLayout(new BorderLayout());
        add(new JLabel("Buscar Obra"), BorderLayout.NORTH);
        JTextField buscarObraField = new JTextField("Digite o código da Obra", 20);
        add(buscarObraField, BorderLayout.CENTER);
        add(new JButton("Buscar"), BorderLayout.SOUTH);
    }
}
