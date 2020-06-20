package controller;

import dao.core.DAOException;
import dao.core.DataBaseUtills;
import dao.entity.User;
import dao.imp.User_DAO;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {
    private UserService us = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();

        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setLogin(req.getParameter("login"));
        user.setPhone(req.getParameter("phone"));

        us.signUp(user);

    }
}
