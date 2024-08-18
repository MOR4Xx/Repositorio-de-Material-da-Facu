package View.ViewsFuncionario;

import javax.swing.*;
import java.awt.*;

public class CadVisuEditExcluiView extends JPanel {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public CadVisuEditExcluiView() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Cadastrar/Visualizar/Editar/Excluir (Livros, Usuários)", JLabel.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 4));

        JButton cadastrarLivroBtn = new JButton("Cadastrar Livro");
        JButton visualizarLivrosBtn = new JButton("Visualizar Livros");
        JButton editarLivroBtn = new JButton("Editar Livro");
        JButton excluirLivroBtn = new JButton("Excluir Livro");

        JButton cadastrarUsuarioBtn = new JButton("Cadastrar Usuário");
        JButton visualizarUsuariosBtn = new JButton("Visualizar Usuários");
        JButton editarUsuarioBtn = new JButton("Editar Usuário");
        JButton excluirUsuarioBtn = new JButton("Excluir Usuário");

        buttonsPanel.add(cadastrarLivroBtn);
        buttonsPanel.add(visualizarLivrosBtn);
        buttonsPanel.add(editarLivroBtn);
        buttonsPanel.add(excluirLivroBtn);

        buttonsPanel.add(cadastrarUsuarioBtn);
        buttonsPanel.add(visualizarUsuariosBtn);
        buttonsPanel.add(editarUsuarioBtn);
        buttonsPanel.add(excluirUsuarioBtn);

        add(buttonsPanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(CadastrarLivroPanel(), "Cadastrar Livro");
        cardPanel.add(VisualizarLivrosPanel(), "Visualizar Livros");
        cardPanel.add(EditarLivroPanel(), "Editar Livro");
        cardPanel.add(ExcluirLivroPanel(), "Excluir Livro");
        cardPanel.add(CadastrarUsuarioPanel(), "Cadastrar Usuário");
        cardPanel.add(VisualizarUsuariosPanel(), "Visualizar Usuários");
        cardPanel.add(EditarUsuarioPanel(), "Editar Usuário");
        cardPanel.add(ExcluirUsuarioPanel(), "Excluir Usuário");

        add(cardPanel, BorderLayout.CENTER);

        cadastrarLivroBtn.addActionListener(e -> cardLayout.show(cardPanel, "Cadastrar Livro"));
        visualizarLivrosBtn.addActionListener(e -> cardLayout.show(cardPanel, "Visualizar Livros"));
        editarLivroBtn.addActionListener(e -> cardLayout.show(cardPanel, "Editar Livro"));
        excluirLivroBtn.addActionListener(e -> cardLayout.show(cardPanel, "Excluir Livro"));
        cadastrarUsuarioBtn.addActionListener(e -> cardLayout.show(cardPanel, "Cadastrar Usuário"));
        visualizarUsuariosBtn.addActionListener(e -> cardLayout.show(cardPanel, "Visualizar Usuários"));
        editarUsuarioBtn.addActionListener(e -> cardLayout.show(cardPanel, "Editar Usuário"));
        excluirUsuarioBtn.addActionListener(e -> cardLayout.show(cardPanel, "Excluir Usuário"));
    }

    public JPanel CadastrarLivroPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("Título:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Autor:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Ano:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Edição:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Área:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Páginas:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Formato:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Status:"));
        panel.add(new JTextField());
        JButton cadastrarBtn = new JButton("Cadastrar");
        panel.add(cadastrarBtn);
        return panel;
    }

    public JPanel VisualizarLivrosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable tabelaLivros = new JTable( // Exemplo de dados fictícios
                new Object[][]{
                        {"1", "Livro A", "Autor A", "2020", "Edição 1", "Ciência", "657", "Digital", "Emprestado"},
                        {"2", "Livro B", "Autor B", "2019", "Edição 1", "História", "499", "Físico", "Disponível"}
                },
                new String[]{"ID", "Título", "Autor", "Ano", "Edição", "Área", "Páginas", "Formato", "Status"}
        );
        panel.add(new JScrollPane(tabelaLivros), BorderLayout.CENTER);
        return panel;
    }

    public JPanel EditarLivroPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Livro:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Título:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Autor:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Ano:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Nova Edição:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Nova Área:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novas Páginas:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Formato:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Status:"));
        panel.add(new JTextField());
        JButton editarBtn = new JButton("Editar");
        panel.add(editarBtn);
        return panel;
    }

    public JPanel ExcluirLivroPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Livro:"));
        panel.add(new JTextField());
        JButton excluirBtn = new JButton("Excluir");
        panel.add(excluirBtn);
        return panel;
    }

    public JPanel CadastrarUsuarioPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Idade:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Sexo:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Telefone:"));
        panel.add(new JTextField());
        panel.add(new JLabel("CPF:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Tipo de Usuário (Aluno/Funcionário/Professor):"));
        panel.add(new JTextField());
        JButton cadastrarBtn = new JButton("Cadastrar");
        panel.add(cadastrarBtn);
        return panel;
    }

    public JPanel VisualizarUsuariosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTable tabelaUsuarios = new JTable( // Exemplo de dados fictícios
                new Object[][]{
                        {"1", "João Silva", "19", "Masculino", "64567899", "39024824934", "Aluno"},
                        {"2", "Maria Souza", "18", "Feminino", "20935252", "23049823752", "Funcionário"}
                },
                new String[]{"ID", "Nome", "Idade", "Sexo", "Telefone", "CPF", "Tipo de Usuário"}
        );
        panel.add(new JScrollPane(tabelaUsuarios), BorderLayout.CENTER);
        return panel;
    }

    public JPanel EditarUsuarioPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Usuário:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Nome:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Nova Idade:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Sexo:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Telefone:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo CPF:"));
        panel.add(new JTextField());
        panel.add(new JLabel("Novo Tipo de Usuário:"));
        panel.add(new JTextField());
        JButton editarBtn = new JButton("Editar");
        panel.add(editarBtn);
        return panel;
    }

    public JPanel ExcluirUsuarioPanel() {
        JPanel panel = new JPanel(new GridLayout(20, 1, 10, 10));
        panel.add(new JLabel("ID do Usuário:"));
        panel.add(new JTextField());
        JButton excluirBtn = new JButton("Excluir");
        panel.add(excluirBtn);
        return panel;
    }
}
