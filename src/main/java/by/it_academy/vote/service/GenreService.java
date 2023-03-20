package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.service.api.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {
    private final IGenreDAO dao;

    public GenreService(IGenreDAO dao) {
        this.dao = dao;
    }
    @Override
    public List<GenreDTO> get() {
        return dao.get();
    }

    @Override
    public boolean exist(int id) {
        List<GenreDTO> genreDTOS = this.dao.get();
        for (GenreDTO genreDTO : genreDTOS){
            if (id == genreDTO.getId()){
                return true;

            }
        }
        return false;
    }
}
