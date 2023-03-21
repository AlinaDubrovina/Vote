package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.*;

import java.util.List;

public interface IStatisticsService {
    ResultDTO getResult();

    List<ResultRow<ArtistDTO>> getTopArtist();
    List<ResultRow<GenreDTO>> getTopGenre();
    List<AboutRow> getAboutRows();
}
