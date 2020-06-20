package dao.core;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<P,K> {
    P create(P item) throws DAOException, SQLException;
    P readById(Integer id) throws DAOException, SQLException;
    P readByKey(K k) throws DAOException, SQLException;
    boolean update(P item) throws DAOException, SQLException;
    boolean delete(P item) throws DAOException;
    List<P> readAll() throws DAOException, SQLException;
}
