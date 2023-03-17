package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.service.api.IArtistService;
import by.it_academy.vote.service.api.IGenreService;
import by.it_academy.vote.service.api.IVoteService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class VoteService implements IVoteService {
    private final IVoteDAO voteDAO;
    private final IArtistService artistService;
    private final IGenreService genreService;

    public VoteService(IVoteDAO voteDAO, IArtistService artistService, IGenreService genreService) {
        this.voteDAO = voteDAO;
        this.artistService = artistService;
        this.genreService = genreService;
    }

    @Override
    public void save(VoteDTO vote) {
        this.validate(vote);
        SavedVoteDTO savedVoteDTO = new SavedVoteDTO(vote);
        this.voteDAO.save(savedVoteDTO);
    }

    private void validate(VoteDTO vote){
        String artist = vote.getArtist();
        if (artist == null || artist.isBlank()){
            throw new IllegalArgumentException("Choose an artist.");
        }
        if (!this.artistService.exist(vote.getArtist())){
            throw new IllegalArgumentException("The artist " + vote.getArtist() + " does not exist.");
        }

        String[] genres = vote.getGenres();
        if (genres == null){
            throw new IllegalArgumentException("Choose genres.");
        }
        if (genres.length < 3 || genres.length > 5){
            throw new IllegalArgumentException("3 to 5 genres must be selected.");
        }
        for (String genre : vote.getGenres()){
            if (genre == null || genre.isBlank()){
                throw new IllegalArgumentException("Choose a genre.");
            }
            if (!this.genreService.exist(genre)){
                throw new IllegalArgumentException("The genre " + genre + " does not exist.");
            }
        }
        Set<String> names = new HashSet<>();
        names.addAll(Arrays.asList(genres));
        if(genres.length != names.size()){
            throw new IllegalArgumentException("Genres repeat.");
        }

        String about = vote.getAbout();
        if (about == null || about.isBlank()){
            throw new IllegalArgumentException("Write about yourself.");
        }
    }
}