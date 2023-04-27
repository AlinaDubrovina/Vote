package by.it_academy.vote.service;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.core.entity.VoteEntity;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.service.api.IArtistService;
import by.it_academy.vote.service.api.IGenreService;
import by.it_academy.vote.service.api.IVoteService;

import java.util.List;


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
    public void save(SavedVoteDTO vote) {
        voteDAO.save(vote);
    }

    @Override
    public List<SavedVoteDTO> getVotes() {
        return voteDAO.getAll();
    }
}