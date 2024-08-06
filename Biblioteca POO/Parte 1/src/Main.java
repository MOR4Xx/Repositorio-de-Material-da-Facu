
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Cadastrar livro");
                System.out.println("2. Cadastrar usuário");
                System.out.println("3. Realizar empréstimo");
                System.out.println("4. Realizar devolução");
                System.out.println("5. Listar todos os empréstimos");
                System.out.println("6- Abrir livro");
                System.out.println("7- Fechar livro");
                System.out.println("0. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarLivro(scanner);
                        break;
                    case 2:
                        cadastrarUsuario(scanner);
                        break;
                    case 3:
                        realizarEmprestimo(scanner);
                        break;
                    case 4:
                        realizarDevolucao(scanner);
                        break;
                    case 5:
                        listarEmprestimos();
                        break;
                    case 6:
                        
                        break;
                    case 7:

                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();  // Limpa o buffer do scanner
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }

    private static void cadastrarLivro(Scanner scanner) {
        try {
            System.out.println("Título:");
            String titulo = scanner.nextLine();
            System.out.println("Autores:");
            String autores = scanner.nextLine();
            System.out.println("Área:");
            String area = scanner.nextLine();
            System.out.println("Editora:");
            String editora = scanner.nextLine();
            System.out.println("Ano:");
            int ano = scanner.nextInt();
            System.out.println("Edição:");
            int edicao = scanner.nextInt();
            System.out.println("Número de Folhas:");
            int numeroFolhas = scanner.nextInt();
            scanner.nextLine();

            Livro livro = new Livro(titulo, autores, area, editora, ano, edicao, numeroFolhas);
            livros.add(livro);
            System.out.println("Livro cadastrado com sucesso.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretamente.");
            scanner.nextLine();  // Limpa o buffer do scanner
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        try {
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("Idade:");
            int idade = scanner.nextInt();
            System.out.println("Sexo:");
            String sexo = scanner.next();
            System.out.println("Telefone:");
            String telefone = scanner.next();
            scanner.nextLine();

            Usuario usuario = new Usuario(nome, idade, sexo, telefone);
            usuarios.add(usuario);
            System.out.println("Usuário cadastrado com sucesso.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretamente.");
            scanner.nextLine();  // Limpa o buffer do scanner
        }
    }

    private static void realizarEmprestimo(Scanner scanner) {
        try {
            System.out.println();
            System.out.println("Selecione o livro pelo índice:");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println(i+1 + ". " + livros.get(i).getTitulo());
            }
            int livroIndex = scanner.nextInt();
            scanner.nextLine();
            Livro livro = livros.get(livroIndex-1);

            System.out.println("Selecione o usuário pelo índice:");
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println(i + ". " + usuarios.get(i).getNome());
            }
            int usuarioIndex = scanner.nextInt();
            scanner.nextLine();
            Usuario usuario = usuarios.get(usuarioIndex-1);
            System.out.println("Digite a data do emprestimo: ");
            String dataEmprestimo = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Digite a hora do emprestimo: ");
            String horaEmprestimo = scanner.nextLine();
            scanner.nextLine();

            Emprestimo emprestimo = new Emprestimo(dataEmprestimo, horaEmprestimo, livro, usuario);
            emprestimos.add(emprestimo);
            livro.setEmprestimo(true);
            System.out.println("Empréstimo realizado com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido. Por favor, selecione um índice válido.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretamente.");
            scanner.nextLine();  // Limpa o buffer do scanner
        }
    }

    private static void realizarDevolucao(Scanner scanner) {
        try {
            System.out.println();
            System.out.println("Selecione o empréstimo pelo índice:");
            for (int i = 0; i < emprestimos.size(); i++) {
                System.out.println(i+1 + ". Empréstimo de " + emprestimos.get(i).getLivro().getTitulo() + " por " + emprestimos.get(i).getUsuario().getNome());
            }
            int emprestimoIndex = scanner.nextInt();
            scanner.nextLine();
            Emprestimo emprestimo = emprestimos.get(emprestimoIndex-1);

            emprestimo.devolverLivro();
            emprestimos.remove(emprestimoIndex);
            System.out.println("Devolução realizada com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Índice inválido. Por favor, selecione um índice válido.");
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, insira os dados corretamente.");
            scanner.nextLine();  // Limpa o buffer do scanner
        }
    }

    private static void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println();
                System.out.println("------Empréstimo------");
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Leitor: " + emprestimo.getUsuario().getNome());
                System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo() + " às " + emprestimo.getHoraEmprestimo());
                System.out.println();
            }
        }
    }
}
