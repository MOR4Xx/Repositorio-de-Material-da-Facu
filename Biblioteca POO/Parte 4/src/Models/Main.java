package Models;
import DAO.EmprestimoDAO;
import DAO.LivroDAO;
import DAO.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Livro> livros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Emprestimo> emprestimos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        login();

        int opcao;
        do {
            if (LoginUser.isFuncionario()) {
                mostrarMenuFuncionario();
            } else {
                mostrarMenuUsuario();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (LoginUser.isFuncionario()) {
                menuFuncionario(opcao);
            } else {
                menuUsuarios(opcao);
            }

        } while (opcao != 0);
    }

    private static void login() {
        while (true) {
            System.out.print("Login: ");
            String username = scanner.nextLine();
            System.out.print("Senha: ");
            String password = scanner.nextLine();

            if (LoginUser.login(username, password)) {
                System.out.println("Logado com sucesso!");
                break;
            } else {
                System.out.println("Não foi possível fazer login!");
            }
        }
    }

    private static void mostrarMenuFuncionario() {
        System.out.println("Menu Funcionário:");
        System.out.println("1. Cadastro de Livro");
        System.out.println("2. Cadastro de Usuário");
        System.out.println("3. Fazer Empréstimo");
        System.out.println("4. Fazer Devolução");
        System.out.println("5. Lista de Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void mostrarMenuUsuario() {
        System.out.println("Menu Usuário:");
        System.out.println("1. Lista de Livros");
        System.out.println("2. Realizar Empréstimo");
        System.out.println("3. Realizar Devolução");
        System.out.println("4. Listar Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void menuFuncionario(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarLivro();
                break;
            case 2:
                cadastrarUsuario();
                break;
            case 3:
                realizarEmprestimo();
                break;
            case 4:
                devolucao();
                break;
            case 5:
                listaEmprestimos();
                break;
            case 0:
                System.out.println("Saindo do programa!");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void menuUsuarios(int opcao) {
        switch (opcao) {
            case 1:
                listarLivros();
                break;
            case 2:
                realizarEmprestimo();
                break;
            case 3:
                devolucao();
                break;
            case 4:
                listaEmprestimos();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarLivro() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Editora: ");
        String editora = scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Número de páginas: ");
        int paginas = scanner.nextInt();
        System.out.print("Edição: ");
        int edicao = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(id, titulo, autor, editora, area, ano, paginas, edicao, false);
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.salvar(livro);
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void cadastrarUsuario() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.println("1. Aluno \n2. Professor \n3. Funcionário");
        System.out.print("Tipo de Usuário: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario;
        switch (tipo) {
            case 1:
                System.out.print("Curso do aluno: ");
                String curso = scanner.nextLine();
                System.out.print("Ano de Ingresso do aluno: ");
                int anoIngresso = scanner.nextInt();
                scanner.nextLine();
                usuario = new Estudante(id, nome, idade, sexo, telefone, curso, anoIngresso);
                break;
            case 2:
                System.out.print("Departamento do professor: ");
                String departamento = scanner.nextLine();
                System.out.print("Especialização do professor: ");
                String especializacao = scanner.nextLine();
                usuario = new Professor(id, nome, idade, sexo, telefone, departamento, especializacao);
                break;
            case 3:
                System.out.print("Setor do funcionário: ");
                String setor = scanner.nextLine();
                System.out.print("Cargo do funcionário: ");
                String cargo = scanner.nextLine();
                usuario = new Funcionario(id, nome, idade, sexo, telefone, setor, cargo);
                break;
            default:
                System.out.println("Selecione um tipo correto de usuário");
                return;
        }

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.salvar(usuario);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado!");
    }

    private static void realizarEmprestimo() {
        System.out.print("ID do Empréstimo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("ID do Livro: ");
        int idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("ID do Usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.ler(idLivro);
        Usuario usuario = new UsuarioDAO().ler(idUsuario);

        if (livro == null || usuario == null) {
            System.out.println("Livro ou Usuário não encontrado.");
            return;
        }

        System.out.println("Digite a data do empréstimo (Ex: 10072024): ");
        String data = scanner.nextLine();
        System.out.println("Digite a hora do empréstimo (Ex: 1030): ");
        String hora = scanner.nextLine();

        Emprestimo emprestimo = new Emprestimo(id, data, hora, livro, usuario);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        emprestimoDAO.salvar(emprestimo);
        emprestimos.add(emprestimo);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    private static void devolucao() {
        System.out.print("ID do Empréstimo: ");
        int idEmprestimo = scanner.nextInt();
        scanner.nextLine();

        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        Emprestimo emprestimo = emprestimoDAO.ler(idEmprestimo);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado.");
            return;
        }

        LivroDAO livroDAO = new LivroDAO();
        Livro livro = emprestimo.getLivro();
        livroDAO.atualizar(livro);

        emprestimoDAO.excluir(idEmprestimo);
        emprestimos.remove(emprestimo);

        System.out.println("Devolução realizada com sucesso!");
    }

    private static void listaEmprestimos() {
        System.out.println("Lista de Empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    private static void listarLivros() {
        System.out.println("Lista de Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

}
