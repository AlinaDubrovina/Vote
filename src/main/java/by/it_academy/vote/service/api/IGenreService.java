package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.entity.GenreEntity;

import java.util.List;

public interface IGenreService extends IService<GenreDTO>{
    List<GenreEntity> readAll();
}
