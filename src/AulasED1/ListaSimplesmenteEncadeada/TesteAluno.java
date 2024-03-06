package AulasED1.ListaSimplesmenteEncadeada;

public class TesteAluno {
    public static void main(String[] args) {
        ListaAluno lista1 = new ListaAluno();
        lista1.inserirOrdem(new Aluno(1001, 10.0));
        lista1.inserirOrdem(new Aluno(1002, 7.0));
        lista1.inserirOrdem(new Aluno(1003, 8.0));
        lista1.inserirOrdem(new Aluno(1004, 5.0));
        lista1.inserirOrdem(new Aluno(1005, 9.0));
        lista1.inserirOrdem(new Aluno(1006, 3.0));

        lista1.imprimirList();

    }

}
