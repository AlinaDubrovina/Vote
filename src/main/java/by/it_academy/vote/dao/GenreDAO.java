package by.it_academy.vote.dao;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.dao.api.IGenreDAO;

import java.util.ArrayList;
import java.util.List;

public class GenreDAO implements IGenreDAO {
    private List<GenreDTO> genres = new ArrayList<>();

    public GenreDAO(List<GenreDTO> genres) {
        this.genres = genres;
    }

    public GenreDAO() {
        this.genres.add(new GenreDTO("Rock"));
        this.genres.add(new GenreDTO("Classical music"));
        this.genres.add(new GenreDTO("Rap"));
        this.genres.add(new GenreDTO("R&B"));
        this.genres.add(new GenreDTO("POP"));
        this.genres.add(new GenreDTO("KPOP"));
        this.genres.add(new GenreDTO("Jazz"));
    }

    @Override
    public List<GenreDTO> get() {
        return genres;
    }

    @Override
    public boolean exist(String name) {
        List<GenreDTO> genreDTOS = get();
        for (GenreDTO genreDTO : genreDTOS){
            if (name.equals(genreDTO.getName())){
                return true;
            }
        }
        return false;
    }
}

