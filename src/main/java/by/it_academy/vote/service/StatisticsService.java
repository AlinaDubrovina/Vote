package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.*;
import by.it_academy.vote.service.api.IArtistService;
import by.it_academy.vote.service.api.IGenreService;
import by.it_academy.vote.service.api.IStatisticsService;
import by.it_academy.vote.service.api.IVoteService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsService implements IStatisticsService {
    private IVoteService voteService;
    private IArtistService artistService;
    private IGenreService genreService;

    public StatisticsService(IVoteService voteService, IArtistService artistService, IGenreService genreService) {
        this.voteService = voteService;
        this.artistService = artistService;
        this.genreService = genreService;
    }


    @Override
    public ResultDTO getResult() {
        return new ResultDTO(getTopArtist(), getTopGenre(), getAboutRows());
    }

    @Override
    public List<ResultRow<ArtistDTO>> getTopArtist() {
        List<ResultRow<ArtistDTO>> top = this.artistService.get().stream()
                .map(ResultRow::new)
                .collect(Collectors.toList());


        for(SavedVoteDTO savedVoteDTO : voteService.get()){
            int[] artists = savedVoteDTO.getVote().getGenres();

            for (ResultRow<ArtistDTO> artistDTOResultRow : top) {
                for (int artist : artists) {
                    if (artistDTOResultRow.getItem().getId() == artist) {
                        artistDTOResultRow.inc();
                        break;
                    }
                }
            }
        }
        top.sort(Comparator.comparing(ResultRow::getCount));
        return top;
    }

    @Override
    public List<ResultRow<GenreDTO>> getTopGenre() {
        List<ResultRow<GenreDTO>> top = this.genreService.get().stream()
                .map(ResultRow::new)
                .collect(Collectors.toList());


        for(SavedVoteDTO savedVoteDTO : voteService.get()){
            int[] genres = savedVoteDTO.getVote().getGenres();

            for (ResultRow<GenreDTO> genreDTOResultRow : top) {
                for (int genre : genres) {
                    if (genreDTOResultRow.getItem().getId() == genre) {
                        genreDTOResultRow.inc();
                        break;
                    }
                }
            }
        }
        top.sort(Comparator.comparing(ResultRow::getCount));
        return top;
    }

    @Override
    public List<AboutRow> getAboutRows() {
        return this.voteService.get().stream()
                .map(i -> new AboutRow(i.getDtCreate(), i.getVote().getAbout()))
                .sorted(Comparator.comparing(AboutRow::getDtCreate))
                .collect(Collectors.toList());
    }
}
