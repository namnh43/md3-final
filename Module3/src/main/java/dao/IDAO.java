package dao;

import java.util.List;

public interface IDAO<T> {
    public void insert(T element);
    public T selectItem(int id);
    public List<T> selectAll();
    public boolean delete(int id);
    public boolean update(T element);
}
