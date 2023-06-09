package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.dao.fabrics.VoteDAOSingleton;
import by.it_academy.vote.service.VoteService;
import by.it_academy.vote.service.api.IVoteService;

public class VoteServiceSingleton {
    private volatile static VoteService instance;
    private VoteServiceSingleton() {
    }

    public static IVoteService getInstance(){
        if (instance == null) {
            synchronized (VoteServiceSingleton.class){
                if (instance == null) {
                    instance = new VoteService(
                            VoteDAOSingleton.getInstance(),
                            ArtistServiceSingleton.getInstance(),
                            GenreServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}
