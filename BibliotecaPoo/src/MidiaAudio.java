public class MidiaAudio extends Obra {
    private String tipo_audio;
    private String tamanho;

    public MidiaAudio(String titulo, String autor, String tipo_audio, String tamanho) {
        super(titulo, autor);
        this.tipo_audio = tipo_audio;
        this.tamanho = tamanho;
    }

    public void escutar() {
        System.err.println("Escutando...");
    }

    public String getTipo_audio() {
        return tipo_audio;
    }

    public void setTipo_audio(String tipo_audio) {
        this.tipo_audio = tipo_audio;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}
