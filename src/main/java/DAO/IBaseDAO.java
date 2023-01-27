package DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    List<T> findAll() throws SQLException, IOException;

    T getEntityById(long id) throws SQLException, IOException;

    boolean update(T entity) throws SQLException, IOException;

    boolean create(T entity) throws SQLException, IOException;

    boolean remove(long id) throws SQLException, IOException;
}
