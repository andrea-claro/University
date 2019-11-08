<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Utente, model.Categoria, java.util.List"%>

<% session= request.getSession();
   Utente user= (Utente) session.getAttribute("utente"); 
   List<Categoria> categories= (List<Categoria>) request.getAttribute("categories");%>
   

<!-- Starting point html -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="style/ground.css">
    <link rel="stylesheet" href="style/font.css">
    <link rel="stylesheet" href="style/navigator.css">
    
    <link rel="icon" type="image/ico" href="img/logue.png">

    <script src="script/developing/jquery.js"></script>
    <script src="script/navigator.js"></script>
    <script src="script/tabbedmenu.js"></script>
	
    <title>BOOZER- <%= request.getAttribute("pageTitle") %></title>
    
    <style type="text/css">
    	.bgimg {
			background-position: center;
    		background-size: cover;
    		background-image: url("img/bg.jpg");
    		min-height: 75%;
		}
    </style>
</head>

<body>


<!-- Toolbar Container -->
<section class="w3-top" id="toolbar">
	<nav class="w3-row w3-padding w3-black">
     	<ul id="nav">
       		<li>
             	<div class="w3-col s2">
             		<form action="Search" method="GET">
                   		<input class="w3-text w3-padding" list="searching" name="search" id="search" placeholder="Search" onkeyup="searchPress(this.value)">
                    	<datalist id="searching"></datalist>
                    </form>
                </div>
            </li>
            <li>
            	<div class="w3-col s2">
                  	<ul id="aboutlist">
                    	<a href="." class="w3-button w3-block w3-black">HOME</a>
                        <li>
                            <a href="./#about" class="w3-button w3-block w3-black">ABOUT</a>
                        </li>
                        <li>
                            <a href="./#message" class="w3-button w3-block w3-black">CONTACT US</a>   
                        </li>
                    </ul>
                </div>
          	</li>
           	<li>
          		<div class="w3-col s2">
               		<ul id="prodlist">
                        <a href="./#menu" class="w3-button w3-block w3-black">BOOZE</a>
                    	<%for(Categoria c: categories){ %>
                    	    <li>
                                <a href="Category?id=<%=c.getId() %>" class="w3-button w3-block w3-black"><%=c.getNome().toUpperCase() %></a>
                            </li>
                        <%} %>
                    </ul>
                </div>
     		</li>
            <li>
               	<div class="w3-col s2">
               		<ul>
                        <a href="Cart" class="w3-button w3-block w3-black">
                            <img src="img/cart.png" style="width:20px" >
                        </a>
               		</ul>
                </div>
            </li>
            <li>
            	<%if(user == null){ %>
                	<div class="w3-col s2">
                        <ul id="loglist">
                            <form action="Login" method="POST">
                               	<button class="w3-button w3-block w3-black" type="submit">LOGIN</button>
                                <li>
                                    <input class="w3-input" type="text" placeholder="Username" required name="user">
                                    <input class="w3-input" type="password" placeholder="Password" required name="pass">
                                </li>
                                <li>
                                    <a href="RegistrationForm" class="w3-button w3-block w3-black">REGISTRATION</a>
                                </li>
                            </form>
                      	</ul>
                 	</div>
                <%} 
				else { 
                 	if(user.isAdmin()){ %>
                        <div class="w3-col s2">
                            <ul id="loglist">
                                <button class="w3-button w3-block w3-black"><%= user.getUsername().toUpperCase() %></button>
                                <li>
                                    <a href="AdminCategory" class="w3-button w3-block w3-black">CATEGORIES</a>
                                </li>
                                <li>
                                    <a href="AdminProduct" class="w3-button w3-block w3-black">PRODUCTS</a>
                                </li>
                                <li>
                                    <a href="AdminUsers" class="w3-button w3-block w3-black">USERS</a>
                                </li>
                                <li>
                                    <a href="Orders?user=<%= user.getUsername()%>" class="w3-button w3-block w3-black">ORDERS</a>
                                </li>
                                <li>
                                    <form action="Logout">
                                        <button class="w3-button w3-block w3-black" type="submit">LOGOUT</button>
                                    </form>
                                </li>
                            </ul>
                       	</div>
                    <%}
                 	else{ %>                        
                        <div class="w3-col s2">
                            <ul id="loglist">
                                <button class="w3-button w3-block w3-black"><%= user.getUsername().toUpperCase() %></button>
                                <li>
                                    <a href="MyProfile?user=<%= user.getUsername()%>" class="w3-button w3-block w3-black">MY PROFILE</a>
                                </li>
                                <li>
                                    <a href="Orders?user=<%=user.getUsername() %>" class="w3-button w3-block w3-black">MY ORDERS</a>
                                </li>
                                <li>
                                    <form action="Logout">
                                        <button class="w3-button w3-block w3-black" type="submit">LOGOUT</button>
                                    </form>
                                </li>
                            </ul>
                        </div>
                    <%} } %>
           	</li>
       	</ul>
    </nav>
</section>