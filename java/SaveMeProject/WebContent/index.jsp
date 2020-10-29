<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	
	<!-- CSS Personalizado -->
	<link rel="stylesheet" type="text/css" href="css/personalizado.css">

	<!-- Informações da Página -->
    <title>SaveMe: Home</title>
	<link rel="shortcut icon" href="images/logoICO.png" type="image/x-icon"/>
  </head>
  
  <body>

	 <jsp:include page="Menu.jsp" />				
						
						
		<div class="container2">

		<div class="jumbotron">
			<h1 class="display-4">Bem-Vindo(a)!</h1>
			<p class="lead">Para pedir socorro, clique no botão vermelho abaixo.</p>
			<hr class="my-4">
			<p>Caso ainda não esteja logado ou possua uma conta em nosso sistema:</p>
			<a class="btn btn-primary btn-lg" href="RedirecionarCadastro" role="button">Cadastro</a>
		</div>
		
		<div class="card mx-auto">
			<a class="btn btn-danger btn-custom" href="ControleEnviarEmail"><i class="fas fa-exclamation-triangle fa-2x"></i></a>
		</div>
		
		<BR>
		<BR>
		<BR>
		<BR>
				
		</div>
	
	
		<jsp:include page="Rodape.html" />
	
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	
	<script src="https://kit.fontawesome.com/9b1e32f7a8.js"></script>
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="popper/popper.min.js" ></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>