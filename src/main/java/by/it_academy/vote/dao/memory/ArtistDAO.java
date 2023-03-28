package by.it_academy.vote.dao.memory;

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
    private int idCounter = 1;

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
    public void create(ArtistDTO artistDTO) {
        ArtistDTO bufferedDTO = new ArtistDTO(createId(), artistDTO.getName());
        artists.put(bufferedDTO.getId(), bufferedDTO);
    }

    @Override
    public List<ArtistDTO> readAll() {
        return new ArrayList<>(artists.values());
    }

    @Override
    public void update(ArtistDTO artistDTO) {
        artists.put(artistDTO.getId(), artistDTO);
    }

    @Override
    public boolean delete(int id) {
        artists.remove(id);
        return true;
    }

    @Override
    public boolean exist(int id) {
        return artists.get(id) != null;
    }

    private int createId() {
        idCounter++;
        return idCounter;
    }
}
