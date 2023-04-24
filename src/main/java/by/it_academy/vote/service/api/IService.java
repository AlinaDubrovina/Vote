package by.it_academy.vote.service.api;

import java.util.List;

public interface IService <T > {
    void create(T t);
    void delete(Long id);
    void update(T t);
}