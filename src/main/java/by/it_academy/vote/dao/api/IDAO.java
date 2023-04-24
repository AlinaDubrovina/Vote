package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.entity.ArtistEntity;

import java.util.List;

public interface IDAO<T > {
    void create(T t);

    List<T> readAll();

    void delete(Long id);
    void update(T t);
}
