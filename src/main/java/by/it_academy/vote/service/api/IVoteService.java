package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.SavedVoteDTO;

import java.util.List;

public interface IVoteService {
    void save(SavedVoteDTO vote);

    List<SavedVoteDTO> getVotes();
}
