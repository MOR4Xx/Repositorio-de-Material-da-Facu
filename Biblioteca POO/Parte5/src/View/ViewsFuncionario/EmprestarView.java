package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class EmprestarView extends JPanel {
    private JButton emprestarBtn;
    private JPanel formPanel;
    private JTextField usuarioField;
    private JTextField obraField;

    public EmprestarView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Emprestar Obra", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        formPanel = new JPanel(new GridLayout(20, 1, 10, 10));

        formPanel.add(new JLabel("ID Usuario:"));
        usuarioField = new JTextField();
        formPanel.add(usuarioField);

        formPanel.add(new JLabel("ID da Obra:"));
        obraField = new JTextField();
        formPanel.add(obraField);

        emprestarBtn = new JButton("Realizar Empréstimo");

        add(formPanel, BorderLayout.CENTER);
        add(emprestarBtn, BorderLayout.SOUTH);
    }

    public JButton getEmprestarBtn() {
        return emprestarBtn;
    }

    public void setEmprestarBtn(JButton emprestarBtn) {
        this.emprestarBtn = emprestarBtn;
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(JPanel formPanel) {
        this.formPanel = formPanel;
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public void setUsuarioField(JTextField usuarioField) {
        this.usuarioField = usuarioField;
    }

    public JTextField getObraField() {
        return obraField;
    }

    public void setObraField(JTextField obraField) {
        this.obraField = obraField;
    }
}
