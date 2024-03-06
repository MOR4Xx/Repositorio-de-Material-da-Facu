package AulasED1.ListaDinamica;

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
        No atual = primeiro.prox;
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

    // Exercicio 03
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

    // Exercicio 6
    public void trocarDoisElementos(Object no1, Object no2) {
        No aux1 = null, aux2 = null;
        No atual = primeiro;

        while (atual.prox != null) {
            if (atual.prox.item.equals(no1))
                aux1 = atual;
            if (atual.prox.item.equals(no2))
                aux2 = atual;

            atual = atual.prox;
        }

        if (no1 != null && no2 != null) {
            No temp = aux1.prox;
            aux1 = aux2.prox;
            aux2 = temp;
            System.out.println("Troca Bem sucedida!!");
        }
    }

    // Exercicio 7
    public void listaPar(Lista list1) {
        No atual = list1.primeiro.prox;
        Lista list2 = new Lista();

        while (atual != null) {
            if ((Integer) atual.item % 2 == 0) {
                list2.inseriFinal(atual.item);
            }
            atual = atual.prox;
        }
        list2.imprimirList();
    }

    // Exercicio 9
    public void ordemLista() {
        No atual = primeiro.prox;
        boolean crescente = false, decrescente = false;
        while (atual.prox != null) {
            if (atual.prox != null && ((Integer) atual.item < (Integer) atual.prox.item)) {
                decrescente = false;
                break;
            } else
                decrescente = true;

            atual = atual.prox;
        }
        while (atual.prox != null) {
            if (atual.prox != null && ((Integer) atual.item > (Integer) atual.prox.item)) {
                crescente = false;
                break;
            } else
                crescente = true;
            atual = atual.prox;
        }
        if (decrescente || crescente)
            System.out.println("Lista está ordenada.");
        else
            System.out.println("Não é ordenada");
    }

    // Exercicio 19
    
    // Exercicio 31
    public void somaLista() {
        No atual = primeiro.prox;
        Integer soma = 0;

        while (atual != null) {
            soma += (Integer) atual.item;
            atual = atual.prox;
        }
        System.out.println("A soma é: " + soma);
    }
}