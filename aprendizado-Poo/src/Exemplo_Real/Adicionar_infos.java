package Exemplo_Real;

import java.util.ArrayList;

public class Adicionar_infos {
    public static void main(String[] args) {
        System.out.println("Digite as informações do CLiente");

        int id = Entradas.entradaInt("Digite a identificação do cliente: ");
        String nome = Entradas.entradaString("Digite o nome do Cliente: ");
        String cpf = Entradas.entradaString("Digite o cpf do cliente: ");

        System.out.println("---Endereços---");
        String endereco = Entradas.entradaString("Digite p endereço");
        String numEndereco = Entradas.entradaString("Numero: ");
        String complemento = Entradas.entradaString("Complemento: ");
        String bairro = Entradas.entradaString("Bairro: ");
        String cidade = Entradas.entradaString("Cidade: ");
        String pais = Entradas.entradaString("País: ");


        ArrayList<Endereco> enderecosList = new ArrayList<>();
        Endereco endereco1 = new Endereco(endereco, numEndereco, complemento, bairro, cidade, pais);
        enderecosList.add(endereco1);

        Cliente client = new Cliente(id, nome, cpf, enderecosList);

    }
}
