package by.it_academy.vote.dao.provider;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.memory.fabrics.ArtistDAOSingleton;
import by.it_academy.vote.dao.memory.fabrics.GenreDAOSingleton;
import by.it_academy.vote.dao.memory.fabrics.VoteDAOSingleton;
import by.it_academy.vote.dao.provider.api.IDaoProvider;

public class DaoMemoryProvider implements IDaoProvider {
    @Override
    public IArtistDAO artistDAO() {
        return ArtistDAOSingleton.getInstance();
    }

    @Override
    public IGenreDAO genreDAO() {
        return GenreDAOSingleton.getInstance();
    }

    @Override
    public IVoteDAO voteDAO() {
        return VoteDAOSingleton.getInstance();
    }
}
