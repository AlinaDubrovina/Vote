package by.it_academy.vote.dao.memory;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.dao.api.IVoteDAO;

import java.util.ArrayList;
import java.util.List;

public class VoteDAO implements IVoteDAO {
    private List<SavedVoteDTO> savedVoteDTOS = new ArrayList<>();
    @Override
    public void save(SavedVoteDTO vote) {
        this.savedVoteDTOS.add(vote);
    }

    @Override
    public List<SavedVoteDTO> get() {
        return this.savedVoteDTOS;
    }
}