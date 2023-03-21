package by.it_academy.vote.service.api;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;

import java.util.List;

public interface IVoteService {
    void save(VoteDTO vote);

    List<SavedVoteDTO> get();
}
