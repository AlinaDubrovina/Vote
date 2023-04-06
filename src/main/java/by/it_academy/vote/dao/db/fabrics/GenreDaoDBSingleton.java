package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.db.GenreDaoDB;
import by.it_academy.vote.dao.db.ds.fabrics.DataSourceSingleton;

import java.beans.PropertyVetoException;

public class GenreDaoDBSingleton {
    private volatile static GenreDaoDB instance;

    private GenreDaoDBSingleton() {
    }

    public static IGenreDAO getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (GenreDaoDBSingleton.class){
                if (instance == null) {
                    instance = new GenreDaoDB(DataSourceSingleton.getInstance());

                }
            }
        }
        return instance;
    }
}
