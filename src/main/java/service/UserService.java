package service;

import dao.core.DAOException;
import dao.entity.User;
import dao.imp.User_DAO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserService {
    private User_DAO dao = new User_DAO();

    public User signin(String login, String password) throws IOException {     //дічь
        User user = null;
        try {
            user = dao.readByKey(login);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void signUp(User user) {
        User_DAO userDao = new User_DAO();
        try {
            userDao.create(user);
        } catch (DAOException e) {
            e.getMessage();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

}

