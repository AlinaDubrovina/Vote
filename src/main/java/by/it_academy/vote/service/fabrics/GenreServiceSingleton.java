package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.dao.db.fabrics.GenreDaoDBSingleton;
import by.it_academy.vote.service.GenreService;
import by.it_academy.vote.service.api.IGenreService;

public class GenreServiceSingleton {
    private volatile static GenreService instance;

    private GenreServiceSingleton() {
    }

    public static IGenreService getInstance(){
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null) {
                    instance = new GenreService(GenreDaoDBSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
