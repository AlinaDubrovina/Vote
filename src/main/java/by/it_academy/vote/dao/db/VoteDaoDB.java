package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.dto.SavedVoteDTO;
import by.it_academy.vote.core.dto.VoteDTO;
import by.it_academy.vote.dao.api.IVoteDAO;
import by.it_academy.vote.dao.db.ds.api.IDataSourceWrapper;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VoteDaoDB implements IVoteDAO {
    private final IDataSourceWrapper dataSource;

    public VoteDaoDB(IDataSourceWrapper dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void create(SavedVoteDTO savedVoteDTO) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO  app.votes (dt_create ,about) VALUES (?,?);", Statement.RETURN_GENERATED_KEYS)) {
            Timestamp timestamp = Timestamp.valueOf(savedVoteDTO.getDtCreate());
            preparedStatement.setTimestamp(1,timestamp);
            preparedStatement.setString(2, savedVoteDTO.getVote().getAbout());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQLException create method :" + e);
        }
    }

    @Override
    public List<SavedVoteDTO> readAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,date_time,about from app.votes");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List <SavedVoteDTO> savedVoteDTOList = new ArrayList<>();
            while (resultSet.next()) {
                LocalDateTime dt = resultSet.getTimestamp("dt_create").toLocalDateTime();
                String about = resultSet.getString("about");
                VoteDTO voteDTO = new VoteDTO(0, null, about);
                SavedVoteDTO savedVoteDTO = new SavedVoteDTO(dt, voteDTO);
                savedVoteDTOList.add(savedVoteDTO);
            }
            return savedVoteDTOList;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException readAll method :" + e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE from data.genres where id=?")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException delete method :" + e);
        }
    }

    @Override
    public void save(SavedVoteDTO vote) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO  app.votes (dt_create ,about) VALUES (?,?);", Statement.RETURN_GENERATED_KEYS)) {
            Timestamp timestamp = Timestamp.valueOf(vote.getDtCreate());
            preparedStatement.setTimestamp(1,timestamp);
            preparedStatement.setString(2, vote.getVote().getAbout());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("SQLException save method :" + e);
        }
    }

    @Override
    public List<SavedVoteDTO> get() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,date_time,about from app.votes");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List <SavedVoteDTO> savedVoteDTOList = new ArrayList<>();
            while (resultSet.next()) {
                LocalDateTime dt = resultSet.getTimestamp("dt_create").toLocalDateTime();
                String about = resultSet.getString("about");
                VoteDTO voteDTO = new VoteDTO(0, null, about);
                SavedVoteDTO savedVoteDTO = new SavedVoteDTO(dt, voteDTO);
                savedVoteDTOList.add(savedVoteDTO);
            }
            return savedVoteDTOList;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException get method :" + e);
        }
    }
}
