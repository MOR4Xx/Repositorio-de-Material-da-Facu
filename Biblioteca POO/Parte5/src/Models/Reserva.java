package Models;
import java.time.LocalDate;

public class Reserva {
    private int id;
    private int idUsuario;
    private int idObra;
    private LocalDate dataReserva;

    public Reserva(int id, int idUsuario, int idObra, LocalDate dataReserva) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idObra = idObra;
        this.dataReserva = dataReserva;
    }

    public Reserva() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }


    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }
}