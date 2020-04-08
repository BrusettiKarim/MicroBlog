/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Dao.UtenteDAO;
import com.google.common.base.Charsets;
import com.google.common.hash.*;
import entity.Utente;
import java.io.IOException;
import com.google.common.hash.Hasher;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;


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
            
            
            Random random = new SecureRandom();
            byte[] saltByte = new byte[16];
            random.nextBytes(saltByte);
            
            String salt = DatatypeConverter.printBase64Binary(saltByte);
            
            String PasswordSalt = password + salt;
            
            Hasher hasher = Hashing.sha256().newHasher();
            hasher.putString(PasswordSalt, Charsets.UTF_8);
            String sha256 = hasher.hash().toString();
            
            Utente u = new Utente();
            u.setUsername(name);
            u.setPassword(sha256);
            u.setSalt(salt);
            u.setEmail(email);
            UtenteDAO.create(u);

        } catch (Exception ex) {
            Logger.getLogger(RegistrazioneServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
