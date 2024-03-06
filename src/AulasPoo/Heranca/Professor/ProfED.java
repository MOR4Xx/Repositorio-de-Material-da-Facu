package AulasPoo.Heranca.Professor;

public class ProfED extends Professor {
    private double salario;

    public ProfED(String nome, int matricula, double salario) {
        super(nome, matricula, 40);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Professor dedicação exclusiva: " + super.toString() +
                "salario:" + salario;
    }
}
