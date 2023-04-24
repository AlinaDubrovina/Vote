package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.db.ArtistDaoDB;
import by.it_academy.vote.dao.entity_manager.EntityManagerSingleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ArtistDaoDBSingleton {
    private volatile static ArtistDaoDB instance;

    private ArtistDaoDBSingleton() {
    }

    public static IArtistDAO getInstance(){
        if (instance == null) {
            synchronized (ArtistDaoDBSingleton.class){
                if (instance == null) {
                    instance = new ArtistDaoDB(EntityManagerSingleton.getEntityManagerFactory());
                }
            }
        }
        return instance;
    }
}
