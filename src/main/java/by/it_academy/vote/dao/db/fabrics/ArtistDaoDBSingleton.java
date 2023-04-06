package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.db.ArtistDaoDB;
import by.it_academy.vote.dao.db.ds.fabrics.DataSourceSingleton;

import java.beans.PropertyVetoException;

public class ArtistDaoDBSingleton {
    private volatile static ArtistDaoDB instance;

    private ArtistDaoDBSingleton() {
    }

    public static IArtistDAO getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (ArtistDaoDBSingleton.class){
                if (instance == null) {
                    instance = new ArtistDaoDB(DataSourceSingleton.getInstance());

                }
            }
        }
        return instance;
    }
}
