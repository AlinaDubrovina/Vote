package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.entity.GenreEntity;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.service.api.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {
    private final IGenreDAO genreDAO;

    public GenreService(IGenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    public void create(GenreDTO genreDTO) {
        GenreEntity genre = mapDTOtoEntity(genreDTO);
        genreDAO.create(genre);
    }

    private GenreEntity mapDTOtoEntity(GenreDTO genreDTO){
        Long id = genreDTO.getId();
        String name = genreDTO.getName();
        return new GenreEntity(id, name);
    }

    @Override
    public List<GenreEntity> readAll() {
        return genreDAO.readAll();
    }

    @Override
    public void update(GenreDTO genreDTO){
        GenreEntity genre = mapDTOtoEntity(genreDTO);
        genreDAO.update(genre);
    }

    @Override
    public void delete(Long id) {;
        genreDAO.delete(id);
    }
}