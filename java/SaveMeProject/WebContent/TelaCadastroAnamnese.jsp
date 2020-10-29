<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="pt-br">
  <head>

	<!-- Scripts de Formatação de Campos -->
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/FormatCamposJQ.js" ></script>

	<!-- Pegar funçao de formatação dos campos de telefone, rg e cpf -->
	<script src="js/Cadastro.js" type="text/javascript"></script>
	<script src="js/ValidaSenha.js" type="text/javascript"></script>
	<script src="https://kit.fontawesome.com/9b1e32f7a8.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
    <script src="popper/popper.js" ></script>
	
	
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	
	<!-- CSS Personalizado -->
	<link rel="stylesheet" type="text/css" href="css/personalizado.css">

    <title>SaveMe: Cadastro</title>
	<link rel="shortcut icon" href="images/logoICO.png" type="image/x-icon" />
  </head>
  
  <body>
  
  	<jsp:include page="Menu.jsp" />
	
	<div class="container2">
	<p class="h2">Cadastro</p>
	
	<form action="AcaoInserirAnamneseUsuario" method="post">
	<BR>
	<div class="tab-content" id="nav-tabContent">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputState">Peso</label>
				<input type="text" class="form-control" placeholder="Digite apenas números" maxlength="7" required="required" id="peso" name="pesoUsuario">
			</div>
			<div class="form-group col-md-6">
				<label for="inputState">Altura</label>
				<input type="text" class="form-control" placeholder="Digite apenas números" maxlength="4" required="required" id="altura" name="alturaUsuario">
			</div>
		</div>
  		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputState">Tipo Sanguíneo</label>
				<select id="inputState" class="form-control" required="required" name="tipoSangueUsuario">
				<option value="" selected>Selecionar</option>
				<option>A +</option>
				<option>A -</option>
				<option>B +</option>
				<option>B -</option>
				<option>O +</option>
				<option>O -</option>
				<option>AB +</option>
				<option>AB -</option>
				</select>
			</div>
			<div class="form-group col-md-6">
				<label for="inputState">Você possui algum tipo de dependência (química,alcoólica,digital)?</label>
				<select id="inputState" class="form-control" required="required" name="dependenciaUsuario">
				<option value="" selected>Selecionar</option>
				<option>Não</option>
				<option>Sim, dependência química.</option>
				<option>Sim, dependência alcoólica.</option>
				<option>Sim, dependência digital.</option>
				</select>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputState">Você possui diabetes?</label>
				<select id="inputState" class="form-control" required="required" name="diabeticoUsuario">
				<option value="" selected>Selecionar</option>
				<option>Não</option>
				<option>Sim, possuo diabetes tipo 1.</option>
				<option>Sim, possuo diabetes tipo 2.</option>
				</select>
			</div>
			<div class="form-group col-md-6">
				<label for="inputState">Você possui hipertensão?</label>
				<select id="inputState" class="form-control" required="required" name="hipertensaoUsuario">
				<option value="" selected>Selecionar</option>
				<option>Não</option>
				<option>Sim</option>
				</select>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="inputState">Você possui alguma doença venérea?</label>
				<select id="inputState" class="form-control" required="required" name="doencaVenereaUsuario">
				<option value="" selected>Selecionar</option>
				<option>Não</option>
				<option>Sim</option>
				</select>
			</div>
			<div class="form-group col-md-6">
				<label for="inputState">Você possui colesterol alto?</label>
				<select id="inputState" class="form-control" required="required" name="colesterolUsuario">
				<option value="" selected>Selecionar</option>
				<option>Não</option>
				<option>Sim</option>
				</select>
			</div>
		</div>
		<BR>
  		<button type="reset" class="btn btn-danger btn-custom"><i class="fas fa-times-circle"></i> Limpar</button>
        <button type="submit" class="btn btn-success btn-custom"><i class="fas fa-check-circle"></i> Cadastrar</button>
  		
	</div>

	</form>
		
	</div>
		
	<jsp:include page="Rodape.html" />

  </body>
</html>