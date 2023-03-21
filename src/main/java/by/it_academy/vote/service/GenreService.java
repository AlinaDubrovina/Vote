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
    public GenreDTO get(int id) {
        return this.dao.get(id);
    }

    @Override
    public List<GenreDTO> get() {
        return dao.get();
    }

    @Override
    public boolean exist(int id) {
        return this.dao.exist(id);
    }
}
