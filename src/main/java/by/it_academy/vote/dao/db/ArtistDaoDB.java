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
                     "INSERT INTO  app.artist (name) VALUES (?);")) {
            preparedStatement.setString(1, artistDTO.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public List<ArtistDTO> readAll() {
        List<ArtistDTO> artists = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, name FROM app.artist;")
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                artists.add(new ArtistDTO(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return artists;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE from app.artist where id=?;")) {
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
                     "UPDATE app.artist SET name = ? WHERE id=?;")) {
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
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM app.genres WHERE id = ?);")){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}

