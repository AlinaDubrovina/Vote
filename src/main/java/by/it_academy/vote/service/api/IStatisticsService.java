package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.dto.StatisticsDTO;

import java.time.LocalDateTime;
import java.util.Map;

public interface IStatisticsService {

    Map<ArtistDTO, Long> getBestArtists();

    Map<GenreDTO, Long> getBestGenres();

    Map<LocalDateTime, String> getAbouts();

    StatisticsDTO getStatistics();
}
