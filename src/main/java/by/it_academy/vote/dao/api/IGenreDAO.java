package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.entity.GenreEntity;

public interface IGenreDAO extends IDAO<GenreEntity>{
    GenreDTO get(Long id);
}
