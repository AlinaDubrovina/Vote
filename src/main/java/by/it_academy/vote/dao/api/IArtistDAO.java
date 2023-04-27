package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.core.entity.ArtistEntity;

public interface IArtistDAO extends IDAO<ArtistEntity>{
    ArtistDTO get(Long id);
}
