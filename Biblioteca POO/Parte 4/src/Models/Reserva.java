package Models;
import java.time.LocalDate;

public class Reserva {
    private int id;
    private int idUsuario;
    private int idObra;
    private String dataReserva;

    public Reserva(int id, int idUsuario, int idObra, String dataReserva) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idObra = idObra;
        this.dataReserva = dataReserva;
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

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
}