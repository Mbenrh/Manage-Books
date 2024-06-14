package org.example.controller;

import org.example.dao.DaoLivre;
import org.example.models.Livre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/supprimerLivre")
public class SupprimerLivre extends HttpServlet {

    public  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("idl"));
        DaoLivre agent = new DaoLivre();
        agent.open();
        Livre livre = agent.get(id);
        if(livre == null) {
            agent.close();
            response.getWriter().println("Book not found with id :  " + id);
        }
        else {
            agent.delete(livre);
            agent.close();
            response.sendRedirect("./manageBooks");
        }
    }
}
