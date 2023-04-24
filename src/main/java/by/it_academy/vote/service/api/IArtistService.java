package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.core.entity.ArtistEntity;

import java.util.List;

public interface IArtistService extends IService<ArtistDTO> {
    List<ArtistEntity> readAll();
}
