public class Curso {
    private AreaConhecimento areaConhecimento;
    private String tituloCurso;
    private long codCurso;

    public Curso(AreaConhecimento areaConhecimento, String tituloCurso, long codCurso) {
        this.areaConhecimento = areaConhecimento;
        this.tituloCurso = tituloCurso;
        this.codCurso = codCurso;
    }

    public AreaConhecimento getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(AreaConhecimento areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public String getTituloCurso() {
        return tituloCurso;
    }

    public void setTituloCurso(String tituloCurso) {
        this.tituloCurso = tituloCurso;
    }

    public long getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(long codCurso) {
        this.codCurso = codCurso;
    }
}
