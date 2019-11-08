package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.Cart.ProdottoQuantita;
import model.ProdottoDAO;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/Cart")
public class CartServlet extends InitServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cart carrello= (Cart) session.getAttribute("carrello");
		if (carrello == null) {
			carrello = new Cart();
			session.setAttribute("carrello", carrello);
		}

		String prodIdStr = request.getParameter("prodId");
		if (prodIdStr != null) {
			int prodId = Integer.parseInt(prodIdStr);

			String addNumStr = request.getParameter("quantity");
			if (addNumStr != null) {
				int addNum = Integer.parseInt(addNumStr);

				ProdottoQuantita prodQuant = carrello.get(prodId);
				if (prodQuant != null) {
					prodQuant.setQuantita(prodQuant.getQuantita() + addNum);
				} else {
					carrello.put(productDAO.doRetrieveById(prodId), addNum);
				}
			} else {
				String setNumStr = request.getParameter("setNum");
				if (setNumStr != null) {
					int setNum = Integer.parseInt(setNumStr);
					if (setNum <= 0) {
						carrello.remove(prodId);
					} else {
						ProdottoQuantita prodQuant = carrello.get(prodId);
						if (prodQuant != null) {
							prodQuant.setQuantita(setNum);
						} else {
							carrello.put(productDAO.doRetrieveById(prodId), setNum);
						}
					}
				}
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/cart.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
