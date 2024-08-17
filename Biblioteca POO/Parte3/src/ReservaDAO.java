import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO implements DAO<Reserva> {
    private static final String BASE_PATH = "Biblioteca POO/Parte 3/Reservas/";

    @Override
    public void salvar(Reserva reserva) {
        try {
            File filenew = new File(BASE_PATH + reserva.getId() + ".txt");


            FileOutputStream file = new FileOutputStream(filenew);
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(reserva);
            stream.flush();
            stream.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String excluir(int id) {
        File file = new File(BASE_PATH + id+".txt");
        if (file.exists()) {
            if (file.delete()) {
                return "Reserva excluída com sucesso!";
            } else {
                return "Falha ao excluir a reserva.";
            }
        } else {
            return "Reserva não encontrada.";
        }
    }

    @Override
    public void atualizar(Reserva reserva) {
        excluir(reserva.getId());
        salvar(reserva);
    }

    @Override
    public Reserva ler(int id) {
        try {
            FileInputStream file = new FileInputStream(BASE_PATH + id+".txt");
            ObjectInputStream stream = new ObjectInputStream(file);
            Reserva reserva = (Reserva) stream.readObject();
            stream.close();
            file.close();
            return reserva;
        } catch (Exception e) {
            System.out.println("Falha na leitura\n " + e.toString());
            return null;
        }
    }

    public List<Reserva> listar() {
        List<Reserva> reservas = new ArrayList<>();
        File dir = new File("Biblioteca POO/Parte 3/Reservas/");
        File[] files = dir.listFiles((dir1, name) -> name.startsWith("reserva"));

        if (files != null) {
            for (File file : files) {
                try {
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Reserva reserva = (Reserva) ois.readObject();
                    reservas.add(reserva);
                    ois.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return reservas;
    }
}