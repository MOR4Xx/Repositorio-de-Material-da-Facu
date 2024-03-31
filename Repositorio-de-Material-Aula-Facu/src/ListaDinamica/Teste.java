package ListaDinamica;

public class Teste {
    public static void main(String[] args) {

        Lista list1 = new Lista();
        list1.inseriFinal(12);
        list1.inseriFinal(100);
        list1.inseriFinal(19000);
        list1.inseriFinal(15);
        list1.inseriFinal(159);
        list1.inseriFinal(548967);
        list1.inseriComeco(120);
        // list1.inseriFinal(11);

        list1.imprimirList();
        System.out.println();

        list1.duplicarLista();
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

