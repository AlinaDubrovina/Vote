package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDAO artistDAO;


    public ArtistService(IArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @Override
    public List<ArtistDTO> getContent() {
        return artistDAO.readAll();
    }

    @Override
    public void create(ArtistDTO artistDTO) {
        artistDAO.create(artistDTO);
    }

    @Override
    public void update(ArtistDTO artistDTO){
        artistDAO.update(artistDTO);
    }


    @Override
    public boolean delete(int id) {
        return artistDAO.delete(id);
    }

    public boolean exist(int id) {
        if (id == 0) {
            throw new IllegalArgumentException("Performer nickname can't be empty");
        }
        return artistDAO.exist(id);
    }

    public List<ArtistDTO> getArtists() {
        return artistDAO.readAll();
    }
}
