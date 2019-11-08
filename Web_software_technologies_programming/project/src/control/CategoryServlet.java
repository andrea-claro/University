package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.Prodotto;
import model.ProdottoDAO;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/Category")
public class CategoryServlet extends InitServlet {
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		List<Prodotto> prodotti = productDAO.doRetrieveByCategoria(id, 0, 10);
		if(prodotti.isEmpty()) {
			request.setAttribute("message", "Right now there is no product in this category.");
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			request.setAttribute("category", prodotti);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/category.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
