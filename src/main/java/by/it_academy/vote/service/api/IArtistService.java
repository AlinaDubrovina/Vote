package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.ArtistDTO;

import java.util.List;

public interface IArtistService {
    List<ArtistDTO> getContent();

    void create(ArtistDTO artistDTO);

    void update(ArtistDTO artistDTO);

    boolean delete(int id);

    boolean exist(int id);

    List<ArtistDTO> getArtists();
}
