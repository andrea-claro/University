package control;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import model.Cart.ProdottoQuantita;
import model.Ordine;
import model.OrdineDAO;
import model.Utente;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/Buying")
public class BuyingServlet extends InitServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("utente") != null) {
			Utente user= (Utente)request.getSession().getAttribute("utente");
			Cart cart= (Cart)request.getSession().getAttribute("carrello");
            for(ProdottoQuantita pq: cart.getProdotti()){ 
            	Ordine order= new Ordine();
            	order.setProduct(pq.getProdotto());
            	order.setQuantity(pq.getQuantita());
            	order.setPrice(pq.getPrice());
     
            	orderDAO.doSave(order, user);
            }
            request.getSession().setAttribute("carrello", new Cart());
            
            request.setAttribute("message", "Your order is being paid.");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "You have to log in and then buy..");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
