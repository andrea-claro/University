package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;
import model.Utente;

/**
 * @author Andrea Claro
 *
 */
@WebServlet("/AdminProduct")
@MultipartConfig
public class AdminProductServlet extends InitServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		checkAdmin(request);
		
		if(request.getParameter("cat") != null) {
			int categ= Integer.parseInt(request.getParameter("cat"));
			ProdottoDAO prod= new ProdottoDAO();
			List<Prodotto> pr= prod.doRetrieveByCategoria(categ, 0, 10);
			String result= "<option value='null'>SELECT</option>";
			for(Prodotto e: pr) {
				result+= "<option value='"+e.getId()+"'>"+e.getNome()+"</option>";
			}
			response.getWriter().append(result);
		}
		
		else {
			if(request.getParameter("operation") != null) {
				String str= request.getParameter("operation");
				if( str.equalsIgnoreCase("add")) {
					Prodotto prodotto;
					String name = request.getParameter("name");
					String description = request.getParameter("description");
					String price = request.getParameter("price");
					int category = Integer.parseInt(request.getParameter("category"));
					Part filePart = request.getPart("url");
					InputStream image = filePart.getInputStream();
					ByteArrayOutputStream output = new ByteArrayOutputStream();
					byte[] buffer = new byte[10240];
					for (int length = 0; (length = image.read(buffer)) > 0;) 
						output.write(buffer, 0, length);
					
					prodotto = new Prodotto();
					prodotto.setNome(name);
					prodotto.setDescrizione(description);
					prodotto.setPrezzoCent(Long.parseLong(price));
					prodotto.setImage(output.toByteArray());

					CategoriaDAO cate= new CategoriaDAO();
					List<Categoria> cat= (List<Categoria>)cate.doRetrieveAll();
					for(Categoria c: cat) {
						if(category == c.getId()) {
							Categoria ctg= new Categoria();
							ctg.setId(c.getId());
							ctg.setNome(c.getNome());
							ctg.setDescrizione(c.getDescrizione());
							prodotto.setCategoria(ctg);
							productDAO.doSave(prodotto);
							request.setAttribute("message", "The product has been added.");
							
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
							requestDispatcher.forward(request, response);
							}
						}
				}
				else if(str.equalsIgnoreCase("remove")) {
					int id= Integer.parseInt(request.getParameter("product"));
					productDAO.doDelete(id);
					
					request.setAttribute("message", "The product has been removed.");
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/message.jsp");
					requestDispatcher.forward(request, response);
				}
			} 
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/adminproduct.jsp");
			requestDispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
