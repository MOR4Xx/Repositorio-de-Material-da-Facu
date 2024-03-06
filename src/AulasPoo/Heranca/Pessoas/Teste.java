package AulasPoo.Heranca.Pessoas;

public class Teste {
    public static void main (String args) {
        Funcionario funcionario = new Funcionario();
        funcionario. setNome ("Lucas");
        funcionario.setRg ("25.654. 678-");
        funcionario.setCartao("RH893");

        System.out.println (funcionario.getNome());
        System.out.println (funcionario.getRg());
        System.out.println (funcionario.getCartao());
    }
}
