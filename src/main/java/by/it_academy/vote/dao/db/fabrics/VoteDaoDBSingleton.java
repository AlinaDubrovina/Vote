package by.it_academy.vote.dao.db.fabrics;

import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.db.VoteDaoDB;
import by.it_academy.vote.dao.entity_manager.EntityManagerSingleton;

import javax.persistence.EntityManagerFactory;

public class VoteDaoDBSingleton {
    private volatile static IVoteDAO instance;

    private VoteDaoDBSingleton() {
    }

    public static IVoteDAO getInstance(){
        if(instance == null){
            synchronized (VoteDaoDBSingleton.class){
                if(instance == null){
                    instance = new VoteDaoDB(EntityManagerSingleton.getEntityManagerFactory());
                }
            }
        }
        return instance;
    }
}
