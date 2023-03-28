package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.GenreDTO;

import java.util.List;

public interface IGenreService {
    List<GenreDTO> getContent();
    boolean exist(int id);

    List<GenreDTO> getGenres();

    void create(GenreDTO genreDTO);

    void update(GenreDTO genreDTO);

    boolean delete(int id);
}
