package AulasPoo.Heranca.Funcionarios;

public class Teste {
    public static void main(String[] args) {

        Secretaria secretaria = new Secretaria("Josi", 1890, "90");
        System.out.println("Nome Secretaria: " + secretaria.getNome());
        System.out.println("Salario Secretaria: " + secretaria.getSalario());
        System.out.println("Ramal: "+ secretaria.getRamal());
        System.out.println(secretaria.toString());

        Gerente gerente = new Gerente("Junin racha cuca", 9000, 1);
        System.out.println("Nome gerente: "+gerente.getNome());
        System.out.println("Salario gerente: "+ gerente.getSalario());
        System.out.println("Sala Gerente: "+ gerente.getSala());
        System.out.println(gerente.toString());
    }
}
