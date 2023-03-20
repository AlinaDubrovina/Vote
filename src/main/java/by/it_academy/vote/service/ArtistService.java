package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.service.api.IArtistService;

import java.util.List;

public class ArtistService implements IArtistService {
    private final IArtistDAO dao;

    public ArtistService(IArtistDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ArtistDTO> get() {
        return dao.get();
    }

    @Override
    public boolean exist(int id) {
        List<ArtistDTO> artistDTOS = this.dao.get();
        for (ArtistDTO artistDTO : artistDTOS){
            if (id == artistDTO.getId()){
                return true;

            }
        }
        return false;
    }
}
