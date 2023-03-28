package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.ArtistDTO;

import java.util.List;

public interface IArtistDAO extends IDAO<ArtistDTO>{
    boolean exist(int id);

    void update(ArtistDTO artistDTO);
}
