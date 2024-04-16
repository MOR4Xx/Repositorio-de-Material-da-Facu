package AulasED1.Fila;

public class Fila {
    private static class No{
        No prox;
        Object item;
    }
    No primeiro;
    No ult;

    public boolean isEmpty(){
        return primeiro == null;
    }

    public void inserir(){
        No novo = new No();
        if (isEmpty()) {
            primeiro = novo;
            primeiro.prox = null;
            ult = novo;
        } else {
            ult.prox = novo;
            ult = novo;
            ult.prox = null;
        }
    }

    public Object remover(){
        if (isEmpty()) throw new RuntimeException("Vazio");

        Object item = primeiro.item;
        primeiro = primeiro.prox;

        if (isEmpty())
            ult = null;

        return item;
    }

    
}
