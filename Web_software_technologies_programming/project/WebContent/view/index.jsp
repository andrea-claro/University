<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Prodotto, model.Categoria, model.ProdottoDAO"%>

<% ProdottoDAO productDAO= new ProdottoDAO(); %>


<!-- Menu toolbar -->
<% 	String pageTitle= "Home";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Header with image -->
<header class="bgimg w3-display-container w3-grayscale-min" id="header">
	<div class="w3-display-bottomleft w3-center w3-padding-large w3-hide-small">
        <span class="w3-tag">Open from 9am to 6pm</span>
    </div>
    <div class="w3-display-middle w3-center">
        <span class="w3-text-sand" style="font-size:90px">The<br>Boozer</span>
    </div>
    <div class="w3-display-bottomright w3-center w3-padding-large">
        <span class="w3-text-white">18 Charteris Road, NW6 7ET</span>
    </div>
</header>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">


<!-- About Container -->
	<section class="w3-container" id="about">
		<div class="w3-content" style="max-width:700px">
    		<h5 class="w3-center w3-padding-64">
    			<span class="w3-tag w3-wide">ABOUT THE BOOZER</span>
    		</h5>
        	<p>'The Boozer' is a cocktail bar and a online-booze reseller founded in the small and rural town of Alesamsheshe.</p>
        	<div class="w3-panel w3-leftbar w3-light-grey">
        		<p>
        			<i>"A drunk man’s words are a sober man’s thoughts.", be drunk and enjoy</i>
        		</p>
            	<p>Chef and Owner: Andrea Claro</p>
        	</div>
        	<img src="img/bar.jpg" style="width:100%;max-width:1000px" class="w3-margin-top">
        	<p><strong>Opening hours:</strong> everyday from 9am to 6pm.</p>
            <p><strong>Address:</strong>18 Charteris Road, NW6 7ET</p>
		</div>
	</section>
    
    
<!-- Menu Container -->
	<section class="w3-container" id="menu">
		<div class="w3-content" style="max-width:700px">
			<h5 class="w3-center w3-padding-48">
				<span class="w3-tag w3-wide">THE BOOZE</span>
			</h5>
        	<div class="w3-row w3-center w3-card w3-padding">
        		<%for(Categoria c: categories){ %>
        			<a href="javascript:void(0)" onclick="openMenu(event, '<%=c.getNome() %>');" id="myLink">
            			<div class="w3-col s6 tablink"><%=c.getNome().toUpperCase() %></div>
            		</a>
        		<%}%>
        	</div>
			
			<%for(Categoria c: categories){ %>
        		<div id="<%=c.getNome() %>" class="w3-container menu w3-padding-48 w3-card">
        		<%List<Prodotto> products= (List<Prodotto>)productDAO.doRetrieveByCategoria(c.getId(), 0, 10); %>
        		<% for(Prodotto p: products){
					if(p.getCategoria().getNome().equals(c.getNome())){%>
						<a href="Product?id=<%=p.getId() %>" class="w3-button w3-block">
            				<h5><%=p.getNome() %></h5>
<%--                 			<article class="w3-text-grey"><%=p.getDescrizione() %></article> --%>
                	  	</a>
                	 <%}%>
                <%} %>
        	 	</div>
        	<%}%>
        	<img src="img/drink.jpg" style="width:100%;max-width:1000px;margin-top:32px;">
        </div>
	</section>


<!-- Contact/Area Container -->
    <section class="w3-container" id="where" style="padding-bottom:32px;">
        <div class="w3-content" style="max-width:700px">
            <h5 class="w3-center w3-padding-48">
            	<span class="w3-tag w3-wide">WHERE TO FIND US</span>
            </h5>
            <p>Find us always at the same spot.</p>
            <img src="img/map.jpg" class="w3-image" style="width:100%">
            <p><span class="w3-tag">FYI!</span> We offer full-shopping possibilities, and a place where to relax and enjoy the nicer drink. We understand your needs and we will cater the booze to satisfy the biggest criteria, both look and taste.</p>  
            <p><strong>Reserve</strong> a table, ask for today's special or just send us a message:</p>
			<form action="Message" target="_blank" id="message" method="POST">
                <p>
                	<input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Name" required name="name">
                </p>
                <p>
                	<input class="w3-input w3-padding-16 w3-border" type="number" placeholder="How many people" required name="number">
                </p>
                <p>
                	<input class="w3-input w3-padding-16 w3-border" type="datetime-local" placeholder="Date and time" required name="date" value="2017-11-16T20:00">
                </p>
                <p>
                	<input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Message \ Special requirements" required name="message">
                </p>
                <p>
                	<button class="w3-button w3-black" type="submit">SEND MESSAGE</button>
                </p>
            </form>
        </div>
    </section>


<!-- End page content -->
	<%@ include file="footer.html" %>
</div>

<script>
    document.getElementById("myLink").click();
</script>

</body>
</html>