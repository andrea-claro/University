<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>


<!-- Menu toolbar -->
<% 	String pageTitle= "Error!";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
	<br><br>
	
	
<!-- Message container -->
    <section class="w3-container">
        <div class="w3-content" style="max-width:700px">
            <h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide">Thank You!</span>
            </h5>
			<p>
				<%=exception.getMessage() %>
			</p>
		</div>
	</section>
	
	
<!-- End page content -->
	<%@ include file="footer.html" %>		
</div>

</body>
</html>