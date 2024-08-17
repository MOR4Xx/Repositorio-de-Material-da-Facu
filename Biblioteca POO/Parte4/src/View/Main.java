package View;

import View.ViewsGerais.MenuPrincipalView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Percorre os estilos instalados e seleciona o Nimbus
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Criando a interface gráfica
        SwingUtilities.invokeLater(() -> new MenuPrincipalView());

    }
}
