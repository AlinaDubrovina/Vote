package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.dao.memory.fabrics.ArtistDAOSingleton;
import by.it_academy.vote.dao.provider.ChoiceDaoProvider;
import by.it_academy.vote.service.ArtistService;
import by.it_academy.vote.service.api.IArtistService;

public class ArtistServiceSingleton {
    private volatile static ArtistService instance;

    private ArtistServiceSingleton() {
    }

    public static IArtistService getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null){
                    instance = new ArtistService(ChoiceDaoProvider.getInstance().artistDAO());
                }
            }
        }
        return instance;
    }
}
