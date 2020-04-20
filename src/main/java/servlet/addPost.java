/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.UtenteDAO;
import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karim
 */
public class addPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession(false) != null) {
            String username = (String)request.getSession(false).getAttribute("username"); 
            Utente u = UtenteDAO.findUser(username);
            if (u.getRuolo().equals("ADMIN")) {
            request.getRequestDispatcher("addpost.html").include(request, response);
            }
            else {
                request.getRequestDispatcher("alert.html").include(request, response);
            }
        }
    }
}