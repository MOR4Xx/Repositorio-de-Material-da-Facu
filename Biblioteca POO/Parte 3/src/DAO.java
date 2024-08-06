import java.io.IOException;

public interface DAO<T> {
    void salvar(T t);
    void excluir(int id) throws IOException;
    T ler(int id) throws IOException;
    void atualizar(T t) throws IOException;
}
