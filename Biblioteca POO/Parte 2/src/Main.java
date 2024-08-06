public class Main {
    public static void main(String[] args) {

        Estudante estudante = new Estudante(01, "Jorge", 19,"masculino","901283723");
        estudante.gravar(estudante);

        Professor professor = new Professor(02, "Professor",40,"Feminino","12389472");
        professor.gravar(professor);

        Livro livro = new Livro(01, "A volta dos que não foram", "desconhecido", "contos", "ifgoiano edits", 2024, 1, 200);
        livro.gravar(livro);

    }
}
