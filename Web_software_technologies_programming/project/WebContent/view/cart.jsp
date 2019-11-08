<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Prodotto, model.Cart, model.Cart.ProdottoQuantita, java.util.Base64"%>
   
<% Cart cart= (Cart)session.getAttribute("carrello");%>
 

<!-- Menu toolbar -->
<% 	String pageTitle= "Cart";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
    

<!-- Product container -->
    <section class="w3-container">
    	<h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide">CART</span>
        </h5>
        <div class="w3-content" style="max-width:960px; display: flex; flex-wrap: wrap">
            <%for(ProdottoQuantita pq: cart.getProdotti()){ %>
            <div class="w3-container w3-padding-48 w3-card" style="max-width:300px; margin:10px">
                <div class="w3-content">
                    <div class="w3-col s5">
                        <p>
                            <a href="Product?id=<%= pq.getProdotto().getId() %>">
                                <img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(pq.getProdotto().getImage()) %>" class="w3-image" style="width:100%;max-width:300px">
                            </a>
                        </p>
                    </div>
                    <div class="w3-col s5">
                        <p>
                            <a class="w3-tag w3-wide" href="Product?id=<%= pq.getProdotto().getId() %>"><%=pq.getProdotto().getNome().toUpperCase() %></a>					
                        </p>
                        <p>
                            <span>
                                How many:<%= pq.getQuantita() %>
                            </span>
                            <br><br>
                            <span>
                                Price each: &euro;<%= pq.getProdotto().getPrice() %>,00
                            </span>
                            <br><br>
                            <span>
                                Tot price: &euro;<%= pq.getQuantita()*pq.getProdotto().getPrice() %>,00
                            </span>
                        </p>
                        <p>
                        	<form action="Cart" method="POST">
                            	<input type="hidden" name="prodId" value="<%= pq.getProdotto().getId() %>">
                                <input type="hidden" name="setNum" value="0">
                                <button class="w3-button w3-black" type="submit">REMOVE</button>
                            </form>
                        </p>
                    </div>
                </div>
            </div>
            <br>
            <%} 
            if(cart.getProdotti().isEmpty()){ %>
                <p>
                    <strong>No product in the cart</strong>
                </p>
            <%}
            else { %>
          </div> 
                <div class="w3-content">            	        <p>
                        <span><strong>Tot:</strong></span>
                        <span><%=cart.getPrice() %> &euro;</span>
                        <form action="Buying" method="POST">
                            <button class="w3-button w3-black" type="submit">BUY!</button>
                        </form>
                    </p>
                </div>
            <%} %>
    </section>
          

<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
</div>

</body>
</html>