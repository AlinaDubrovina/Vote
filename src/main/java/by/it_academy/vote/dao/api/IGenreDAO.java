package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.GenreDTO;

import java.util.List;

public interface IGenreDAO {
    List<GenreDTO> get();
    boolean exist(int id);
}
