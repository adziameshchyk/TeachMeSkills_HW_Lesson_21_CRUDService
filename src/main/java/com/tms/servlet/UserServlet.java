package com.tms.servlet;

import com.tms.model.User;
import com.tms.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private static UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        userService.addUser(new User(name, surname, Integer.parseInt(age), email));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null) {
            List<User> users = userService.getAllUsers();

            for (User user : users) {
                resp.getWriter().println(user);
            }
        } else {
            resp.getWriter().print(userService.getUserById(Integer.parseInt(id)));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        userService.updateUser(Integer.parseInt(id), new User(name, surname, Integer.parseInt(age), email));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");


        if (id == null) {
            userService.deleteAllUsers();
        } else {
            userService.deleteById(Integer.parseInt(id));
        }
    }

}
