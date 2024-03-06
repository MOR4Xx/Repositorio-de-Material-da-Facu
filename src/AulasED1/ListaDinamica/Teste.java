package AulasED1.ListaDinamica;

import AulasED1.ListaDinamica.Lista;

public class Teste {
    public static void main(String[] args) {

        Lista list1 = new Lista();
        list1.inseriFinal(1);
        list1.inseriFinal(3);
        list1.inseriFinal(5);
        list1.inseriFinal(6);
        list1.inseriFinal(10);
        list1.inseriFinal(12);
        //list1.inseriFinal(11);

        list1.imprimirList();
        System.out.println();

        list1.ordemLista();
        //list1.somaLista();
        // list1.listaPar(list1);


        // Lisa list2 = new Lista();
        // list2.inseriFinal(18);
        // list2.inseriFinal(10);
        // list2.inseriFinal(19);
        // list2.inseriFinal(110);

        // Lista list3 = new Lista();
        // list3.concatenarListas(list1, list2);

        // Integer A = 12, B = 100;

        // list1.trocarDoisElementos(A, B);
    }
}

