package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;
import javafx.scene.chart.XYChart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(value = "/jspSearch")
public class JspUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        User user = DbInMemory.findUserByFio(fio);
        RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");
        if (Objects.nonNull(user)) {
            req.setAttribute("user", user);
        } else {
            String mess = "User with " + fio + " not found";
            req.setAttribute("message", mess);
        }
        rd.forward(req, resp);
    }
}
