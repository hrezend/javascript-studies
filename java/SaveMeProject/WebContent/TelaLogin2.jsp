<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<!-- CSS Personalizado -->
	<link rel="stylesheet" type="text/css" href="css/personalizado.css">

	<!-- Informações da Página -->
    <title>SaveMe: Login</title>
	<link rel="shortcut icon" href="images/logoICO.png" type="image/x-icon"/>
  </head>
  
  <body>
  		<nav class="navbar navbar-fixed-top navbar-expand-lg navbar-dark bg-primary">
 	
 		<div class="container">
 		 <a class="navbar-brand" href="index.jsp"><i class="fas fa-heartbeat fa-2x"></i> SaveMe</a>
 		 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSite"><span class="navbar-toggler-icon"></span></button>	
	 	</div>
		</nav>
						<%
					HttpSession newSession=request.getSession();

					if(session.getAttribute("loginUsuario") != null){
					response.sendRedirect("RedirecionarPerfil");
					}
					%>
	<div class="container2">
		<div class="container3">
	<p class="h2">Login</p>
	<br>
		<%String situacao = (String) request.getAttribute("situacao"); %>
		<%
		if(situacao.equals("1")){%>
		<div class="alert alert-info alert-dismissible fade show" role="alert">
			<% String mc = (String)request.getAttribute("mc");%>	
       		<strong><%=mc%></strong>
       		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
		<%}%>
	
		<%if(situacao.equals("2")){%>
		<div class="alert alert-danger alert-dismissible fade show" role="alert">
			<% String me = (String)request.getAttribute("me");%>	
       		<strong><%=me%></strong>
       		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		</div>
		<%}%>
	
	<form class="px-4 py-3" action="ControleLogin" method="post">
		<div class="form-group">
			<label>Login</label>
			<input type="text" class="form-control" placeholder="Login" name="login">
		</div>
		<div class="form-group">
			<label>Senha</label>
			<input type="password" class="form-control" placeholder="•••••" name="senha">
		</div>
		<div class="form-group">
		<div class="form-check">
			<input type="checkbox" class="form-check-input">
			<label class="form-check-label"> Lembre-me </label>
		</div>
		</div>
				<button type="submit" class="btn btn-primary">Logar</button>
	</form>
		<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="RedirecionarCadastro">Não possui uma conta? Registrar</a>
			<a class="dropdown-item" href="#">Esqueceu sua senha?</a>
	
		</div>
	</div>
	
	
	<jsp:include page="Rodape.html" />
	
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="popper/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>

  </body>
</html>