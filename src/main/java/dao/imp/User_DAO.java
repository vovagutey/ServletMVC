package dao.imp;

import dao.core.AbstractDAO;
import dao.core.DataBaseUtills;
import dao.entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_DAO extends AbstractDAO<User, String> {
    @Override
    public String getCreateQuery() {
        return  "{call full_user_create(?,?,?,?)}";
    }

    @Override
    public String getReadQuery() {
        return "{call get_byId(?,?,?,?,?,?)}";
    }

    @Override
    public String getUpdateQuery() {
        return "{call user_update(?,?,?,?,?)}";
    }

    @Override
    public String getDeleteQuery() {
        return "call user_delete(?)";
    }

    @Override
    public String getReadAllQuery() {
        return "{CALL getAll}";
    }
    @Override
    protected String getReadByKeyQuery() { return "{call getByLogin(?,?,?,?,?,?,?)}"; }

    @Override
    public void setItem(CallableStatement statement, User user) {
        try {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    @Override
    protected void setStatementForReadByKey(CallableStatement callableStatement, String key) throws SQLException {
        callableStatement.setString(1, key);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.registerOutParameter(5, Types.VARCHAR);
        callableStatement.registerOutParameter(6, Types.INTEGER);
        callableStatement.registerOutParameter(7, Types.TIMESTAMP);


    }

    @Override
    protected void setStatementForReadById(CallableStatement callableStatement, Integer id) throws SQLException {

        callableStatement.setInt(1, id);
        callableStatement.registerOutParameter(2, Types.VARCHAR);
        callableStatement.registerOutParameter(3, Types.VARCHAR);
        callableStatement.registerOutParameter(4, Types.VARCHAR);
        callableStatement.registerOutParameter(5, Types.VARCHAR);
        callableStatement.registerOutParameter(6, Types.TIMESTAMP);
    }

    @Override
    protected User parseObjectFromStatement(CallableStatement callableStatement) throws SQLException {
        User user = new User();
        user.setUser_id(callableStatement.getInt("id"));
        user.setLogin(callableStatement.getString("user_login"));
        user.setPassword(callableStatement.getString("user_pass"));
        user.setEmail(callableStatement.getString("user_email"));
        user.setPhone(callableStatement.getString("user_phone"));
        user.setCreated(callableStatement.getTimestamp("created_date").toLocalDateTime());

        return user;
    }

    @Override
    public void updateUser(CallableStatement statement, User user) throws SQLException {
        statement.setLong(1, user.getUser_id());
        statement.setString(2, user.getLogin());
        statement.setString(3, user.getPassword());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPhone());
    }

    @Override
    public List<User> getAll(PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            User user = new User();
            int i = 0;
            user.setUser_id(resultSet.getInt(++i));
            user.setLogin(resultSet.getString(++i));
            user.setPassword(resultSet.getString(++i));
            user.setEmail(resultSet.getString(++i));
            user.setPhone(resultSet.getString(++i));
            user.setCreated(resultSet.getTimestamp(++i).toLocalDateTime());
            users.add(user);

        }

        return users;
    }
}
