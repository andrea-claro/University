package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;
import model.OrdineDAO;
import model.Utente;
import model.UtenteDAO;


@WebServlet("/Orders")
public class OrdersServlet extends InitServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("user") != null) {
			Utente user= userDAO.doRetrieveByUsername(request.getParameter("user"));
			if(user.isAdmin() == true) {
				List<Ordine> orders= (List<Ordine>)orderDAO.doRetrieveAll(0, 10);
				request.setAttribute("orders", orders);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/orders.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				List<Ordine> orders= (List<Ordine>)orderDAO.doRetrieveByUser(user.getId(), 0, 10);
				request.setAttribute("orders", orders);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/orders.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("message", "You have to log in first.");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
