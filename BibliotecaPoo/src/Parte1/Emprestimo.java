package Parte1;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalTime horaEmprestimo;
    private Livro livro;
    private Usuario usuario;

    public Emprestimo(LocalDate dataEmprestimo, LocalTime horaEmprestimo, Livro livro, Usuario usuario) {
        this.dataEmprestimo = dataEmprestimo;
        this.horaEmprestimo = horaEmprestimo;
        this.livro = livro;
        this.usuario = usuario;
    }

    // Getters and Setters

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalTime getHoraEmprestimo() {
        return horaEmprestimo;
    }

    public void setHoraEmprestimo(LocalTime horaEmprestimo) {
        this.horaEmprestimo = horaEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void devolverLivro() {
        livro.setEmprestimo(false);
        System.out.println("Livro devolvido.");
    }
}
