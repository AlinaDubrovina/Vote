package by.it_academy.vote.dao;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.dao.api.IGenreDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenreDAO implements IGenreDAO {
    private Map<Integer, GenreDTO> genres = new HashMap<>();

    public GenreDAO(Map<Integer, GenreDTO> genres) {
        this.genres = genres;
    }

    public GenreDAO() {
        this.genres.put(1, new GenreDTO(1, "Rock"));
        this.genres.put(2, new GenreDTO(2, "Classical music"));
        this.genres.put(3, new GenreDTO(3, "Rap"));
        this.genres.put(4, new GenreDTO(4, "R&B"));
        this.genres.put(5, new GenreDTO(5, "POP"));
        this.genres.put(6, new GenreDTO(6, "KPOP"));
        this.genres.put(7, new GenreDTO(7, "Jazz"));
    }

    @Override
    public GenreDTO get(int id) {
        return this.genres.get(id);
    }

    @Override
    public List<GenreDTO> get() {
        return new ArrayList<>(genres.values());
    }

    @Override
    public boolean exist(int id) {
        return this.genres.get(id) != null;
    }
}

