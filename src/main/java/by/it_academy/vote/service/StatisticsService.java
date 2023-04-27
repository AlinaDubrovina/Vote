package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.*;
import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.core.entity.GenreEntity;
import by.it_academy.vote.service.api.IArtistService;
import by.it_academy.vote.service.api.IGenreService;
import by.it_academy.vote.service.api.IStatisticsService;
import by.it_academy.vote.service.api.IVoteService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsService implements IStatisticsService {

    private final IVoteService voteService;
    private final IGenreService genreService;
    private final IArtistService artistService;

    public StatisticsService(IVoteService voteService,
                             IGenreService genreService,
                             IArtistService artistService) {
        this.voteService = voteService;
        this.genreService = genreService;
        this.artistService = artistService;
    }

    @Override
    public Map<ArtistDTO, Long> getBestArtists() {
        final Map<Long, Long> artistVotes = artistService.readAll()
                .stream()
                .collect(Collectors.toMap(ArtistEntity::getId, artist -> 0L));
        voteService.getVotes()
                .stream()
                .map(SavedVoteDTO::getVoteDTO)
                .map(VoteDTO::getArtistId)
                .forEach(artistId -> artistVotes.put(
                        artistId,
                        artistVotes.get(artistId) + 1L));
        return sortArtistsByVotes(artistVotes);
    }

    private Map<ArtistDTO, Long> sortArtistsByVotes(Map<Long, Long> artists) {
        return artists.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        entry -> artistService.get(entry.getKey()),
                        Map.Entry::getValue,
                        Long::sum,
                        LinkedHashMap::new));
    }

    @Override
    public Map<GenreDTO, Long> getBestGenres() {
        final Map<Long, Long> genreVotes = genreService.readAll()
                .stream()
                .collect(Collectors.toMap(GenreEntity::getId, genre -> 0L));
        voteService.getVotes()
                .stream()
                .map(SavedVoteDTO::getVoteDTO)
                .map(VoteDTO::getGenreIds)
                .flatMap(Collection::stream)
                .forEach(genreId -> genreVotes.put(
                        genreId,
                        genreVotes.get(genreId) + 1L));
        return sortGenresByVotes(genreVotes);
    }

    private Map<GenreDTO, Long> sortGenresByVotes(Map<Long, Long> genres) {
        return genres.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        entry -> genreService.get(entry.getKey()),
                        Map.Entry::getValue,
                        Long::sum,
                        LinkedHashMap::new));
    }

    @Override
    public Map<LocalDateTime, String> getAbouts() {
        List<SavedVoteDTO> votes = voteService.getVotes();
        return votes.stream()
                .sorted(Comparator.comparing(SavedVoteDTO::getDtCreate))
                .collect(Collectors.toMap(
                        SavedVoteDTO::getDtCreate,
                        vote -> vote.getVoteDTO().getAbout(),
                        (value1, value2) -> value1 + "\n\n"+ value2,
                        LinkedHashMap::new));
    }

    @Override
    public StatisticsDTO getStatistics() {
        return new StatisticsDTO(getBestArtists(), getBestGenres(), getAbouts());
    }
}