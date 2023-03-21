package by.it_academy.vote.dao;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.dao.api.IArtistDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArtistDAO implements IArtistDAO {
    private Map<Integer, ArtistDTO> artists = new HashMap<>();

    public ArtistDAO(Map<Integer, ArtistDTO> artists) {
        this.artists = artists;
    }

    public ArtistDAO() {
        this.artists.put(1, new ArtistDTO(1, "Selena Gomez"));
        this.artists.put(2, new ArtistDTO(2, "Metallica"));
        this.artists.put(3, new ArtistDTO(3, "Nirvana"));
        this.artists.put(4, new ArtistDTO(4, "Michael Jackson"));
        this.artists.put(5, new ArtistDTO(5, "James Brown"));
        this.artists.put(6, new ArtistDTO(6, "Wolfgang Amadeus Mozart"));
        this.artists.put(7, new ArtistDTO(7, "Jay-Z"));
        this.artists.put(8, new ArtistDTO(8, "50 Cent"));
    }

    @Override
    public ArtistDTO get(int id) {
        return this.artists.get(id);
    }

    @Override
    public List<ArtistDTO> get() {
        return new ArrayList<>(artists.values());
    }

    @Override
    public boolean exist(int id) {
        return this.artists.get(id) != null;
    }
}