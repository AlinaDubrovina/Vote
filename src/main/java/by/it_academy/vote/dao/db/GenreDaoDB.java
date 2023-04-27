package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.core.entity.GenreEntity;
import by.it_academy.vote.dao.api.IGenreDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class GenreDaoDB implements IGenreDAO{
    private final EntityManagerFactory entityManagerFactory;

    public GenreDaoDB(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public void create(GenreEntity genreEntity) {
        EntityManager genreEntityManager = entityManagerFactory.createEntityManager();
        try {
            genreEntityManager.getTransaction().begin();
            genreEntityManager.persist(genreEntity);
            genreEntityManager.getTransaction().commit();
            genreEntityManager.close();
        } catch (Exception e){
            throw new RuntimeException("Create method exception" + e);
        } finally {
            genreEntityManager.close();
        }
    }

    @Override
    public GenreDTO get(Long id) {
        EntityManager genreEntityManager = entityManagerFactory.createEntityManager();
        GenreDTO genreDTO;
        try {
            genreEntityManager.getTransaction().begin();
            genreEntityManager.createNativeQuery("SET TRANSACTION READ ONLY;").executeUpdate();

            GenreEntity genreEntity= genreEntityManager.find(GenreEntity.class, id);
            genreDTO = new GenreDTO(genreEntity);

            genreEntityManager.getTransaction().commit();
        } catch (Exception e) {
            if (genreEntityManager != null && genreEntityManager.getTransaction().isActive()) {
                genreEntityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (genreEntityManager != null) {
                genreEntityManager.close();
            }
        }
        return genreDTO;
    }

    @Override
    public List<GenreEntity> readAll() {
        EntityManager genreEntityManager = entityManagerFactory.createEntityManager();

        genreEntityManager.getTransaction().begin();
        List<GenreEntity> resultList = genreEntityManager.createQuery("FROM GenreEntity", GenreEntity.class).getResultList();
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
        return resultList;
    }

    @Override
    public void delete(Long id) {
        EntityManager genreEntityManager = entityManagerFactory.createEntityManager();

        genreEntityManager.getTransaction().begin();
        GenreEntity genreToRemove = genreEntityManager.find(GenreEntity.class, id);
        genreEntityManager.remove(genreToRemove);
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
    }

    @Override
    public void update(GenreEntity genreEntity) {
        EntityManager genreEntityManager = entityManagerFactory.createEntityManager();

        genreEntityManager.getTransaction().begin();
        genreEntityManager.merge(genreEntity);
        genreEntityManager.getTransaction().commit();
        genreEntityManager.close();
    }
}

