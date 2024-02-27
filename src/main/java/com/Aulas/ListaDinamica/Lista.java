package AulasED1.Exercicio7;

public class Lista {
    private static class No {
        Object item;
        No prox;
    }

    private No primeiro;
    private No ultimo;

    public Lista() {
        primeiro = new No();
        ultimo = primeiro;
        primeiro.prox = null;
    }

    public void imprimirList() {
        No atual = primeiro;
        do {
            System.out.println(atual.item);
            atual = atual.prox;
        } while (atual != null);

    }

    public void inseriFinal(Object x) {

        ultimo.prox = new No();
        ultimo = ultimo.prox;
        ultimo.item = x;
        ultimo.prox = null;
    }


    //Exercicio 03
    public void concatenarListas(Lista lista1, Lista lista2) {
        No atual = lista1.primeiro;
        Lista list3 = new Lista();

        while (atual != null) {
            list3.inseriFinal(atual.item);
            atual = atual.prox;
        }

        atual = lista2.primeiro.prox;
        while (atual != null) {
            list3.inseriFinal(atual.item);
            atual = atual.prox;
        }

        list3.imprimirList();
    }

    
}
