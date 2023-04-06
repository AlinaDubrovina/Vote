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

    @Override
    public void create(SavedVoteDTO vote) {
        this.savedVoteDTOS.add(vote);
    }

    @Override
    public List<SavedVoteDTO> readAll() {
        return this.savedVoteDTOS;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
