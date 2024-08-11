import java.io.*;

public class Livro extends Obra implements DAO<Livro> {

    private boolean emprestimo;
    private int edicao;
    private int numFolhas;
    private int id;

    public Livro() {
    }

    public Livro(boolean emprestimo, int edicao, int numFolhas, int id) {
        this.emprestimo = emprestimo;
        this.edicao = edicao;
        this.numFolhas = numFolhas;
        this.id = id;
    }

    public Livro(int id, String titulo, String area, String autores, String editora, int ano, int edicao, int numFolhas, boolean emprestimo) {
        super(titulo, area, autores, editora, ano);
        this.emprestimo = emprestimo;
        this.edicao = edicao;
        this.numFolhas = numFolhas;
        this.id = id;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getNumFolhas() {
        return numFolhas;
    }

    public void setNumFolhas(int numFolhas) {
        this.numFolhas = numFolhas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos adicionais
    public void abrirLivro() {
        System.out.println("O livro está aberto para leitura.");
    }

    public void fecharLivro() {
        System.out.println("O livro está fechado para leitura.");
    }

    // Implementação dos métodos da interface DAO
    @Override
    public void salvar(Livro livro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt", true));
            writer.write(livro.getId() + "," + livro.getTitulo() + "," + livro.getAutores() + "," + livro.getArea() + ","
                    + livro.getEditora() + "," + livro.getAno() + "," + livro.getEdicao() + "," + livro.getNumFolhas() + "," + livro.isEmprestimo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) throws IOException {
        File inputFile = new File("livros.txt");
        File tempFile = new File("livros_temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (Integer.parseInt(data[0]) == id) {
                continue;
            }
            writer.write(currentLine);
            writer.newLine();
        }
        writer.close();
        reader.close();
        tempFile.renameTo(inputFile);
        return currentLine;
    }

    @Override
    public Livro ler(int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("livros.txt"));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (Integer.parseInt(data[0]) == id) {
                reader.close();
                return new Livro(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7]), Boolean.parseBoolean(data[8]));
            }
        }
        reader.close();
        return null;
    }

    @Override
    public void atualizar(Livro livro) throws IOException {
        excluir(livro.getId());
        salvar(livro);
    }
}
