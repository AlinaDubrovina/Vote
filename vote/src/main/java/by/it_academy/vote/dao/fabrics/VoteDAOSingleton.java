package by.it_academy.vote.dao.fabrics;

import by.it_academy.vote.dao.VoteDAO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.service.fabrics.VoteServiceSingleton;

public class VoteDAOSingleton {
    private volatile static VoteDAO instance;

    private VoteDAOSingleton() {
    }

    public static IVoteDAO getInstance() {
        if (instance == null) {
            synchronized (VoteServiceSingleton.class) {
                if (instance == null){
                    instance = new VoteDAO();

                }
            }
        }
        return instance;
    }
}

