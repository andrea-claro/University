<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Utente, java.util.List, model.Categoria" %>

<%List<Utente> utenti= (List<Utente>) request.getAttribute("users");
  List<Categoria> cat= (List<Categoria>) request.getAttribute("categories");%>

<!-- Menu toolbar -->
<% 	String pageTitle= "Editing products";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
        

<!-- Menu Container -->
	<section class="w3-container" id="menu">
		<div class="w3-content" style="max-width:700px">
			<h5 class="w3-center w3-padding-48">
				<span class="w3-tag w3-wide">EDIT</span>
			</h5>
        	<div class="w3-row w3-center w3-card w3-padding">
        		<a href="javascript:void(0)" onclick="openMenu(event, 'add');" id="myLink">
            		<div class="w3-col s6 tablink">ADD PRODUCT</div>
            	</a>
            	<a href="javascript:void(0)" onclick="openMenu(event, 'remove');" id="myLink">
            		<div class="w3-col s6 tablink">REMOVE PRODUCT</div>
            	</a>
        	</div>
        	<div id="add" class="w3-container menu w3-padding-48 w3-card">
        		<div class="w3-content">
					<form action="AdminProduct?operation=add" method="POST" enctype="multipart/form-data">
                        <p>
                            <strong>Category</strong>
                            <%for(Categoria c: cat){ %> 
                                <label>
                                    <input type="radio" required name="category" value="<%= c.getId() %>">
                                    <%=c.getNome().toUpperCase() %>
                                </label>
                            <%} %>
                        </p>
                        <p>
                            <strong>Name</strong>
                            <input class="w3-input w3-padding-16 w3-border" type="w3-text" placeholder="Name" required name="name">
                        </p>
                        <p>
                            <strong>Description</strong>
                            <textarea class="w3-input w3-padding-16 w3-border" type="w3-text" placeholder="Description.." required name="description"></textarea>
                        </p>
                        <p>
                            <strong>Price</strong>
                            <input class="w3-padding-16 w3-border" type="w3-number" placeholder="Price" required name="price">
                        </p>
                        <p>
                        	<strong>Image</strong>
                        	<input class="w3-padding-16 w3-border" type="file" required name="url">
                        </p>
                        <br>
						<button class="w3-button w3-black" type="submit">ADD</button>
					</form>
				</div>
        	</div>
        	<div id="remove" class="w3-container menu w3-padding-48 w3-card">
        		<div class="w3-content">
					<form action="AdminProduct?operation=remove" method="POST">
                        <p>
                            <strong>Category</strong>
                            <select class="w3-input w3-padding-16 w3-border" required name="category" onchange="getProd(this.value)">
                                    <option value="null">SELECT</option>
                                    <%for(Categoria c: cat){ %> 
                                    <option value="<%= c.getId()%>"><%= c.getNome().toUpperCase() %></option>
                                    <%} %>
                            </select>
                        </p>
                        <p>
                            <strong>Product</strong>
                            <select class="w3-input w3-padding-16 w3-border" required name="product" id="products"></select>
                        </p>
						<br>
						<button class="w3-button w3-black" type="submit">REMOVE</button>
					</form>
				</div>
        	</div>
        </div>
	</section>


<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
				
</div>

<script>
    document.getElementById("myLink").click();
    
    function getProd(cat) {
    	if(cat != "null"){
    		var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("products").innerHTML =
                    this.responseText;
               }
            };
    	}
    	else{
    		document.getElementById("products").innerHTML = "";
    	}
        
        xhttp.open("POST", "AdminProduct?cat="+cat, true);
        xhttp.send();
    }
</script>

</body>
</html>