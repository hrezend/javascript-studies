<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  </head>
  
  <body>	
	
	
	  	<nav class="navbar navbar-fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
 	
 		<div class="container">
 		 	 <a class="navbar-brand" href="index.jsp"><i class="fas fa-heartbeat fa-2x"></i> SaveMe</a>
 			 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite"><span class="navbar-toggler-icon"></span></button>	
	 	 <div class="collapse navbar-collapse" id="navbarSite">
	 		 <ul class="navbar-nav ml-auto">
	 		 	<li class = "nav-item">
	 		 		<%
					HttpSession newSession=request.getSession();

					if(session.getAttribute("loginUsuario") != null){%>
						<a class="nav-link" href="RedirecionarPerfil">${loginUsuario}</a>
					<%}
					else{%>
						<a class="nav-link" href="RedirecionarLogin">Login</a>
					<%}%>
	 		 	</li>
	 		 </ul> 	
	 	 </div>
	 	</div>
	</nav>
	<br>
	<br>
	
	
	

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    
	<script src="https://kit.fontawesome.com/9b1e32f7a8.js"></script>
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="popper/popper.min.js" ></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>