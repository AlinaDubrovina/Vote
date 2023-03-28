package by.it_academy.vote.dao.fabrics;

import by.it_academy.vote.dao.memory.ArtistDAO;
import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.service.fabrics.VoteServiceSingleton;

public class ArtistDAOSingleton {
    private volatile static ArtistDAO instance;

    private ArtistDAOSingleton() {
    }

    public static IArtistDAO getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null){
                    instance = new ArtistDAO();

                }
            }
        }
        return instance;
    }
}

