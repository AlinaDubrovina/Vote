package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.dao.provider.ChoiceDaoProvider;
import by.it_academy.vote.dao.provider.api.IDaoProvider;
import by.it_academy.vote.service.VoteService;
import by.it_academy.vote.service.api.IVoteService;

import java.beans.PropertyVetoException;

public class VoteServiceSingleton {
    private volatile static VoteService instance;
    private VoteServiceSingleton() {
    }

    public static IVoteService getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class){
                if (instance == null) {
                    IDaoProvider daoProvider = ChoiceDaoProvider.getInstance();
                    instance = new VoteService(
                            daoProvider.voteDAO(),
                            ArtistServiceSingleton.getInstance(),
                            GenreServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}
