package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.dao.api.IArtistDAO;

import javax.persistence.*;
import java.util.List;

public class ArtistDaoDB implements IArtistDAO {
    private final EntityManagerFactory entityManagerFactory;

    public ArtistDaoDB(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void create(ArtistEntity artistEntity) {
        EntityManager artistEntityManager = entityManagerFactory.createEntityManager();
        try {
        artistEntityManager.getTransaction().begin();
        artistEntityManager.persist(artistEntity);
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
        } catch (Exception e){
            throw new RuntimeException("Create method exception" + e);
        } finally {
            artistEntityManager.close();
        }
    }

    @Override
       public List<ArtistEntity> readAll() {
        EntityManager artistEntityManager = entityManagerFactory.createEntityManager();

        artistEntityManager.getTransaction().begin();
        List<ArtistEntity> resultList = artistEntityManager.createQuery("FROM ArtistEntity", ArtistEntity.class).getResultList();
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(Long id) {
        EntityManager artistEntityManager = entityManagerFactory.createEntityManager();

        artistEntityManager.getTransaction().begin();
        ArtistEntity artistToRemove = artistEntityManager.find(ArtistEntity.class, id);
        artistEntityManager.remove(artistToRemove);
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
    }

    @Override
    public void update(ArtistEntity artistEntity) {
        EntityManager artistEntityManager = entityManagerFactory.createEntityManager();

        artistEntityManager.getTransaction().begin();
        artistEntityManager.merge(artistEntity);
        artistEntityManager.getTransaction().commit();
        artistEntityManager.close();
    }
}

