package AulasED1.ListaDuplamenteEncadeadaCircular;

public class ListaDuoCircular {
    private No head;
    public boolean isEmpty(){
        return head == null;
    }

    public void inserirLista(){
        No newNo = new No();
        if (isEmpty()){
            newNo.setAnt(newNo);
            newNo.setProx(newNo);
            this.head = newNo;
        }else{
            No aux = head.getAnt();
            newNo.setAnt(aux);
            newNo.setProx(head);
            aux.setProx(newNo);
            head.setAnt(newNo);

        }
    }

}
