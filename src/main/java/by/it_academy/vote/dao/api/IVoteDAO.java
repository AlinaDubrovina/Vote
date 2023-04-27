package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;

import java.util.List;

public interface IVoteDAO{
    List<SavedVoteDTO> getAll();

    void save(SavedVoteDTO votes);
}
