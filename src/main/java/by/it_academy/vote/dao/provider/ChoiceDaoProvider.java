package by.it_academy.vote.dao.provider;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.provider.api.IDaoProvider;

import java.beans.PropertyVetoException;

public class ChoiceDaoProvider implements IDaoProvider {
    private static volatile ChoiceDaoProvider instance;
    private boolean useDB = true;
    private IDaoProvider daoProvider;

    private ChoiceDaoProvider() {
        if (useDB){
        daoProvider = new DaoDBProvider();
        }
        else daoProvider = new DaoMemoryProvider();
    }

    @Override
    public IArtistDAO artistDAO() {
        return daoProvider.artistDAO();
    }

    @Override
    public IGenreDAO genreDAO() {
        return daoProvider.genreDAO();
    }

    @Override
    public IVoteDAO voteDAO() throws PropertyVetoException {
        return daoProvider.voteDAO();
    }

    public static IDaoProvider getInstance(){
        if (instance == null){
            synchronized (ChoiceDaoProvider.class){
                if (instance == null){
                    instance = new ChoiceDaoProvider();
                }
            }
        }
        return instance;
    }
}
