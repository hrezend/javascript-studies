<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
        <link rel="stylesheet" href="./styles/Indicators.css">
        <!-- Config -->
        <link rel="shortcut icon" href="./assets/page/icon.svg" type="image/x-icon"/>
        <title>Indicators</title>
    </head>
    <body>
    	<%
    		String ID = request.getAttribute("employeeID").toString();
    	%>
        <div id="page-indicators">
            <div class="div-nav">
                <nav class="navbar navbar-dark bg-dark">
                    <span class="navbar-text">CatSeg</span>
                </nav>
            </div>
            <div class="container">
                <h2>Continuar cadastro</h2>
                <form action="ServletAddIndicator" method="post">
                    <div class="form-row">
                    	<div class="col-md-6 mb-3">
                            <label>ID</label>
                            <input type="text" class="form-control" id="inputID" name="employeeID" value="<%=ID%>" maxlength="36" required="required" readonly>
                        </div>
                    	<div class="col-md-6 mb-3">
                            <label>Data de nascimento</label>
                            <input type="text" class="form-control" id="inputDate" name="dataNascimento" maxlength="10" placeholder="" autocomplete="off" required="required" onkeypress="$(this).mask('00/00/0000');">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Setor</label>
                            <input type="text" class="form-control" id="inputSetor" name="setor" maxlength="40" placeholder="" autocomplete="off" required="required">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Cargo</label>
                            <input type="text" class="form-control" id="inputCargo" name="cargo" maxlength="40" placeholder="" autocomplete="off" required="required">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Total de advertências</label>
                            <input type="number" class="form-control" id="inputAdvertencias" name="quantidadeDeAdvertencias" placeholder="" autocomplete="off" required="required">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Total de acidentes</label>
                            <input type="number" class="form-control" id="inputAcidentes" name="quantidadeDeAcidentes" placeholder="" autocomplete="off" required="required">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Caraga horaria semanal de trabalho</label>
                            <input type="number" class="form-control" id="inputCST" name="cargaHorariaSemanalDeTrabalho" placeholder="" autocomplete="off" required="required">
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Caraga horaria total de treinamentos</label>
                            <input type="number" class="form-control" id="inputCTT" name="cargaHorariaTotalDeTreinamento" placeholder="" autocomplete="off" required="required">
                        </div>    
                    </div>
                    <button class="btn btn-success" type="submit">Confirm</button>
                </form>
            </div>
        </div>

        <!-- jQuery and Bootstrap Bundle (includes Popper) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  </body>
</html>