package by.itclass.controllers;

import by.itclass.model.entities.User;
import by.itclass.model.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@WebServlet(value = "/criteria")
public class ConditionsServlet extends HttpServlet {
    private UserService service;

    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();
        List<User> users = service.getUsersByCondition(params);
        RequestDispatcher rd = req.getRequestDispatcher("/users.jsp");
        if (!users.isEmpty()) {
            req.setAttribute("users", users);
        } else {
            req.setAttribute("message", "Users not found");
        }
        rd.forward(req, resp);
    }
}
