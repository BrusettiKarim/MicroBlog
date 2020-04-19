/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.CommentoDAO;
import Dao.PostDAO;
import Dao.UtenteDAO;
import entity.Commento;
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
public class SaveCommento extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String testo = request.getParameter("testo");
        String username = (String) request.getSession(false).getAttribute("username");
        Utente u = UtenteDAO.findUser(username);
        
        String postIdString = request.getParameter("postId");
        long postId = Long.parseLong(postIdString);
        Post p = PostDAO.findPost(postId);
        
        Commento c = new Commento ();
        c.setContenuto(testo);
        c.setUtente(u);
        c.setDataOra(new Date());
        c.setPost(p);
        
        CommentoDAO.create(c);
        
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("post.jsp").include(request, response);
    }

}
