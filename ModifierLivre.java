package org.example.controller;

import org.example.dao.DaoLivre;
import org.example.models.Livre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/modifierLivre")
public class ModifierLivre extends HttpServlet {


    public  void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        // get book from database
        DaoLivre agent = new DaoLivre();
        agent.open();
        Livre livre = agent.get(id);
        agent.close();

        request.setAttribute("livre", livre);
        request.getRequestDispatcher("editBook.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("isbn"));

        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        String editeur = request.getParameter("editeur");
        double prix = Double.parseDouble(request.getParameter("prix"));

        DaoLivre agent = new DaoLivre();
        agent.open();
        Livre livre = agent.get(id);

        livre.setTitre(titre);
        livre.setAuteur(auteur);
        livre.setEditeur(editeur);
        livre.setPrix(prix);

        agent.update(livre);
        agent.close();
        response.sendRedirect("./manageBooks");

        // update book in database
       // Livre livre = new Livre(id, titre, auteur, editeur, prix);
        // LivreDao.updateLivre(livre);

        // confirmer la modification du livre
       // response.getWriter().println("Les détails du livre aprés modification :  "+livre.toString());
    }
}
