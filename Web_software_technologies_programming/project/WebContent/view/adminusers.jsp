<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Utente, java.util.List, model.OrdineDAO" %>

<%List<Utente> utenti= (List<Utente>) request.getAttribute("users");
  OrdineDAO orderDAO= new OrdineDAO();%>


<!-- Menu toolbar -->
<% 	String pageTitle= "Users";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
    <br><br>
    

<!-- Table container -->
	<section class="w3-container">
        <div class="w3-content" style="max-width:800px">
            <h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide">USERS</span>
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
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%for(Utente u: utenti){ %>
                            <tr>
                                <td><%= u.getId() %></td>
                                <td><%= u.getUsername() %></td>
                                <td><%= u.getNome()%></td>
                                <td><%= u.getEmail()%></td>
                                <td><%= u.isAdmin()? "True" : "False" %></td>
                                <td><%= orderDAO.doRetrieveNumberByUser(u.getId()) %></td>
                                <%if(!u.isAdmin()) {%>
                                <td style="display: flex; flex-wrap: wrap">
                                    <form action="AdminUsers?operation=edit" method="post">
                                        <input type="hidden" name="id" value="<%= u.getId() %>">
                                        <button type="submit">Edit</button>
                                    </form>
                                    <form action="AdminUsers?operation=remove" method="post">
                                        <input type="hidden" name="id" value="<%= u.getId() %>">
                                        <button type="submit">Remove</button>
                                    </form>
                                </td>
                                <%} %>
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