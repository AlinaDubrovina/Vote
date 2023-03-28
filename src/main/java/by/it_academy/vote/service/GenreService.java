package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.service.api.IGenreService;

import java.util.List;

public class GenreService implements IGenreService {
    private final IGenreDAO genreDAO;


    public GenreService(IGenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    @Override
    public List<GenreDTO> getContent() {
        return genreDAO.readAll();
    }

    @Override
    public boolean exist(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("Genre title can't be empty");
        }
        return genreDAO.exist(id);
    }

    @Override
    public void create(GenreDTO genreDTO) {
        genreDAO.create(genreDTO);
    }

    @Override
    public void update(GenreDTO genreDTO) {
        genreDAO.update(genreDTO);
    }

    @Override
    public boolean delete(int id) {
        return genreDAO.delete(id);
    }

    public List<GenreDTO> getGenres() {
        return genreDAO.readAll();
    }
}
