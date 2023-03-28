package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.GenreDTO;

public interface IGenreDAO extends IDAO<GenreDTO>{

    boolean exist(int id);

    void update(GenreDTO genreDTO);
}
