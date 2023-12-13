package by.itclass.controllers;

import by.itclass.model.db.DbInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        boolean isFound = DbInMemory.isContainsUserByFio(fio);
        RequestDispatcher rd;
        if(isFound) {
            rd = req.getRequestDispatcher("/yes.html");
        } else {
            rd = req.getRequestDispatcher("/no.html");
        }
        rd.forward(req, resp);
    }
}
