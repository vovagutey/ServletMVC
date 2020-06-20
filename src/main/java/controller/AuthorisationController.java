package controller;

import dao.entity.User;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "AuthorisationController", urlPatterns = "/signin")
public class AuthorisationController extends HttpServlet {
    UserService us = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        User user = us.signin(login, password);

        if (user != null) {
            HttpSession httpSession = req.getSession();

            httpSession.setMaxInactiveInterval(30);

            Cookie loginCookie = new Cookie("login", login);
            loginCookie.setMaxAge(30 * 1);

            resp.addCookie(loginCookie);

            //Create session here!!! user object

            httpSession.setAttribute("user", user);

            // if(httpSession.getAttribute("created")==null){
            //     httpSession.setAttribute("created", LocalDateTime.now());
            // }
            RequestDispatcher rd = req.getRequestDispatcher("/user-page.jsp");

            rd.forward(req, resp);


        } else {
            printWriter.println("this user are not register");
        }

    }
}
