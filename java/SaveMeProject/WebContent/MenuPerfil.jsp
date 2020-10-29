<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List, Dados.Contatos, Dados.Usuario" %>
<html lang="pt-br">
<head>
<style type="text/css">
#SaveMe{
position:absolute;
left:45%;
}
</style>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta charset="utf-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>

<nav class="navbar navbar-fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
        <div class="container">
 		 	<a class="navbar-brand" href="index.jsp"><i class="fas fa-heartbeat fa-2x"></i> SaveMe</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div id="SaveMe">
            	<a class="btn btn-light btn-custom" href="ControleEnviarEmail"><i class="fas fa-exclamation-triangle fa-2x"></i></a>
			</div>
			
            <div class="collapse navbar-collapse" id="navbar">
                <ul class="navbar-nav ml-auto"> 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${loginUsuario}
                        </a>
                  
                        <div  class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a href="ControleLogout" class="dropdown-item">Sair</a>
                        </div>
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