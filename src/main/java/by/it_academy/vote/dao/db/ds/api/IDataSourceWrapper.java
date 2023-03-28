package by.it_academy.vote.dao.db.ds.api;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDataSourceWrapper extends AutoCloseable{
    Connection getConnection() throws SQLException;
}
