<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Prodotto, model.Categoria, java.util.Base64"%>

<% Prodotto prod= (Prodotto)request.getAttribute("prod");%>


<!-- Menu toolbar -->
<%	String pageTitle= prod.getNome();
	request.setAttribute("pageTitle", pageTitle); %>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
	<br><br>
	
	
<!-- Product container -->
	<section class="w3-container">
        <div class="w3-content" style="max-width:700px">
        	<div class="w3-col s5" style="margin-top:20%">
        		<p>
        			<img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(prod.getImage()) %>" class="w3-image">
        		</p>
        	</div>
        	<div class="w3-col s5">
        		<p>
        			<h5 class="w3-center w3-padding-48">
                		<span class="w3-tag w3-wide"><%= prod.getNome() %></span>
            		</h5>
        		</p>
        		<p>
        			<span><%=prod.getDescrizione() %></span>
        		</p>
        		<p>
        			<span>Category:</span>
        			<span>
        				<a class="w3-button w3-black" href="Category?id=<%=prod.getCategoria().getId()%>"><%=prod.getCategoria().getNome()%></a>
        			</span>
        		</p>
        		<p>
        			<span>Price:</span>
        			<span>&euro;<%=prod.getPrice() %>,00</span>
        		</p>
        		<p>
        			<form action="Cart" method="POST">
        				<span>How many:</span>
        				<span>
        					<input class="w3-padding-16 w3-border" type="w3-number" value="1" min="1" max="99" required name="quantity">
        					<input type="hidden" name="prodId" value="<%= prod.getId()%>">
        					<button class="w3-button w3-black" type="submit">BUY!</button>
        				</span>
        			</form>
        		</p>
        	</div>
        </div>
     </section>
     

<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
				
</div>

</body>
</html>