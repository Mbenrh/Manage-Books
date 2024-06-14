package org.example.controller;

import org.example.dao.DaoLivre;
import org.example.models.Livre;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/manageBooks")
public class ManageBooks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get books from database
      /*  List<Livre> bookList = new ArrayList<>();
        bookList.add(new Livre("LC01","Java", "John Doe", "Thomas Edition", 100));
        bookList.add(new Livre("LC02","C++", "John Doe", "Thomas Edition", 100));
        bookList.add(new Livre("LC03","Python", "John Doe", "Thomas Edition", 100));
        bookList.add(new Livre("LC04","C#", "John Doe", "Thomas Edition", 100));
        bookList.add(new Livre("LC05","PHP", "John Doe", "Thomas Edition", 100));
        bookList.add(new Livre("LC06","PYTHON 2", "John Doe", "Thomas Edition", 100));
        // set books to request object and forward to JSP*/
        DaoLivre agent = new DaoLivre();
        agent.open();
        List<Livre> bookList = agent.getAll();
        agent.close();

        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("manageBooks.jsp").forward(req, resp);
    }
}

