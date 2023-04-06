package by.it_academy.vote.dao.api;

import by.it_academy.vote.core.dto.SavedVoteDTO;

import java.util.List;

public interface IVoteDAO extends IDAO<SavedVoteDTO>{
    void save(SavedVoteDTO vote);

    List<SavedVoteDTO> get();
}
