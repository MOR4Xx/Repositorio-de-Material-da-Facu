package AulasED1.ListaSimplesmenteEncadeada;

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

        //Confere se a lista está vazia ou verifica se o primeiro.prox é menor que a nota instanciada
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
        int cont = 0;

        while(atual != null){
            cont ++;
            atual = atual.prox;
        }
        System.out.println("Tamanho da Lista é: "+cont);
    }

    public Aluno retira (int matricula) throws Exception {
        
        No atual = primeiro;
        while (atual.prox!=null && !atual.prox.aluno.getMatricula().equals(matricula) )
            atual = atual.prox;

        if (atual.prox == null)
            throw new Exception("Matrícula não encontrada"); // Throw an exception if matricula is not found
    
        // pego a célula encontrada
        No q = atual.prox;

        // removo a célula da lista
        atual.prox = q.prox;
        if (atual.prox == null) // atualiza o último, se necessário
            ultimo = atual;

        return q.aluno;
        }

}
