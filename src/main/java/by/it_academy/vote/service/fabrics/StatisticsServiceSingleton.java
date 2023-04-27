package by.it_academy.vote.service.fabrics;

import by.it_academy.vote.service.StatisticsService;
import by.it_academy.vote.service.api.IStatisticsService;

public class StatisticsServiceSingleton {

    private volatile static IStatisticsService instance = null;

    private StatisticsServiceSingleton() {
    }

    public static IStatisticsService getInstance() {
        if (instance == null) {
            synchronized (StatisticsServiceSingleton.class) {
                if (instance == null) {
                    instance = new StatisticsService(
                            VoteServiceSingleton.getInstance(),
                            GenreServiceSingleton.getInstance(),
                            ArtistServiceSingleton.getInstance()
                    );
                }
            }
        }
        return instance;
    }
}