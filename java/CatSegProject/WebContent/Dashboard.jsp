<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="./styles/Global.css">
        <link rel="stylesheet" href="./styles/Dashboard.css">
        <!-- Configs -->
        <link rel="shortcut icon" href="./assets/page/icon.svg" type="image/x-icon"/>
        <title>Dashboard</title>
    </head>
    <body>
    	<%  String adminName = "ADMIN";
    		HttpSession newSession = request.getSession();
			if(session.getAttribute("adminName") == null){
				response.sendRedirect("ControllerRedirectSignIn");
			}
			else{
				adminName = (String)session.getAttribute("adminName");
			}
		%>
        <div id="page-dashboard">
            <div>
                <nav class="navbar navbar-dark bg-dark">
                    <span class="navbar-text">CatSeg</span>
                    <span class="navbar-text">Welcome, <%=adminName%></span>
                </nav>
            </div>
            <div class="container">
            	<h2>Dashboard</h2>
            	<div class="buttons-dashboard">
            		<a class="btn btn-danger" href="ControllerLogoutAdministrador">
            			<img src="./assets/bootstrap-icons-1.0.0/door-open.svg" alt="Plus" width="24" height="24" title="Logout">	
            		</a>
            		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#add-employee">
            		 	<img src="./assets/bootstrap-icons-1.0.0/plus.svg" alt="Plus" width="24" height="24" title="Adicionar Funcionários">	
            		</button>
            	</div>
                <table class="table table-hover">
  					<thead>
    					<tr>
      						<th scope="col">ID</th>
      						<th scope="col">Name</th>
      						<th scope="col">Email</th>
      						<th scope="col">Telephone</th>
      						<th scope="col">CPF</th>
      						<th scope="col">Actions</th>
    					</tr>
  					</thead>
  					<tbody>
  						<c:forEach items="${ListaFuncionarios}" var="funcionario">
  							<tr>
      							<th scope="row">${funcionario.getFuncionarioID()}</th>
      							<td>${funcionario.getFuncionarioName()}</td>
      							<td>${funcionario.getFuncionarioEmail()}</td>
      							<td>${funcionario.getFuncionarioTelefone()}</td>
      							<td>${funcionario.getFuncionarioCPF()}</td>
      							<td>
      								<button type="submit" class="btn" data-toggle="modal" data-target="#watch-employee" data-whatever="<c:out value="${funcionario.getFuncionarioID()}"></c:out>" data-whatevername="<c:out value="${funcionario.getFuncionarioName()}"></c:out>">
											<img src="./assets/bootstrap-icons-1.0.0/eye-fill.svg" alt="Eye" width="24" height="24" title="Visualizar Indicadores">
      							    </button>
      							    <button type="button" class="btn" data-toggle="modal" data-target="#delete-employee" data-whatever="<c:out value="${funcionario.getFuncionarioID()}"></c:out>">
      							    	<img src="./assets/bootstrap-icons-1.0.0/trash-fill.svg" alt="Trash" width="24" height="24" title="Apagar Funcionário">	
      							    </button>						         							
      							</td>
    						</tr>
  						</c:forEach>
  					</tbody>
				</table>
            </div>
        </div>

		<!-- Include Custom Pages -->
		<jsp:include page="PopUps.html" />
        <!-- jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
     	<script src="./js/functions.js"></script>
  </body>
</html>