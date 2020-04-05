/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.UserDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karim
 */
@WebServlet(name = "RegistrazioneServlet", urlPatterns = {"/RegistrazioneServlet"})

public class RegistrazioneServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            request.getRequestDispatcher("index.html").include(request, response);

            String name = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            
            User u = new User();
            u.setUsername(name);
            u.setPassword(password);
            u.setEmail(email);
            u.setSalt("udhaiuadhiahidhhiuadhiua");
            UserDAO.create(u);
            
        } catch (Exception ex) {
            Logger.getLogger(RegistrazioneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        }
}

