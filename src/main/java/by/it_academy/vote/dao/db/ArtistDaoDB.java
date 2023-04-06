package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.dto.ArtistDTO;
import by.it_academy.vote.dao.api.IArtistDAO;
import by.it_academy.vote.dao.db.ds.api.IDataSourceWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDaoDB implements IArtistDAO {
    private final IDataSourceWrapper dataSource;

    public ArtistDaoDB(IDataSourceWrapper wrapper){
        this.dataSource = wrapper;
    }

    @Override
    public void create(ArtistDTO artistDTO) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO  app.artists (name) VALUES (?);")) {
            preparedStatement.setString(1, artistDTO.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public List<ArtistDTO> readAll() {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, name FROM app.artists");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<ArtistDTO> artistsList = new ArrayList<>();
            while (resultSet.next()) {
                ArtistDTO artistDTO = buildArtistDto(resultSet);
                artistsList.add(artistDTO);
            }
            return artistsList;
        } catch (SQLException e) {
            throw new RuntimeException("SQLException readAll method :" + e);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE from app.artists where id=?;")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void update(ArtistDTO artistDTO) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE app.artists SET name = ? WHERE id=?;")) {
            int id = artistDTO.getId();
            String name = artistDTO.getName();
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean exist(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM app.artists WHERE id = ?);")){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    protected ArtistDTO buildArtistDto(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        return new ArtistDTO(id, name);
    }
}

