package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.GenreDTO;

import java.util.List;

public interface IGenreService {
    List<GenreDTO> get();

    GenreDTO get(int id);

    boolean exist(int id);
}
