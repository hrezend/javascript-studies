<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html lang="pt-br">
  <head>
  
  	<!-- Scripts de Formatação de Campos -->
	<script src="js/jquery-3.3.1.slim.min.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/FormatCamposJQ.js" ></script>
	
	<!-- Pegar os JS's -->
	<script src="js/Cadastro.js" type="text/javascript"></script>
	<script src="js/ValidaSenha.js" type="text/javascript"></script>
	<script src="js/ValidaNome.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
	<script src="popper/popper.js" type="text/javascript"></script>
	
	<!-- Carregar os ícones -->
	<script src="https://kit.fontawesome.com/9b1e32f7a8.js"></script>
    
	
	
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
	
	<form action="AcaoInserirUsuario" method="post">
	<BR>
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
 			 <strong>Atenção!</strong> Nos campos números, digite somente os números e o nosso sistema automaticamente o formatará de acordo com a necessidade.
 			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
   				 <span aria-hidden="true">&times;</span>
  			</button>
		</div>
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
 			 <strong>Atenção!</strong> Sua senha deve conter entre 8 e 20 caracteres, possuindo letras maiúsculas e minúsculas, caracteres especiais e, pelo menos, 3 números.
 			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
   				 <span aria-hidden="true">&times;</span>
  			</button>
		</div>
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
 			 <strong>Atenção!</strong> Os campos acompanhados por um <h11>*</h11> são de preenchimento obrigatório.
 			 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
   				 <span aria-hidden="true">&times;</span>
  			</button>
		</div>

		<div class="tab-content" id="nav-tabContent">
  		<div class="form-row">
			<div class="form-group col-md-8">
				<label for="nome">Nome Completo</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-user-shield"></i></div>
        			</div>
				  <input type="text" class="form-control" id="nome" placeholder="Digite seu nome completo" required="required" name="nomeUsuario" autofocus>
				</div>
			</div>
			<div class="form-group col-md-2">
				<label for="CEP">CEP</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-location-arrow"></i></div>
        			</div>
					<input id="cep" name="cepUsuario" placeholder="XX.XXX-XXX" class="form-control input-md" required="required" type="search" maxlength="10">
				</div>
			</div>
			<div class="form-group col-md-2">
				<BR>
				<button type="button" class="btn btn-info btn-custom" onclick="pesquisacep(cep.value)"><i class="fas fa-search"></i> Pesquisar</button>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="login">Login</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-at"></i></div>
        			</div>
				   <input type="text" class="form-control" id="login" placeholder="Digite um login de usuário" required="required" name="loginUsuario" maxlength="20">
				</div>
			</div>
			<div class="form-group col-md-4">
				<label for="senha">Senha</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-check"></i></div>
        			</div>
				   <input type="password" class="form-control" placeholder="Digite sua senha" maxlength="20" required="required" id="senhaUsuario" name="senhaUsuario">
				</div>
			</div>
			<div class="form-group col-md-4">	
				<label for="senha2">Confirmar Senha</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-check"></i></div>
        			</div>
				   <input type="password" class="form-control" onblur="ValidaSenha()" placeholder="Digite sua senha novamente" maxlength="20" required="required" id="senhaUsuario2" name="senhaUsuario2">			
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="cpf">CPF</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-id-card"></i></div>
        			</div>
					<input type="text" class="form-control" id="cpf" placeholder="XXX.XXX.XXX-XX" required="required" type="text" maxlength="14" name="cpfUsuario">	
				</div>
			</div>
			<div class="form-group col-md-4">
				<label for="rg">RG</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-address-card"></i></div>
        			</div>
					<input type="text" class="form-control" id="rg" placeholder="XX.XXX.XXX-XX" required="required" maxlength="13" name="rgUsuario">
				</div>
			</div>
			<div class="form-group col-md-4">	
				<label for="data">Data de Nascimento</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-calendar-alt"></i></div>
        			</div>
					<input type="text" class="form-control" id="data" placeholder="DD/MM/AAAA" required="required" maxlength="10" name="dataNascUsuario">			
				</div>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-4">
				<label for="telefone">Email</label><h11>*</h11>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text"><i class="fas fa-envelope"></i></div>
					</div>
     				<input id="emailUsuario" name="emailUsuario" class="form-control" placeholder="email@email.com" required="required" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" >
   				</div>
			</div>
			<div class="form-group col-md-2">
				<label for="telefone">Telefone</label><h11>*</h11>
      			<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-phone-alt"></i></div>
        			</div>
        			<input id="telefone" name="telefoneUsuario" class="form-control" placeholder="(XX) XXXXX-XXXX" required="required" type="text" maxlength="15">
     			</div>
			</div>
			<div class="form-group col-md-3">
				<label for="estCivil">Estado Civil</label><h11>*</h11>
				<div class="input-group">
        			<div class="input-group-prepend">
          				<div class="input-group-text"><i class="fas fa-restroom"></i></div>
        			</div>
				<select id="estCivil" class="form-control" required="required" name="estCivilUsuario">
				<option value="" selected>Selecionar</option>
				<option>União Estável</option>
				<option>Casado(a)</option>
				<option>Solteiro(a)</option>
				<option>Separado(a)</option>
				<option>Divorciado(a)</option>
				<option>Viúvo(a)</option>
				</select>
				</div>
			</div>
			<div class="form-group col-md-3">
				<label for="sexo">Sexo</label><h11>*</h11>
				<BR>
				<div class="custom-control custom-radio custom-control-inline">
  					<input type="radio" id="customRadio1" name="sexoUsuario" value="1" class="custom-control-input">
 					<label class="custom-control-label" for="customRadio1">Masculino</label>
				</div>
				<div class="custom-control custom-radio custom-control-inline">
  					<input type="radio" id="customRadio2" name="sexoUsuario" value="2" class="custom-control-input">
  					<label class="custom-control-label" for="customRadio2">Feminino</label>
				</div>
			</div>		
		</div>
		<div class="form-row">
			<div class="form-group col-md-8">
			<label for="telefone">Endereço</label><h11>*</h11>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text"><i class="fas fa-home"></i></div>
					</div>
						<input id="rua" name="enderecoUsuario" class="form-control" placeholder="Rua X, Casa Y, Nº Z" required="required" type="text">   				
				</div>
			</div>
			<div class="form-group col-md-2">
			<label for="telefone">Cidade</label><h11>*</h11>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text"><i class="fas fa-map-marked-alt"></i></div>
					</div>
						<input id="cidade" name="cidadeUsuario" class="form-control" placeholder="" required="required"  readonly="readonly" type="text">   				
				</div>
			</div>
			<div class="form-group col-md-2">
			<label for="telefone">Estado</label><h11>*</h11>
				<div class="input-group">
					<div class="input-group-prepend">
						<div class="input-group-text"><i class="fas fa-map-marker-alt"></i></div>
					</div>
      					<input id="estado" name="ufUsuario" class="form-control" placeholder="" required="required"  readonly="readonly" type="text">
				</div>
			</div>
		</div>
  		<button type="reset" class="btn btn-danger btn-custom"><i class="fas fa-times-circle"></i> Limpar</button>
        <button type="submit" class="btn btn-success btn-custom" onclick="ValidaSenha()"><i class="fas fa-check-circle"></i> Cadastrar</button>
	</div>

	</form>

	</div>
		
	<jsp:include page="Rodape.html" />

  </body>
</html>