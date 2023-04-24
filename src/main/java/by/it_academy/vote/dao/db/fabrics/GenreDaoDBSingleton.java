package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.db.GenreDaoDB;
import by.it_academy.vote.dao.entity_manager.EntityManagerSingleton;

public class GenreDaoDBSingleton {
    private volatile static GenreDaoDB instance;

    private GenreDaoDBSingleton() {
    }

    public static IGenreDAO getInstance(){
        if (instance == null) {
            synchronized (GenreDaoDBSingleton.class){
                if (instance == null) {
                    instance = new GenreDaoDB(EntityManagerSingleton.getEntityManagerFactory());
                }
            }
        }
        return instance;
    }
}
