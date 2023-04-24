package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDAO artistDAO;

    public ArtistService(IArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @Override
    public void create(ArtistDTO artistDTO) {
        ArtistEntity artistEntity = mapDTOtoEntity(artistDTO);
        artistDAO.create(artistEntity);
    }

    private ArtistEntity mapDTOtoEntity(ArtistDTO artistDTO){
        Long id = artistDTO.getId();
        String name = artistDTO.getName();
        return new ArtistEntity(id, name);
    }

    @Override
    public List<ArtistEntity> readAll() {
        return artistDAO.readAll();
    }

    @Override
    public void update(ArtistDTO artistDTO){
        ArtistEntity artist = mapDTOtoEntity(artistDTO);
        artistDAO.update(artist);
    }

    @Override
    public void delete(Long id) {
        artistDAO.delete(id);
    }
}
