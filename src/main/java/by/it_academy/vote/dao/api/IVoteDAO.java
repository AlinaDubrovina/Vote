package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.SavedVoteDTO;

public interface IVoteDAO {
    void save(SavedVoteDTO vote);
}
