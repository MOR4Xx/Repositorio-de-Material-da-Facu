package AulasPoo.Heranca.Funcionarios;

public class Gerente extends Funcionario {
    private int sala;

    Gerente(String nome, double salario, int sala) {
        super(nome, salario);
        this.setSala(sala);
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "sala=" + sala + ' ' +
                super.toString() + '}';
    }
}
