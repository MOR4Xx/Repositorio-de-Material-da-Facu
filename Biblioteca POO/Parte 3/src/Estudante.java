
public class Estudante extends Usuario 
{
    private String curso;
    private int anoIngresso;

    public Estudante(int id, String nome, int idade, String sexo, String telefone, String curso, int anoIngresso) {
        super(id, nome, idade, sexo, telefone);
        this.curso = curso;
        this.anoIngresso = anoIngresso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAnoDeIngresso() {
        return anoIngresso;
    }

    public void setAnoDeIngresso(int anoIngresso) {
        this.anoIngresso = anoIngresso;
    }
}