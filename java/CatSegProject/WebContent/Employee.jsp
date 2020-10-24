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
        <link rel="stylesheet" href="./styles/Employee.css">
        <!-- Configs -->
        <link rel="shortcut icon" href="./assets/page/icon.svg" type="image/x-icon"/>
        <title>Employee</title>
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
			String id = (String)request.getAttribute("funcionarioID");	
			String name = (String)request.getAttribute("funcionarioName");
			String setor = (String)request.getAttribute("setor");
			String cargo = (String)request.getAttribute("cargo");
			int idade = 0, cst = 0, ctt = 0, adv = 0, acd = 0;
			if(setor != null && setor != ""){
				idade = (int)request.getAttribute("idade");
				cst = (int)request.getAttribute("cst");
				ctt = (int)request.getAttribute("ctt");
				adv = (int)request.getAttribute("adv");
				acd = (int)request.getAttribute("acd");
			}
		%>
        <div id="page-employee-profile">
            <div>
                <nav class="navbar navbar-dark bg-dark">
                    <span class="navbar-text">CatSeg</span>
                    <span class="navbar-text">Welcome, <%=adminName%></span>
                </nav>
            </div>
            <div class="container">
				<h2>Employee Profile</h2>
				<div class="buttons-dashboard">
					<a class="btn btn-danger" href="ControllerRedirectDashboard">
            			<img src="./assets/bootstrap-icons-1.0.0/arrow-left.svg" alt="Arrow Left" width="24" height="24" title="Voltar">	
            		</a>
            		<c:if test="${not empty setor}">
            			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#add-indicator" data-id="<%=id%>" disabled>
            				<img src="./assets/bootstrap-icons-1.0.0/plus.svg" alt="Plus" width="24" height="24" title="Adicionar Indicadores">	
            			</button>
            		</c:if>
            		<c:if test="${empty setor}">
            			<button type="button" class="btn btn-success" data-toggle="modal" data-target="#add-indicator" data-id="<%=id%>">
            				<img src="./assets/bootstrap-icons-1.0.0/plus.svg" alt="Plus" width="24" height="24" title="Adicionar Indicadores">	
            			</button>
            		</c:if>
					<c:if test="${not empty setor}">
            		<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#update-indicator" data-id=<%=id%> data-idade=<%=idade%> data-cargo=<%=cargo%> data-setor=<%=setor%> data-ctt=<%=ctt%> data-cst=<%=cst%> data-adv=<%=adv%> data-acd=<%=acd%>>
            			<img src="./assets/bootstrap-icons-1.0.0/pencil-fill.svg" alt="Trash" width="24" height="24" title="Editar Indicadores">	
            		</button> 
            		</c:if>		
            	</div>
            	
            	<c:if test="${not empty idade}">
            		<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/clock-fill.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Idade</h5>
							<c:out value="${idade}"></c:out> anos
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty setor}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/geo-fill.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Setor</h5>
							<c:out value="${setor}"></c:out>
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty cargo}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/person-check-fill.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Cargo</h5>
							<c:out value="${cargo}"></c:out>
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty cst}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/clock.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Carga horária semanal de trabalho</h5>
							<c:out value="${cst}"></c:out> horas
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty cst}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/clock-history.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Carga horária total de treinamentos</h5>
							<c:out value="${ctt}"></c:out> horas
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty adv}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/exclamation-diamond.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Quantidade de advertências</h5>
							<c:out value="${adv}"></c:out> advertências registradas
  						</div>
					</div>
				</c:if>
				<c:if test="${not empty acd}">
					<div class="media">
  						<img src="./assets/bootstrap-icons-1.0.0/exclamation-circle.svg" class="mr-3" alt="..." width="20" height="20">
  						<div class="media-body">
    						<h5 class="mt-0">Quantidade de acidentes</h5>
							<c:out value="${acd}"></c:out> acidentes sofridos registrados
  						</div>
					</div>
				</c:if>
            </div>
        </div>

		<!-- Include Custom Pages -->
		<jsp:include page="PopUps.html" />
        <!-- jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
     	<script src="./js/functions.js"></script>
  </body>
</html>