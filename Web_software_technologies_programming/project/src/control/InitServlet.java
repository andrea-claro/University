package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Categoria;
import model.CategoriaDAO;
import model.OrdineDAO;
import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;
import model.UtenteDAO;

/**
 * @author Andrea Claro
 *
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected static ProdottoDAO productDAO = new ProdottoDAO();
	protected static CategoriaDAO categoryDAO= new CategoriaDAO();
	protected static UtenteDAO userDAO= new UtenteDAO();
	protected static OrdineDAO orderDAO= new OrdineDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Prodotto> products = productDAO.doRetrieveAll(0, 10);
		request.setAttribute("products", products);
		
		List<Categoria> categories= categoryDAO.doRetrieveAll();
		request.setAttribute("categories", categories);
		
		List<Utente> users= userDAO.doRetrieveAll(0, 10);
		request.setAttribute("users", users);
		
		super.service(request, response);
	}
	
	protected void checkAdmin(HttpServletRequest request) throws ServletException {
		Utente user= (Utente) request.getSession().getAttribute("utente");
		if (user == null || !user.isAdmin())
			throw new MyServletException("Utente non autorizzato");
	}

}
