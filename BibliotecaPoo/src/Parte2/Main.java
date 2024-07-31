package Parte2;

public class Main {
    public static void main(String[] args) {

        Professor prof = new Professor(01,"jorgin", "jorge123", "Jorge Afonso", "Homi", "64996549827",
            19, "Programação", "POO");
        System.out.println(prof.toString());

        Livro livro1 =new Livro("A historia do que não foi", "JORGExBALA", "História", "ESC", 2024,
                1, 200);
        prof.gravar(livro1);

        
    }
}
