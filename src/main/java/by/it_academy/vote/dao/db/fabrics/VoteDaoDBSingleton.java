package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.db.VoteDaoDB;
import by.it_academy.vote.dao.db.ds.fabrics.DataSourceSingleton;

import java.beans.PropertyVetoException;

public class VoteDaoDBSingleton {
    private volatile static IVoteDAO instance;

    private VoteDaoDBSingleton() {
    }

    public static IVoteDAO getInstance() throws PropertyVetoException {
        if(instance == null){
            synchronized (VoteDaoDBSingleton.class){
                if(instance == null){
                    instance = new VoteDaoDB(DataSourceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
