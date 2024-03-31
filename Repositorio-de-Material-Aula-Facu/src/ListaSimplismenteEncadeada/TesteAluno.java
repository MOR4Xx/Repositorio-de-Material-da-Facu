//Aluno: Jorge Afonso Rabelo de Araujo
//Disciplina: Estrutura de Dados 1
//Data da ultima modificação: 18/03/2024
//Resumo da Classe: Essa classe contem os testes dos metodos de manipulação da lista.

package ListaSimplismenteEncadeada;

import java.util.Scanner;

public class TesteAluno {
    public static void main(String[] args) throws Exception {
        ListaAluno lista1 = new ListaAluno();
        Scanner sc = new Scanner(System.in);

        int menu = 0;
        do {
            System.out.println("--------------------------------");
            System.out.println("Menu");
            System.out.println("--------------------------------");
            System.out.println("1- Inserir Aluno");
            System.out.println("2- Remover Aluno(Matricula)");
            System.out.println("3- Buscar Aluno (Matricula)");
            System.out.println("4- Buscar Aluno(Nota)");
            System.out.println("5- Tamanho da Lista");
            System.out.println("6- Sair");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("\nDigite a matricula: ");
                    Integer matricula = sc.nextInt();
                    System.out.print("\nDigite a nota do aluno: ");
                    Double nota = sc.nextDouble();
                    lista1.inserirOrdem(new Aluno(matricula, nota));
                    break;
                case 2:
                    System.out.println("Digite a matricula do aluno que deseja remover: ");
                    Integer matricula_excluir = sc.nextInt();
                    lista1.retirar(matricula_excluir);
                    break;
                case 3:
                    System.out.print("\nDigite a matricula que deseja buscar: ");
                    Integer matricula_buscar = sc.nextInt();
                    lista1.buscaMatricula(matricula_buscar);
                    break;
                case 4:
                    System.out.print("\nDigite a nota que deseja buscar: ");
                    Double nota_buscar = sc.nextDouble();
                    lista1.buscaNota(nota_buscar);
                    break;
                case 5:
                    lista1.tamanhoLista();
                    break;
                case 6:
                    System.out.println("Finalizando programa");
                    return;
            }

        } while (menu != 6);
        sc.close();
    }

}
