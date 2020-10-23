<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <link rel="shortcut icon" href="./assets/icon.svg" type="image/x-icon"/>
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
            	<div class="buttons-dashboard">
            		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#add-employee">Add Employee</button>
            		<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#delete-employee">Delete Employee</button>
            		<a class="btn btn-danger" href="ControllerLogoutAdministrador">Logout</a>
            	</div>
                <table class="table table-hover">
  					<thead>
    					<tr>
      						<th scope="col">ID</th>
      						<th scope="col">Name</th>
      						<th scope="col">Email</th>
      						<th scope="col">Telephone</th>
      						<th scope="col">CPF</th>
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
    						</tr>
  						</c:forEach>
  					</tbody>
				</table>
            </div>
        </div>

		<!-- Include Custom Pages -->
		<jsp:include page="Employee.html" />
        <!-- jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  </body>
</html>