
import java.io.*;


public class LivroDAO implements DAO<Livro> {

    @Override
    public void salvar(Livro livro)  {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt", true));
            writer.write(livro.getId() + "," + livro.getTitulo() + "," + livro.getAutores() + "," + livro.getEditora() + ","
                    + livro.getArea() + "," + livro.getAno() + "," + livro.getNumFolhas() + "," + livro.getEdicao() + "," + livro.isEmprestimo());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void excluir(int id) throws IOException {
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
    }

    @Override
    public Livro ler(int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("livros.txt"));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");

            if (data.length < 9) {
                System.out.println(currentLine);
                continue;
            }

            if (Integer.parseInt(data[0]) == id) {
                reader.close();
                return new Livro(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6]),
                        Integer.parseInt(data[7]),
                        Boolean.parseBoolean(data[8])
                );
            }
        }
        reader.close();
        return null;
    }

    public void atualizar(Livro livro) throws IOException {
        excluir(livro.getId());
        salvar(livro);
    }

    public void atualizarStatus(int id, boolean emprestado) throws IOException {
        Livro livro = ler(id);
        if (livro != null) {
            livro.setEmprestimo(emprestado);
            atualizar(livro);
        }
    }
}