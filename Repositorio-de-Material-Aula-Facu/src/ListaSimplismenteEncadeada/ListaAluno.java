//Aluno: Jorge Afonso Rabelo de Araujo
//Disciplina: Estrutura de Dados 1
//Data da ultima modificação: 18/03/2024
//Resumo da Classe: Essa classe contem os metodoro requeridos no trabalho, tais como Adicionar uma aluno na lista por ordem de nota,
//retirar aluno da lista atravez da matricula, busca usando nota e matricula e um metodo de contagem do tamanho da lista.

package ListaSimplismenteEncadeada;

public class ListaAluno {
    public static class No {
        Aluno aluno;
        No prox = null;
    }

    private No primeiro;
    private No ultimo;

    public boolean vazia() {
        return primeiro == null;
    }

    public ListaAluno() {
        primeiro = new No();
        ultimo = primeiro;
        primeiro.prox = null;
    }

    public void inserirOrdem(Aluno x) {
        No newNo = new No();
        newNo.aluno = x;

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
        No atual = primeiro.prox;
        
        while (atual != null){
            System.out.println(atual.aluno);
            atual = atual.prox;
        }
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

    public void retirar(Object matricula) throws Exception {
        if (vazia())
            throw new Exception("Erro : Lista vazia");

        No atual = primeiro;

        while (atual.prox != null && !atual.prox.aluno.getMatricula().equals(matricula))
            atual = atual.prox;

        if (atual.prox == null)
            System.out.println("Maticula não encontrada!!");

        No q = atual.prox;
        atual.prox = q.prox;

        if (atual.prox == null)
            ultimo = atual;

        System.out.println("Aluno " + matricula + " removido da lista!");
        System.out.println();
    }

    public void buscaNota(Double nota) {
        No atual = primeiro.prox;
        ListaAluno listaNota = new ListaAluno();

        while (atual != null) {
            if (atual.aluno.getNota().equals(nota)) {
                listaNota.inserirOrdem(atual.aluno);
            }
            atual = atual.prox;
        }

        listaNota.imprimirList();
    }

    public void buscaMatricula(Integer matricula) throws Exception {
        No atual = primeiro.prox;
        while (atual.prox != null && atual.aluno.getMatricula() != matricula)
            atual = atual.prox;

        if (atual == null) {
            System.out.println("Matricula não encontrada");
            return;
        }

        Aluno aluno_buscado = atual.aluno;
        System.out.println("Matrícula: " + aluno_buscado.getMatricula());
        System.out.println("Nota: " + aluno_buscado.getNota());
        System.out.println("\n");
    }
}
