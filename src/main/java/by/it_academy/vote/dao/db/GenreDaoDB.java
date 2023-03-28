package by.it_academy.vote.dao.db;

import by.it_academy.vote.core.dto.GenreDTO;
import by.it_academy.vote.dao.api.IGenreDAO;
import by.it_academy.vote.dao.db.ds.api.IDataSourceWrapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoDB implements IGenreDAO{
    private final IDataSourceWrapper dataSource;

    public GenreDaoDB(IDataSourceWrapper wrapper){
        this.dataSource = wrapper;
    }


    @Override
    public void create(GenreDTO genreDTO) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  app.genres (name) VALUES (?);")) {
            preparedStatement.setString(1, genreDTO.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<GenreDTO> readAll() {
        List<GenreDTO> genres = new ArrayList<>();
        try (Connection conn = this.dataSource.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT id, name FROM app.genres;")
        ){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                genres.add(new GenreDTO(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genres;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE from app.genres where id=?;")) {
            preparedStatement.setInt(1, id);
            int affectedRows = preparedStatement.executeUpdate();
            return affectedRows != 0;
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

    @Override
    public void update(GenreDTO genreDTO) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE app.genres SET name = ? WHERE id=?;")) {
            int id = genreDTO.getId();
            String name = genreDTO.getName();
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
