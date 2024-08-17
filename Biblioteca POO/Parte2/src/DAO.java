public interface DAO<T> {

    void gravar(T t);
    String excluir(int id);
    T ler(int iD);
    void atualizar();

}
