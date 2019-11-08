package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.Prodotto;
import model.ProdottoDAO;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/Search")
public class SearchServlet extends InitServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("str") != null) {
			String str= request.getParameter("str");
			JSONArray prodJson = new JSONArray();

			if(str != null) {
				List<Prodotto> prodotti = productDAO.doRetrieveByMatch(str+"*", 0, 5);
				for(Prodotto p: prodotti)
						prodJson.put(p.getNome());
			}
			response.setContentType("application/json");
			response.getWriter().append(prodJson.toString());
		}
		else {
			List<Prodotto> prodotti = productDAO.doRetrieveByMatch(request.getParameter("search"), 0, 10);
			if(prodotti.isEmpty()) {
				request.setAttribute("message", "There is no match.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				request.setAttribute("search", request.getParameter("search"));
				request.setAttribute("prodotti", prodotti);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/search.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
