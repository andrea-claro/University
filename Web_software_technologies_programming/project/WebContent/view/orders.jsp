<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Utente, java.util.List, model.Ordine, model.ProdottoDAO, java.util.Base64" %>

<%List<Utente> utenti= (List<Utente>) request.getAttribute("users");
  List<Ordine> orders= (List<Ordine>) request.getAttribute("orders");
  ProdottoDAO productDAO= new ProdottoDAO(); %>


<!-- Menu toolbar -->
<% 	String pageTitle= "Orders";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
    

<!-- Table container -->
	<section class="w3-container">
        <div class="w3-content" style="max-width:800px">
            <h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide">ORDERS</span>
            </h5>
            <div class="w3-container w3-padding-48 w3-card">
                <div class="w3-content">
                    <table class="w3-table w3-hoverable w3-bordered">
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Product Name</th>
                                <th>Product Photo</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%for(Ordine o: orders) {%>
                        	<tr>
                                <td><%= o.getId() %></td>
                                <td><%= productDAO.doRetrieveById(o.getIdproduct()).getNome() %></td>
                                <td>
                                	<img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(productDAO.doRetrieveById(o.getIdproduct()).getImage()) %>" class="w3-image" style="width:100%;max-width:100px">
                                </td>
                                <td><%= o.getQuantity()%></td>
                                <td><%= o.getPrice() %></td>
                            </tr>
                        	<%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    
	
<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
				
</div>

</body>
</html>