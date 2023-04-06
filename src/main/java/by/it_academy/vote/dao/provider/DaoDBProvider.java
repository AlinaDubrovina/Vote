package by.it_academy.vote.dao.provider;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.db.fabrics.ArtistDaoDBSingleton;
import by.it_academy.vote.dao.db.fabrics.GenreDaoDBSingleton;
import by.it_academy.vote.dao.db.fabrics.VoteDaoDBSingleton;
import by.it_academy.vote.dao.provider.api.IDaoProvider;

import java.beans.PropertyVetoException;

public class DaoDBProvider implements IDaoProvider {
    @Override
    public IArtistDAO artistDAO() {
        try {
            return ArtistDaoDBSingleton.getInstance();
        } catch (PropertyVetoException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public IGenreDAO genreDAO() {
        try {
            return GenreDaoDBSingleton.getInstance();
        } catch (PropertyVetoException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public IVoteDAO voteDAO() throws PropertyVetoException {
        return VoteDaoDBSingleton.getInstance();
    }
}
