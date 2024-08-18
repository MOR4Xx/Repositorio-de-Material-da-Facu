package Controllers.ControllerViewsFuncionario;

import DAO.LivroDAO;
import Models.Livro;
import View.ViewsFuncionario.AcessarObraDigitalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import java.sql.SQLException;
import java.util.List;

public class ControllerAcessarObraDigital {
    private AcessarObraDigitalView view;
    private LivroDAO livroDAO;

    public ControllerAcessarObraDigital(AcessarObraDigitalView view) {
        this.view = view;
        carregarObrasDigitais();
        initView();
        initController();
    }
    private void initView(){
        view.setVisible(true);
    }
    private void initController() {
        view.getAbrirArquivoBtn().addActionListener(this::abrirArquivoSelecionado);
    }
    private void carregarObrasDigitais() {
        try {
            List<Livro> obrasDigitais = livroDAO.listarLivros();
            for (Livro livro : obrasDigitais) {
                if (livro.isDigital()) {  // Somente livros digitais
                    view.adicionarObraDigital(
                            livro.getId(),
                            livro.getTitulo(),
                            livro.getAutores(),
                            livro.getAno(),
                            "Digital",
                            "caminho/para/obra"  // Substitua pelo caminho real do arquivo
                    );
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Erro ao carregar obras digitais: " + e.getMessage());
        }
    }

    private void abrirArquivoSelecionado(ActionEvent e) {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1) {
            String caminhoDoArquivo = (String) view.getTableModel().getValueAt(selectedRow, 5);
            abrirArquivo(caminhoDoArquivo);
        } else {
            JOptionPane.showMessageDialog(view, "Selecione uma obra digital para abrir.");
        }
    }

    private void abrirArquivo(String caminhoDoArquivo) {
        try {
            Desktop desktop = Desktop.getDesktop();
            File arquivo = new File(caminhoDoArquivo);
            if (arquivo.exists()) {
                desktop.open(arquivo);
            } else {
                JOptionPane.showMessageDialog(view, "Arquivo não encontrado: " + caminhoDoArquivo);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao abrir o arquivo: " + ex.getMessage());
        }
    }

}
