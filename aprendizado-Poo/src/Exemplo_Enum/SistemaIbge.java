package Exemplo_Enum;

// qualquer classe do sistema poderá obter os objetos de EstadoBrasileiro
public class SistemaIbge {
    public static void main(String[] args) {
        //imprimindo os estados existentes no enum
        for(EstadoBrasileiro i: EstadoBrasileiro.values() ) {
            System.out.println(i.getSigla() + "-" + i.getNomeMaiusculo());
        }

        //selecionando um estado a partir das opções disponíveis
        EstadoBrasileiro ufSelecionado = EstadoBrasileiro.PIAUI;

        System.out.println("O estado selecionado foi: " + ufSelecionado.getNome());
    }
}
