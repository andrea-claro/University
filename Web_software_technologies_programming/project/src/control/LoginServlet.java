package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDAO;

/**
* @author Andrea Claro
*
*/
@WebServlet("/Login")

public class LoginServlet extends InitServlet {

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        
        Utente utente= null;

        if (username != null && password != null) {
            utente = userDAO.doRetrieveByUsernamePassword(username, password);
        }

        if (utente == null) {
            throw new MyServletException("Username e/o password non validi.");
        }
        
        request.getSession().setAttribute("utente", utente);

        String dest = request.getHeader("referer");
        if (dest == null || dest.contains("/Login") || dest.trim().isEmpty()) {
            dest = ".";
        }
        
        response.sendRedirect(dest); 
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

