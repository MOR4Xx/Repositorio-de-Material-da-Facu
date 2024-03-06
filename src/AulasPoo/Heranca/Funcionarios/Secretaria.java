package AulasPoo.Heranca.Funcionarios;

public class Secretaria extends Funcionario {
    private String ramal;

    Secretaria(String nome, double salario, String ramal) {
        super(nome, salario);
        this.ramal = ramal;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "ramal=" + ramal + ' ' +
                super.toString() + '}';
    }
}
