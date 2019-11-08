<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!-- Menu toolbar -->
<% 	String pageTitle= "Registration";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ include file="header.jsp" %>


<!-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">
	<br><br>
	

<!-- Registration container -->
	<section class="w3-container">
        <div class="w3-content" style="max-width:800px">
        	<h5 class="w3-center w3-padding-48">
                <span class="w3-tag w3-wide">REGISTRATION</span>
            </h5>
			<div class="w3-container w3-padding-48 w3-card">
                <div class="w3-content">
                	<p>
                		<span>
                			<strong>Fill every field please</strong>
                		</span>
                	</p>
                	<p>
                		<form action="Registration" method="POST" name="registration">
                			<span>Username (min 6 characters, only letters and numbers; the username has to be unique)</span>
                			<span>
                				<input class="w3-input w3-padding-16" type="w3-text" placeholder="Username.." name="username" oninput="validaUsername()">
                			</span>
                			<span>Password (min 8 characters; at least a lowercase and an uppercase letter, a number)</span>
                			<span>
                				<input class="w3-input w3-padding-16" type="password" placeholder="Password.." name="password" oninput="validaPassword()">
                			</span>
                			<span>Password (confirm)</span>
                			<span>
                				<input class="w3-input w3-padding-16" type="password" placeholder="Password.." name="passwordConferma" oninput="validaPassword()">	
                			</span>
                			<span>Name (only letters and spaces)</span>
                			<span>
                				<input class="w3-input w3-padding-16" type="w3-text" placeholder="Name.." name="nome" oninput="validaNome()">
                			</span>
                			<span>E- mail (has to be unique)</span>
                			<span>
                				<input class="w3-input w3-padding-16" type="w3-text" placeholder="pippo@pippo.pippo" name="email" oninput="validaEmail()">		
                			</span>
                			<span>
                				<button class="w3-button w3-black" id="registrami" type="submit" disabled>REGISTER</button>
                			</span>
                			<span id="registramimessaggio"></span>	
						</form>
                	</p>
				</div>
			</div>
		</div>
	</section>


	<script>
		var borderOk = '2px solid #080';
		var borderNo = '2px solid #f00';
		var usernameOk = false;
		var passwordOk = false;
		var nomeOk = false;
		var emailOk = false;
	
		function validaUsername() {
			var input = document.forms['registration']['username'];
			if (input.value.length >= 6 && input.value.match(/^[0-9a-zA-Z]+$/)) {
				// verifica se esisten un utente con lo stresso username
				var xmlHttpReq = new XMLHttpRequest();
				xmlHttpReq.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200
							&& this.responseText == '<ok/>') {
						usernameOk = true;
						input.style.border = borderOk;
					} else {
						input.style.border = borderNo;
						usernameOk = false;
					}
					cambiaStatoRegistrami();
				}
				xmlHttpReq.open("GET", "VerificaUsername?username="
						+ encodeURIComponent(input.value), true);
				xmlHttpReq.send();
			} else {
				input.style.border = borderNo;
				usernameOk = false;
				cambiaStatoRegistrami();
			}
		}
	
		function validaPassword() {
			var inputpw = document.forms['registration']['password'];
			var inputpwconf = document.forms['registration']['passwordConferma'];
			var password = inputpw.value;
			if (password.length >= 8 && password.toUpperCase() != password
					&& password.toLowerCase() != password && /[0-9]/.test(password)) {
				inputpw.style.border = borderOk;
	
				if (password == inputpwconf.value) {
					inputpwconf.style.border = borderOk;
					passwordOk = true;
				} else {
					inputpwconf.style.border = borderNo;
					passwordOk = false;
				}
			} else {
				inputpw.style.border = borderNo;
				inputpwconf.style.border = borderNo;
				passwordOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function validaNome() {
			var input = document.forms['registration']['nome'];
			if (input.value.trim().length > 0
					&& input.value.match(/^[ a-zA-Z\u00C0-\u00ff]+$/)) {
				input.style.border = borderOk;
				nomeOk = true;
			} else {
				input.style.border = borderNo;
				nomeOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function validaEmail() {
			var input = document.forms['registration']['email'];
			if (input.value.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w+)+$/)) {
				input.style.border = borderOk;
				emailOk = true;
			} else {
				input.style.border = borderNo;
				emailOk = false;
			}
			cambiaStatoRegistrami();
		}
	
		function cambiaStatoRegistrami() {
			if (usernameOk && passwordOk && nomeOk && emailOk) {
				document.getElementById('registrami').disabled = false;
				document.getElementById('registramimessaggio').innerHTML = '';
			} else {
				document.getElementById('registrami').disabled = true;
				document.getElementById('registramimessaggio').innerHTML = 'Verifica che tutti i campi siano in verde.';
			}
		}
	</script>
	
	
<br>
<!-- End page content -->
	<%@ include file="footer.html" %>
</div>

</body>
</html>