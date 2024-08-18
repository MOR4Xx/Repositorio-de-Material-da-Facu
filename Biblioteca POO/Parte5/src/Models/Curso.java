package Models;

public class Curso {
    private String areaConhecimento;
    private String tituloCurso;
    private int codCurso;

    public Curso(int codCurso, String tituloCurso,String areaConhecimento ) {
        this.areaConhecimento = areaConhecimento;
        this.tituloCurso = tituloCurso;
        this.codCurso = codCurso;
    }

    public String getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
}
