package by.it_academy.vote.service.api;

import by.it_academy.vote.core.entity.VoteEntity;

import java.util.List;

public interface IVoteService {
    void save(VoteEntity vote);

    List<VoteEntity> getVotes();
}
