package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.core.entity.ArtistEntity;
import by.it_academy.vote.core.entity.GenreEntity;
import by.it_academy.vote.core.entity.VoteEntity;
import by.it_academy.vote.dao.api.IVoteDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

public class VoteDaoDB implements IVoteDAO {
    private final EntityManagerFactory entityManagerFactory;

    public VoteDaoDB(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<SavedVoteDTO> getAll() {
        List<SavedVoteDTO> savedVoteDTOs;
        List<VoteEntity> voteEntities;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.createNativeQuery("SET TRANSACTION READ ONLY;").executeUpdate();

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<VoteEntity> voteQuery = cb.createQuery(VoteEntity.class);

            Root<VoteEntity> from = voteQuery.from(VoteEntity.class);
            CriteriaQuery<VoteEntity> finalVoteQuery = voteQuery.select(from);

            voteEntities = entityManager.createQuery(finalVoteQuery)
                    .getResultList();
            savedVoteDTOs = voteEntities
                    .stream()
                    .map(vote -> new SavedVoteDTO(new VoteDTO(
                            vote.getArtistId().getId(),
                            vote.getGenreIds().stream().map(GenreEntity::getId).collect(Collectors.toList()),
                            vote.getAbout()),
                            vote.getDtCreate()))
                    .collect(Collectors.toList());
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }

        return savedVoteDTOs;
    }
    @Override
    public void save(SavedVoteDTO vote) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<GenreEntity> genres;
        try {

            entityManager.getTransaction().begin();

            ArtistEntity artistEntity = entityManager.find(ArtistEntity.class,
                    vote.getVoteDTO().getArtistId());
            System.out.println(artistEntity.getId());

            List<Long> genreIds = vote.getVoteDTO().getGenreIds();

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<GenreEntity> genreQuery = cb.createQuery(GenreEntity.class);

            Root<GenreEntity> fromGenres = genreQuery.from(GenreEntity.class);
            CriteriaQuery<GenreEntity> finalGenreQuery = genreQuery.select(fromGenres)
                    .where(fromGenres.in(genreIds));

            genres = entityManager.createQuery(finalGenreQuery).getResultList();

            VoteEntity voteEntity = new VoteEntity(artistEntity, genres, vote.getVoteDTO().getAbout(),
                    vote.getDtCreate());
            entityManager.persist(voteEntity);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}