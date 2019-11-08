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
import model.CategoriaDAO;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/AdminCategory")
public class AdminCategoryServlet extends InitServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		checkAdmin(request);
		
		if(request.getParameter("operation") != null) {
			String str= request.getParameter("operation");
			if(str.equalsIgnoreCase("add")) {
				Categoria category= new Categoria();
				String name = request.getParameter("name");
				String description = request.getParameter("description");
				category.setNome(name);
				category.setDescrizione(description);

				categoryDAO.doSave(category);
				
				request.setAttribute("message", "The category has been added.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
				requestDispatcher.forward(request, response);
			}
			else if(request.getParameter("operation").equalsIgnoreCase("remove")) {

				int id= Integer.parseInt(request.getParameter("category"));
				categoryDAO.doDelete(id);
				
				request.setAttribute("message", "The category has been removed.");
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/admincategory.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
