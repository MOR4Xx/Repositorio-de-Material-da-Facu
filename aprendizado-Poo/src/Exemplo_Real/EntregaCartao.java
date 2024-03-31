package Exemplo_Real;

import java.util.ArrayList;

public class EntregaCartao {
    public static void main(String[] args) {
        Endereco ende = new Endereco("Rua", "d3", "nada", "centro", "cidade", "Brasil");
        //Dados endereços
        Cliente client = new Cliente(01, "joaozin", "9843261", new ArrayList<>());
        //dados clliente
        if(client.enderecosList == null){
            client.enderecosList= new ArrayList<>();
        }

        client.enderecosList.add(ende);
        System.out.println("Verificação");
    }
}
