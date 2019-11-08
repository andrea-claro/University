<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Prodotto, model.Categoria, java.util.Base64"%>

<% List<Prodotto> prod= (List<Prodotto>)request.getAttribute("category");%>


<!-- Menu toolbar -->
<%	String pageTitle= prod.get(0).getCategoria().getNome();
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
    
    
<!-- Product container -->
    <section class="w3-container">
        <div class="w3-content" style="max-width:700px">
            <h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide"><%=prod.get(0).getCategoria().getNome().toUpperCase() %></span>
            </h5>
            <%for(Prodotto p: prod){ %>
            <div class="w3-container w3-padding-48 w3-card">
                <div class="w3-content">
                    <div class="w3-col s5">
                        <p>
                            <a href="Product?id=<%= p.getId() %>">
                                <img src="data:image/jpg;base64,<%=Base64.getEncoder().encodeToString(p.getImage()) %>" class="w3-image" style="width:100%;max-width:300px">
                            </a>
                        </p>
                    </div>
                    <div class="w3-col s5">
                        <p>
                            <a class="w3-tag w3-wide" href="Product?id=<%= p.getId() %>"><%= p.getNome() %></a>					
                        </p>
                        <p>
                            <span>Category:</span>
                            <span>
                                <a href="Category?id=<%=p.getCategoria().getId()%>" class="w3-button w3-black"><%=p.getCategoria().getNome()%></a>
                            </span>
                            <br>
                            <span>Price: &euro;<%=p.getPrice() %>,00</span>
                        </p>
                        <p>
                            <span>
                                <a href="Product?id=<%= p.getId()%>" class="w3-button w3-black">See the product</a>
                            </span>
                        </p>
                    </div>
                </div>
            </div>
            <br>
            <%} %>
        </div>
    </section>


<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
</div>		

</body>
</html>