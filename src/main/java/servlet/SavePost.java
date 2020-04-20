/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.PostDAO;
import Dao.UtenteDAO;
import entity.Post;
import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karim
 */
public class SavePost extends HttpServlet {

    
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String titolo = request.getParameter("titolo");
        String testo = request.getParameter("post");
        String username = (String) request.getSession(false).getAttribute("username");
        Utente u = UtenteDAO.findUser(username);
        
        Post p = new Post();
        p.setContenuto(testo);
        p.setTitolo(titolo);
        p.setUtente(u);
        p.setDataOra(new Date());
        
        PostDAO.create(p);
        
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("post.jsp").include(request, response);
    }
}
