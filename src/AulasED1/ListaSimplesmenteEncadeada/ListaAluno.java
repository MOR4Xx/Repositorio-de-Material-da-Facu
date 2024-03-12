package AulasED1.ListaSimplesmenteEncadeada;

public class ListaAluno {
    public static class No {
        Aluno aluno;
        No prox = null;
    }

    private No primeiro;
    private No ultimo;

    public boolean vazia(){
        if (primeiro==ultimo){
            return false;
        }
        return true;
    }
    public ListaAluno() {
        primeiro = new ListaAluno.No();
        ultimo = primeiro;
        primeiro.prox = null;
    }

    public void inserirOrdem(Aluno x) {
        No newNo = new No();
        newNo.aluno = x;

        //Confere se a lista está vazia ou verifica se o primeiro.prox é menor que a nota instanciada
        if (primeiro.prox == null || primeiro.prox.aluno.getNota() < x.getNota()) {
            newNo.prox = primeiro.prox;
            primeiro.prox = newNo;
        } else {
            No atual = primeiro.prox;

            while (atual.prox != null && atual.prox.aluno.getNota() > x.getNota()) {
                atual = atual.prox;
            }
            newNo.prox = atual.prox;
            atual.prox = newNo;
            if (atual == ultimo) {
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
        System.out.println();
    }

    public void tamanhoLista() {
        No atual = primeiro.prox;
        int cont = 0;

        while (atual != null) {
            cont++;
            atual = atual.prox;
        }

        System.out.println("Tamanho da Lista é: " + cont);
        System.out.println();
    }

    public void retirar (Object matricula) throws Exception {
        if ( vazia() )
            throw new Exception("Erro : Lista vazia");
        No atual = primeiro;
        while (atual.prox!=null && !atual.prox.aluno.getMatricula().equals(matricula) )
            atual = atual.prox;
        if (atual.prox == null )
            System.out.println("Maticula não encontrada!!"); // não encontrada
        // pego o No encontrada
        No q = atual.prox;
        // guardo o item encontrado
        Aluno item = q.aluno;
        // removo a celula da lista
        atual.prox = q.prox;
        if (atual.prox == null ) // atualiza o ultimo, se necessario
            ultimo = atual;
        System.out.println("Aluno "+matricula+" removido da lista!");
        System.out.println();
    }
}

