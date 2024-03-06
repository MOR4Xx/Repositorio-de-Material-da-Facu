package AulasED1.ListaSimplesmenteEncadeada;


import AulasED1.ListaDinamica.Lista;

public class ListaAluno {
    public static class No{
        Aluno aluno;
        No prox = null;
    }

    private No primeiro;
    private No ultimo;

    public ListaAluno() {
        primeiro = new ListaAluno.No();
        ultimo = primeiro;
        primeiro.prox = null;
    }

    public void inserirOrdem(Aluno x) {
        No newNo = new No();
        newNo.aluno = x;

        //Confere
        if (primeiro.prox == null || primeiro.prox.aluno.getNota() < x.getNota()){
            newNo.prox = primeiro.prox;
            primeiro.prox = newNo;
        }else{
            No atual = primeiro.prox;

            while (atual.prox != null && atual.prox.aluno.getNota() > x.getNota()){
                atual = atual.prox;
            }
            newNo.prox = atual.prox;
            atual.prox = newNo;
            if (atual == ultimo){
                ultimo = newNo;
            }
        }

    }
    public void imprimirList() {
        ListaAluno.No atual = primeiro.prox;
        do {
            System.out.println(atual.aluno);
            atual = atual.prox;
        } while (atual != null);

    }
    public void tamanhoLista(){
        No atual = primeiro.prox;
    }

}
