package by.it_academy.vote.dao.memory;

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
    private int idCounter = 1;

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
    public boolean exist(int id) {
        return this.genres.get(id) != null;
    }

    @Override
    public void update(GenreDTO genreDTO) {
        genres.put(genreDTO.getId(), genreDTO);
    }

    @Override
    public void create(GenreDTO genreDTO) {
        GenreDTO bufferedDTO = new GenreDTO(createId(), genreDTO.getName());
        genres.put(bufferedDTO.getId(), bufferedDTO);
    }


    @Override
    public List<GenreDTO> readAll() {
        return new ArrayList<>(genres.values());
    }

    @Override
    public boolean delete(int id) {
        genres.remove(id);
        return true;
    }

    private int createId() {
        idCounter++;
        return idCounter;
    }
}

