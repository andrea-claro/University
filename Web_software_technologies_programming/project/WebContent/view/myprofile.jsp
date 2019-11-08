<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Utente, model.UtenteDAO, model.OrdineDAO"%>

<%List<Utente> users= (List<Utente>) request.getAttribute("users");
  UtenteDAO utenteDAO= new UtenteDAO();
  Utente utente= utenteDAO.doRetrieveByUsername((String)request.getAttribute("username")); 
  OrdineDAO orderDAO= new OrdineDAO();%>

<!-- Menu toolbar -->
<%	String pageTitle= utente.getNome();
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
    
    
<!-- Table container -->
    <section class="w3-container">
        <div class="w3-content" style="max-width:700px">
            <h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide"><%=utente.getNome() %></span>
            </h5>
			<div class="w3-container w3-padding-48 w3-card">
                <div class="w3-content">
                    <table class="w3-table w3-hoverable w3-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Admin</th>
                                <th># orders</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<tr>
                                <td><%= utente.getId() %></td>
                                <td><%= utente.getUsername() %></td>
                                <td><%= utente.getNome()%></td>
                                <td><%= utente.getEmail()%></td>
                                <td><%= utente.isAdmin()? "True" : "False" %></td>
                                <td><%= orderDAO.doRetrieveNumberByUser(utente.getId()) %></td>
                            </tr>
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