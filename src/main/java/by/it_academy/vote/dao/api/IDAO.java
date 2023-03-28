package by.it_academy.vote.dao.api;

import java.util.List;

public interface IDAO<T > {
    void create(T t);

    List<T> readAll();

    boolean delete(int id);
}
