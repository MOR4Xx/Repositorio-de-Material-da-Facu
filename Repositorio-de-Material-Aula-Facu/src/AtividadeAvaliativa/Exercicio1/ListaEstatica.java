package AulasED1.AtividadeAvaliativa.Exercicio1;

public class ListaEstatica {
    private int tamLista;
    private int ult;
    private int primeiro;
    private int[] lista = new int[tamLista];

    public ListaEstatica(int tamLista) {
        this.tamLista = tamLista;
        this.ult = 0;
        this.primeiro = 0;
        this.lista = new int[tamLista];
    }
    //Questão 1
    public void inverter(ListaEstatica lista){
        int aux = 0;
        for (int i = primeiro;  i<ult; i++){
            aux = lista.getLista()[i];
            lista.getLista()[i]= lista.getLista()[ult-1-i];
            lista.getLista()[ult-i-1] = aux;
        }
    }

    //Questão 2
     public void interseccao(ListaEstatica lista1, ListaEstatica lista2){
        ListaEstatica lista3 = new ListaEstatica(lista1.getTamLista());
        int aux = 0;
        for(int i=0; i<lista1.getUlt()-1; i++){
            for (int j=0; j< lista2.getUlt()-1; j++){
                if (lista1.getLista()[i] == lista2.getLista()[j] ){
                    lista3.getLista()[aux] = lista1.getLista()[i];
                    aux++;
                    lista3.setUlt(aux+1);
                }
            }
        }

     }
    public int getTamLista() {
        return tamLista;
    }

    public void setTamLista(int tamLista) {
        this.tamLista = tamLista;
    }

    public int getUlt() {
        return ult;
    }

    public void setUlt(int ult) {
        this.ult = ult;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(int primeiro) {
        this.primeiro = primeiro;
    }

    public int[] getLista() {
        return lista;
    }

    public void setLista(int[] lista) {
        this.lista = lista;
    }
}
