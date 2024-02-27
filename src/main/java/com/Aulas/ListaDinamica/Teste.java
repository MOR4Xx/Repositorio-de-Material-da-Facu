package AulasED1.Exercicio7;

public class Teste {
    public static void main(String[] args) {

        Lista list1 = new Lista();
        list1.inseriFinal(12);
        list1.inseriFinal(100);
        list1.inseriFinal(19000);
        list1.inseriFinal(15);

        Lista list2 = new Lista();
        list2.inseriFinal(18);
        list2.inseriFinal(10);
        list2.inseriFinal(19);
        list2.inseriFinal(110);

        Lista list3 = new Lista();
        list3.concatenarListas(list1, list2);
    }
}

