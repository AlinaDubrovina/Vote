package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.ArtistDTO;

import java.util.List;

public interface IArtistService {
    List<ArtistDTO> get();
    boolean exist(int id);
}
