package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.ArtistDTO;

import java.util.List;

public interface IArtistDAO {
    List<ArtistDTO> get();
    boolean exist(int id);
}
