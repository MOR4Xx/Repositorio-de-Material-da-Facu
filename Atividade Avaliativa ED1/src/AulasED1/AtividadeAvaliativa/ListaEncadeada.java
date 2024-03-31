package AulasED1.AtividadeAvaliativa;


public class ListaEncadeada {
        private static class No {
            Object item;
            No prox;
        }

        private No primeiro;
        private No ultimo;

        public ListaEncadeada() {
            primeiro = new No();
            ultimo = primeiro;
            primeiro.prox = null;
        }

        //Exercicio 4
        public boolean listarIguais(ListaEncadeada lista1, ListaEncadeada lista2){
            No atual = lista1.primeiro.prox;
            No atual2 = lista2.primeiro.prox;
            while (atual != null && atual2 != null){
                if (atual.item != atual2.item) {
                    return false;
                }
                atual = atual.prox;
                atual2 = atual2.prox;
            }

            if (atual !=null ||atual2 != null)
                return false;

            return true;
        }

}
