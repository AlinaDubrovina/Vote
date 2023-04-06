package by.it_academy.vote.dao.memory.fabrics;

import by.it_academy.vote.dao.memory.VoteDAO;
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

