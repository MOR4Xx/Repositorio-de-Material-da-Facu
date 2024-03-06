package AulasPoo.Carro;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        carro.setCor("Preto");
        carro.setTipo("Sedan");
        carro.setPlaca("GGG-123");
        carro.setNumPorta(4);

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Arlinda");
        pessoa.setIdade(20);
        pessoa.setBiotipo("Magra");
        pessoa.setCorCabelo("Loira");
        pessoa.setCarro(carro);

        carro.setDono(pessoa);

        System.out.println("-----------Carro------------");
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Tipo: " + carro.getTipo());
        System.out.println("Placa: " + carro.getPlaca());
        System.out.println("Portas: " + carro.getNumPorta());
        System.out.println("Dono: " + carro.getDono().getNome());

        pessoa.ligarCarro();

        pessoa.setCarro(carro);

        pessoa.ligarCarro();
        pessoa.setCambio(1);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

        pessoa.setCambio(2);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

        pessoa.setCambio(3);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

        pessoa.setCambio(2);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

        pessoa.ligarCarro();
        pessoa.setCambio(1);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

        pessoa.ligarCarro();
        pessoa.setCambio(0);
        pessoa.getCarro().getCambio();
        pessoa.acelerarCarro();

        System.out.println();

    }
}
