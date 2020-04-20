package servlet;


import Dao.UtenteDAO;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.google.common.hash.Hasher;
import entity.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("index.html").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        
        Utente utente = UtenteDAO.findUser(name);
        
        String salt = utente.getSalt();

        String PasswordSalt = password + salt;
        
  
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(PasswordSalt, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();

        
        if (sha256.equals(utente.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            request.setAttribute("username", name);
            
        } else {
            out.print("Sorry, username or password error!");
            request.getRequestDispatcher("login.html").include(request, response);
        }
        out.close();
      
    }
}