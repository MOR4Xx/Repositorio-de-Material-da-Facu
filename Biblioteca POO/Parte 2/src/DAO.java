public interface DAO<T> {

    void gravar(T t);
    void excluir();
    T ler(int ID);
    void atualizar();

}
