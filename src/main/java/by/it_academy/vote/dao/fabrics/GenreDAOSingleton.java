package by.it_academy.vote.dao.fabrics;

import by.it_academy.vote.dao.GenreDAO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.service.fabrics.VoteServiceSingleton;

public class GenreDAOSingleton {
    private volatile static GenreDAO instance;

    private GenreDAOSingleton() {
    }

    public static IGenreDAO getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null){
                    instance = new GenreDAO();

                }
            }
        }
        return instance;
    }
}

