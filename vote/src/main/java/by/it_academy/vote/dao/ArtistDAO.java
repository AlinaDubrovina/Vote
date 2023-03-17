package by.it_academy.vote.dao;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.dao.api.IArtistDAO;

import java.util.ArrayList;
import java.util.List;

public class ArtistDAO implements IArtistDAO {
    private List<ArtistDTO> artists = new ArrayList<>();

    public ArtistDAO(List<ArtistDTO> artists) {
        this.artists = artists;
    }

    public ArtistDAO() {
        this.artists.add(new ArtistDTO("Selena Gomez"));
        this.artists.add(new ArtistDTO("Metallica"));
        this.artists.add(new ArtistDTO("Nirvana"));
        this.artists.add(new ArtistDTO("Michael Jackson"));
        this.artists.add(new ArtistDTO("James Brown"));
        this.artists.add(new ArtistDTO("Wolfgang Amadeus Mozart"));
        this.artists.add(new ArtistDTO("Jay-Z"));
        this.artists.add(new ArtistDTO("50 Cent"));
    }

    @Override
    public List<ArtistDTO> get() {
        return artists;
    }

    @Override
    public boolean exist(String name) {
        List<ArtistDTO> artistDTOS = get();
        for (ArtistDTO artistDTO : artistDTOS){
            if (name.equals(artistDTO.getName())){
                return true;
            }
        }
        return false;
    }
}