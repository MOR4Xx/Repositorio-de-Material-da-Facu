
import java.io.*;

public class EmprestimoDAO implements DAO<Emprestimo> {

    public void salvar(Emprestimo emprestimo) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("emprestimos.txt", true));
            writer.write(emprestimo.getId() + "," + emprestimo.getDataEmprestimo() + "," + emprestimo.getHoraEmprestimo() + "," + emprestimo.getLivro().getId() + "," + emprestimo.getUsuario().getId());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) throws IOException {
        File inputFile = new File("emprestimos.txt");
        File tempFile = new File("emprestimos_temp.txt");

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

    public Emprestimo ler(int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("emprestimos.txt"));
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            String[] data = currentLine.split(",");
            if (Integer.parseInt(data[0]) == id) {
                reader.close();
                int idLivro = Integer.parseInt(data[3]);
                int idUsuario = Integer.parseInt(data[4]);
                Livro livro = new LivroDAO().ler(idLivro);
                Usuario usuario = new UsuarioDAO().ler(idUsuario);
                String dataEmprestimo = String.valueOf(data[1]);
                String horaEmprestimo = String.valueOf(data[2]);
                return new Emprestimo(id, dataEmprestimo, horaEmprestimo, livro, usuario);
            }
        }
        reader.close();
        return null;
    }

    public void atualizar(Emprestimo emprestimo) throws IOException {
        excluir(emprestimo.getId());
        salvar(emprestimo);
    }
}