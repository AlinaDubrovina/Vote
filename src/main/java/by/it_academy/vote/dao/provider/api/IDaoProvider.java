package by.it_academy.vote.dao.provider.api;

import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.api.IVoteDAO;

import java.beans.PropertyVetoException;

public interface IDaoProvider {
    IArtistDAO artistDAO();
    IGenreDAO genreDAO();
    IVoteDAO voteDAO() throws PropertyVetoException;
}
