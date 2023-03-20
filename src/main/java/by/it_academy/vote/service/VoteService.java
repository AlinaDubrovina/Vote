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
        if (!this.artistService.exist(vote.getArtist())){
            throw new IllegalArgumentException("The artist " + vote.getArtist() + " does not exist.");
        }

        int[] genres = vote.getGenres();
        if (genres == null){
            throw new IllegalArgumentException("Choose genres.");
        }
        if (genres.length < 3 || genres.length > 5){
            throw new IllegalArgumentException("3 to 5 genres must be selected.");
        }
        for (int genre : vote.getGenres()){
            if (!this.genreService.exist(genre)){
                throw new IllegalArgumentException("The genre " + genre + " does not exist.");
            }
        }
        Set<Integer> names = new HashSet<>();
        for (int genre : genres){
            names.add(genre);
        }


        String about = vote.getAbout();
        if (about == null || about.isBlank()){
            throw new IllegalArgumentException("Write about yourself.");
        }
    }
}