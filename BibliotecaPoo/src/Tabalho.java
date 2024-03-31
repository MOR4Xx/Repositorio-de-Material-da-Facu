public class Tabalho {
    private long id;
    private String tituloTrabalho;
    private String dadeConclusao;
    private Aluno aluno;
    private Orientador orientador;
    private Curso curso;
    private String localCUrso;
    private String localArquivo;
    private int score;
    private int qantVotos;

    public Tabalho(long id, String tituloTrabalho, String dadeConclusao, Aluno aluno, Orientador orientador, Curso curso, String localCUrso, String localArquivo, int score, int qantVotos) {
        this.id = id;
        this.tituloTrabalho = tituloTrabalho;
        this.dadeConclusao = dadeConclusao;
        this.aluno = aluno;
        this.orientador = orientador;
        this.curso = curso;
        this.localCUrso = localCUrso;
        this.localArquivo = localArquivo;
        this.score = score;
        this.qantVotos = qantVotos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTituloTrabalho() {
        return tituloTrabalho;
    }

    public void setTituloTrabalho(String tituloTrabalho) {
        this.tituloTrabalho = tituloTrabalho;
    }

    public String getDadeConclusao() {
        return dadeConclusao;
    }

    public void setDadeConclusao(String dadeConclusao) {
        this.dadeConclusao = dadeConclusao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getLocalCUrso() {
        return localCUrso;
    }

    public void setLocalCUrso(String localCUrso) {
        this.localCUrso = localCUrso;
    }

    public String getLocalArquivo() {
        return localArquivo;
    }

    public void setLocalArquivo(String localArquivo) {
        this.localArquivo = localArquivo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQantVotos() {
        return qantVotos;
    }

    public void setQantVotos(int qantVotos) {
        this.qantVotos = qantVotos;
    }
}
