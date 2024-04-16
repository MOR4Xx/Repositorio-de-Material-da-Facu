package AulasED1.AtividadeAvaliativa.Exercicio1;

import AulasED1.ListaDinamica.Lista;

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

        public boolean iguais(ListaEncadeada lista1, ListaEncadeada lista2){
            No atual = lista1.primeiro.prox;
            No atual2 = lista2.primeiro.prox;
//            while (atual.prox != null && atua2.){
//
//            }
            return true;
        }

}
