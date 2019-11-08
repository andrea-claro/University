package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import model.UtenteDAO;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/AdminUsers")
public class AdminUsersServlet extends InitServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		checkAdmin(request);
		
		if(request.getParameter("operation") != null) {
			String str= (String)request.getParameter("operation");
			if(str.equalsIgnoreCase("edit")) {
				userDAO.doAdmin(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("message", "The user has been made admin.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
				requestDispatcher.forward(request, response);
			}
			else if(str.equalsIgnoreCase("remove")) {
				userDAO.doDelete(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("message", "The user has been deleted.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/adminusers.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
