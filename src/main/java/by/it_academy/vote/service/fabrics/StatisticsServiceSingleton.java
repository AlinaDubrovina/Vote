package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.service.StatisticsService;
import by.it_academy.vote.service.api.IStatisticsService;

import java.beans.PropertyVetoException;

public class StatisticsServiceSingleton {
    private volatile static StatisticsService instance;
    private StatisticsServiceSingleton() {
    }

    public static IStatisticsService getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (StatisticsServiceSingleton.class) {
                if (instance == null) {
                    instance = new StatisticsService(
                            VoteServiceSingleton.getInstance(),
                            ArtistServiceSingleton.getInstance(),
                            GenreServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}
