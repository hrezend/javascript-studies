<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="Data.ProcessaData, Dados.Usuario, Dados.Remedio, Dados.Alergia, Dados.Hospital, Dados.Farmacia, Dados.ConsultaFutura, Dados.ConsultaRealizada, Dados.Contatos, java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="pt-br">
  <head>
  	<!-- Pegar funçao de formatação dos campos de telefone, rg e cpf -->
	<script src="js/FormatarCampo.js" type="text/javascript"></script>
  
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<!-- CSS Personalizado -->
	<link rel="stylesheet" type="text/css" href="css/personalizado.css">
	<link rel="stylesheet" type="text/css" href="css/Logout.css">

	<!-- Informações da Página -->
    <title>SaveMe: Perfil</title>
	<link rel="shortcut icon" href="images/logoICO.png" type="image/x-icon"/>

  </head>
  
  <body>
  
  	<c:if test="${empty loginUsuario}"> response.sendRedirect("RedirecionarLogin");</c:if>
  	<jsp:include page="MenuPerfil.jsp" />
	
	<div class="container2">
		
	<nav>
  		<div class="nav nav-tabs" id="nav-tab" role="tablist">
   			 <a class="nav-item nav-link active" id="nav-perfil-tab" data-toggle="tab" href="#nav-perfil" role="tab" aria-controls="nav-home" aria-selected="true">Perfil</a>
    		 <a class="nav-item nav-link" id="nav-alergias-tab" data-toggle="tab" href="#nav-alergias" role="tab" aria-controls="nav-profile" aria-selected="false">Alergias</a>
    		 <a class="nav-item nav-link" id="nav-remedios-tab" data-toggle="tab" href="#nav-remedios" role="tab" aria-controls="nav-contact" aria-selected="false">Remédios</a>
    		 <a class="nav-item nav-link" id="nav-hospitais-tab" data-toggle="tab" href="#nav-hospitais" role="tab" aria-controls="nav-contact" aria-selected="false">Hospitais</a>
  			 <a class="nav-item nav-link" id="nav-farmacias-tab" data-toggle="tab" href="#nav-farmacias" role="tab" aria-controls="nav-contact" aria-selected="false">Farmácias</a>
  		  	 <a class="nav-item nav-link" id="nav-consr-tab" data-toggle="tab" href="#nav-consr" role="tab" aria-controls="nav-contact" aria-selected="false">Consultas Realizadas</a>
  		     <a class="nav-item nav-link" id="nav-consf-tab" data-toggle="tab" href="#nav-consf" role="tab" aria-controls="nav-contact" aria-selected="false">Consultas Futuras</a>
  		  	 <a class="nav-item nav-link" id="nav-contatos-tab" data-toggle="tab" href="#nav-contatos" role="tab" aria-controls="nav-contact" aria-selected="false">Contatos de Emergência</a>
  		</div>
	</nav>
	
	
		<div class="tab-content" id="nav-tabContent">
  			<div class="tab-pane fade show active" id="nav-perfil" role="tabpanel" aria-labelledby="nav-home-tab">
  			<BR>
  			
  				<div class="card" id="dados">
					<h5 class="card-header">Perfil</h5>
					<div class="card-body p-1">
					
					
					<div class="row">
							<div class="col-4">
								<div class="list-group" id="list-tab" role="tablist">
									<a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home"><i class="fas fa-user-alt"></i> Básico</a> 
									<a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile"><i class="fas fa-walking"></i> Contatos e Endereços</a> 
									<a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#list-messages" role="tab" aria-controls="messages"><i class="fas fa-fingerprint"></i> Anamnese</a>
									<a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#list-settings" role="tab" aria-controls="settings"><i class="fas fa-cogs"></i> Opções</a>
									<c:forEach items="${ListaUsuario}" var="usuario">
									<c:if test="${empty usuario.getDiabeticoUsuario()}">
									<div class="alert alert-danger alert-dismissible fade show" role="alert">
  										Clique <a href="TelaCadastroAnamnese.jsp" class="alert-link">aqui</a> e termine o seu cadastro no sistema.
  										<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									</div>
									</c:if>
									</c:forEach>
									
								</div>
							</div>
							<div class="col-8">
								<div class="tab-content" id="nav-tabContent">
								
								<c:forEach items="${ListaUsuario}" var="usuario">
									<div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">
										<table class="table">
											<tr>
												<th scope="col">Nome:</th>
												<td><c:out value="${usuario.getNomeUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Sexo:</th>
												<td><c:out value="${usuario.getSexoUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Data de Nascimento:</th>
												<td><c:out value="${usuario.getDataNascUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Estado Civil:</th>
												<td><c:out value="${usuario.getEstCivilUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">CPF:</th>
												<td><c:out value="${usuario.getCpfUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">RG:</th>
												<td><c:out value="${usuario.getRgUsuario()}"></c:out></td>
											</tr>
										</table>
									</div>

									<div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">

										<table class="table">
											<tr>
												<th scope="col">Email:</th>
												<td><c:out value="${usuario.getEmailUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Telefone Celular:</th>
												<td><c:out value="${usuario.getTelefoneUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Endereço:</th>
												<td><c:out value="${usuario.getEnderecoUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Cidade:</th>
												<td><c:out value="${usuario.getCidadeUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">CEP:</th>
												<td><c:out value="${usuario.getCepUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Estado:</th>
												<td><c:out value="${usuario.getUfUsuario()}"></c:out></td>
											</tr>

										</table>
									</div>


									<div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">

										<table class="table">
											<tr>
												<th scope="col">Peso:</th>
												<td><c:out value="${usuario.getPesoUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Altura:</th>
												<td><c:out value="${usuario.getAlturaUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Tipo Sanguíneo:</th>
												<td><c:out value="${usuario.getTipoSangueUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Possui doença venérea?</th>
												<td><c:out value="${usuario.getDoencaVenereaUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Possui dependência?</th>
												<td><c:out value="${usuario.getDependenciaUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Possui hipertensão?</th>
												<td><c:out value="${usuario.getHipertensaoUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Possui diabetes?</th>
												<td><c:out value="${usuario.getDiabeticoUsuario()}"></c:out></td>
											</tr>
											<tr>
												<th scope="col">Possui colesterol alto?</th>
												<td><c:out value="${usuario.getColesterolUsuario()}"></c:out></td>
											</tr>
										</table>
									</div>

									<div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">
										<button type="button" class="btn btn-warning btn-custom" data-toggle="modal" data-target="#editarUsuario" 
											data-whatever="<c:out value="${usuario.getIdUsuario()}"></c:out>" 
											data-whatevernome="<c:out value="${usuario.getNomeUsuario()}"></c:out>" 
											data-whatevertelefone="<c:out value="${usuario.getTelefoneUsuario()}"></c:out>" 
											data-whateverdatanascimento="<c:out value="${usuario.getDataNascUsuario()}"></c:out>" 
											data-whatevercidade="<c:out value="${usuario.getCidadeUsuario()}"></c:out>" 
											data-whateverestado="<c:out value="${usuario.getUfUsuario()}"></c:out>" 
											data-whateverendereco="<c:out value="${usuario.getEnderecoUsuario()}"></c:out>" 
											data-whatevercpf="<c:out value="${usuario.getCpfUsuario()}"></c:out>" 
											data-whateverrg="<c:out value="${usuario.getRgUsuario()}"></c:out>" 
											data-whateverestadocivil="<c:out value="${usuario.getEstCivilUsuario()}"></c:out>" 
											data-whateverdependencia="<c:out value="${usuario.getDependenciaUsuario()}"></c:out>"
											data-whateverdiabete="<c:out value="${usuario.getDiabeticoUsuario()}"></c:out>" 
											data-whatevercolesterol="<c:out value="${usuario.getColesterolUsuario()}"></c:out>"
											data-whateverhipertensao="<c:out value="${usuario.getHipertensaoUsuario()}"></c:out>"
											data-whatevervenerea="<c:out value="${usuario.getDoencaVenereaUsuario()}"></c:out>" 
											data-whateversangue="<c:out value="${usuario.getTipoSangueUsuario()}"></c:out>" 
											data-whateverpeso="<c:out value="${usuario.getPesoUsuario()}"></c:out>" 
											data-whateveraltura="<c:out value="${usuario.getAlturaUsuario()}"></c:out>" 
											data-whatevercep="<c:out value="${usuario.getCepUsuario()}"></c:out>" 
											><i class="fas fa-user-edit"></i> Editar Perfil
										</button>
										
										<BR>
										<BR>
										<button type="button" class="btn btn-warning btn-custom" data-toggle="modal" data-target="#editarSenha"><i class="fas fa-wrench"></i> Alterar Senha</button>								
										<BR>
										<BR>
										<button type="button" class="btn btn-warning btn-custom" data-toggle="modal" data-target="#editarEmail"><i class="fas fa-wrench"></i> Alterar Email</button>								
										<BR>
										<BR>
										<a href="AcaoImprimir" class="btn btn-info btn-custom"><i class="fas fa-download"></i> Imprimir Perfil</a>
										<BR>
										<BR>
										<button type="button" class="btn btn-danger btn-custom" data-toggle="modal" data-target="#excluirPerfil"><i class="fas fa-exclamation-triangle"></i> Excluir Perfil</button>								
										<BR>
										
									</div>
								</c:forEach>

								</div>
							</div>
						</div>		
				
					</div>
				</div>
  		</div>
  		
  		
			<div class="tab-pane fade" id="nav-alergias" role="tabpanel" aria-labelledby="nav-profile-tab">
			<BR>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">#</th>
									<th scope="col">Descrição:</th>
									<th scope="col">Opções:</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ListaAlergia}" var="alergias">
								<tr>
									<th scope="row"><c:out value="${alergias.getIdAlergia()}"></c:out></th>
									<td><c:out value="${alergias.getDescricaoAlergia()}"></c:out></td>
           			 				<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarAlergia" 
											data-whatever="<c:out value="${alergias.getIdAlergia()}"></c:out>" 
											data-whateverdescricao="<c:out value="${alergias.getDescricaoAlergia()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
										<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirAlergia?IdAlergia=<c:out value="${alergias.getIdAlergia()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>	
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>

        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastroalergias" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Alergia</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastroalergias">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Alergia</h4>
                    
									<form method="post" action="AcaoInserirAlergia">
                        
                        			<div class="form-group">
                           				<label>Descrição da Alergia:</label>
                            			<input class="form-control" type="text" name="descricaoAlergia" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
				</div>
			
			
			
 			<div class="tab-pane fade" id="nav-remedios" role="tabpanel" aria-labelledby="nav-contact-tab">
			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome do Remédio:</th>
							<th scope="col">Descrição de Uso:</th>
							<th scope="col">Opções:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaRemedio}" var="remedios">
						<tr>
							<th scope="row"><c:out value="${remedios.getIdRemedio()}"></c:out></th>
							<td><c:out value="${remedios.getNomeRemedio()}"></c:out></td>
           			 		<td><c:out value="${remedios.getDescricaoUso()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarRemedio" 
											data-whatever="<c:out value="${remedios.getIdRemedio()}"></c:out>"
											data-whatevernome="<c:out value="${remedios.getNomeRemedio()}"></c:out>"
											data-whateverdescricao="<c:out value="${remedios.getDescricaoUso()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirRemedio?IdRemedio=<c:out value="${remedios.getIdRemedio()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastroremedio" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Remédio</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastroremedio">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Remédio</h4>
                    
									<form method="post" action="AcaoInserirRemedio">
                        
                        			<div class="form-group">
                        				<label>Nome:</label>
                            			<input class="form-control" type="text" name="nomeRemedio" required="required">
                           				<label>Descrição de Uso:</label>
                            			<input class="form-control" type="text" name="descricaoUso" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 			
 			<div class="tab-pane fade" id="nav-farmacias" role="tabpanel" aria-labelledby="nav-contact-tab">
			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome da Farmácia:</th>
							<th scope="col">Localização:</th>
							<th scope="col">Opções:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaFarmacia}" var="farmacias">
						<tr>
							<th scope="row"><c:out value="${farmacias.getIdFarmacia()}"></c:out></th>
							<td><c:out value="${farmacias.getNomeFarmacia()}"></c:out></td>
           			 		<td><c:out value="${farmacias.getLocalizacaoFarmacia()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarFarmacia" 
											data-whatever="<c:out value="${farmacias.getIdFarmacia()}"></c:out>"
											data-whatevernome="<c:out value="${farmacias.getNomeFarmacia()}"></c:out>"
											data-whateverlocalizacao="<c:out value="${farmacias.getLocalizacaoFarmacia()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirFarmacia?IdFarmacia=<c:out value="${farmacias.getIdFarmacia()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastrofarmacia" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Farmácia</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastrofarmacia">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Farmácia</h4>
                    
									<form method="post" action="AcaoInserirFarmacia">
                        
                        			<div class="form-group">
                        				<label>Nome da Farmácia:</label>
                            			<input class="form-control" type="text" name="nomeFarmacia" required="required">
                           				<label>Localização:</label>
                            			<input class="form-control" type="text" name="localizacaoFarmacia" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 		<div class="tab-pane fade" id="nav-hospitais" role="tabpanel" aria-labelledby="nav-contact-tab">
			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome do Hospital:</th>
							<th scope="col">Localização:</th>
							<th scope="col">Opções:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaHospital}" var="hospitais">
						<tr>
							<th scope="row"><c:out value="${hospitais.getIdHospital()}"></c:out></th>
							<td><c:out value="${hospitais.getNomeHospital()}"></c:out></td>
           			 		<td><c:out value="${hospitais.getLocalizacaoHospital()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarHospital" 
											data-whatever="<c:out value="${hospitais.getIdHospital()}"></c:out>"
											data-whatevernome="<c:out value="${hospitais.getNomeHospital()}"></c:out>"
											data-whateverlocalizacao="<c:out value="${hospitais.getLocalizacaoHospital()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirHospital?IdHospital=<c:out value="${hospitais.getIdHospital()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastrohospital" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Hospital</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastrohospital">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Hospital</h4>
                    
									<form method="post" action="AcaoInserirHospital">
                        
                        			<div class="form-group">
                        				<label>Nome do Hospital:</label>
                            			<input class="form-control" type="text" name="nomeHospital" required="required">
                           				<label>Localização:</label>
                            			<input class="form-control" type="text" name="localizacaoHospital" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 			<div class="tab-pane fade" id="nav-consr" role="tabpanel" aria-labelledby="nav-contact-tab">
 			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome do Hospital:</th>
							<th scope="col">Data da Consulta:</th>
							<th scope="col">Especialidade Médica:</th>
							<th scope="col">Diagnóstico:</th>
							<th scope="col">Opções:</th>		
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaConsultaRealizada}" var="consr">
						<tr>
							<th scope="row"><c:out value="${consr.getIdConsultaRealizada()}"></c:out></th>
							<td><c:out value="${consr.getHospitalConsultaRealizada()}"></c:out></td>
           			 		<td><c:out value="${consr.getDataConsultaRealizada()}"></c:out></td>
           			 		<td><c:out value="${consr.getEspecialidadeConsultaRealizada()}"></c:out></td>
           			 		<td><c:out value="${consr.getDiagnosticoConsultaRealizada()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarConsultaR" 
											data-whatever="<c:out value="${consr.getIdConsultaRealizada()}"></c:out>"
											data-whatevernome="<c:out value="${consr.getHospitalConsultaRealizada()}"></c:out>"
											data-whateverdata="<c:out value="${consr.getDataConsultaRealizada()}"></c:out>"
											data-whateverespecialidade="<c:out value="${consr.getEspecialidadeConsultaRealizada()}"></c:out>"
											data-whateverdiagnostico="<c:out value="${consr.getDiagnosticoConsultaRealizada()}"></c:out>" 
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirConsultaRealizada?IdConsultaRealizada=<c:out value="${consr.getIdConsultaRealizada()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastroconsr" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Consulta</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastroconsr">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Consulta Realizada</h4>
                    
									<form method="post" action="AcaoInserirConsultaRealizada">
                        
                        			<div class="form-group">
                        				<label>Nome do Hospital:</label>
                            			<input class="form-control" type="text" name="hospitalConsultaRealizada" required="required">
                           				<label>Data da Consulta:</label>
                            			<input class="form-control" type="date" name="dataConsultaRealizada" required="required">
                            			<label>Especialidade Médica:</label>
                            			<input class="form-control" type="text" name="especialidadeConsultaRealizada" required="required">
                            			<label>Diagnóstico:</label>
                            			<input class="form-control" type="text" name="diagnosticoConsultaRealizada" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 			<div class="tab-pane fade" id="nav-consf" role="tabpanel" aria-labelledby="nav-contact-tab">
 			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome do Hospital:</th>
							<th scope="col">Data da Consulta:</th>
							<th scope="col">Especialidade Médica:</th>
							<th scope="col">Opções:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaConsultaFutura}" var="consf">
						<tr>
							<th scope="row"><c:out value="${consf.getIdConsultaFutura()}"></c:out></th>
							<td><c:out value="${consf.getHospitalConsultaFutura()}"></c:out></td>
           			 		<td><c:out value="${consf.getDataConsultaFutura()}"></c:out></td>
           			 		<td><c:out value="${consf.getEspecialidadeConsultaFutura()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarConsultaF" 
											data-whatever="<c:out value="${consf.getIdConsultaFutura()}"></c:out>"
											data-whatevernome="<c:out value="${consf.getHospitalConsultaFutura()}"></c:out>"
											data-whateverdata="<c:out value="${consf.getDataConsultaFutura()}"></c:out>"
											data-whateverespecialidade="<c:out value="${consf.getEspecialidadeConsultaFutura()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirConsultaFutura?IdConsultaFutura=<c:out value="${consf.getIdConsultaFutura()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>						
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastroconsf" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Consulta</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastroconsf">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Consulta Futura</h4>
                    
									<form method="post" action="AcaoInserirConsultaFutura">
                        
                        			<div class="form-group">
                        				<label>Nome do Hospital:</label>
                            			<input class="form-control" type="text" name="hospitalConsultaFutura" required="required">
                           				<label>Data da Consulta:</label>
                            			<input class="form-control" type="date" name="dataConsultaFutura" required="required">
                            			<label>Especialidade Médica:</label>
                            			<input class="form-control" type="text" name="especialidadeConsultaFutura" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 			
 			
 			<div class="tab-pane fade" id="nav-contatos" role="tabpanel" aria-labelledby="nav-contact-tab">
 			<BR>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Nome:</th>
							<th scope="col">Telefone:</th>
							<th scope="col">Email:</th>
							<th scope="col">Opções:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ListaContatos}" var="contatos">
						<tr>
							<th scope="row"><c:out value="${contatos.getIdContato()}"></c:out></th>
							<td><c:out value="${contatos.getNomeContato()}"></c:out></td>
           			 		<td><c:out value="${contatos.getTelefoneContato()}"></c:out></td>
           			 		<td><c:out value="${contatos.getEmailContato()}"></c:out></td>
           			 		<td><button type="button" class="btn btn-warning btn-sm btn-custom" data-toggle="modal" data-target="#editarContato" 
											data-whatever="<c:out value="${contatos.getIdContato()}"></c:out>"
											data-whatevernome="<c:out value="${contatos.getNomeContato()}"></c:out>"
											data-whatevertelefone="<c:out value="${contatos.getTelefoneContato()}"></c:out>"
											data-whateveremail="<c:out value="${contatos.getEmailContato()}"></c:out>"
											><i class="fas fa-pen"></i> Editar</button>
								<a class="btn btn-danger btn-sm btn-custom" href="AcaoExcluirContato?IdContato=<c:out value="${contatos.getIdContato()}"></c:out>"><i class="fas fa-trash-alt"></i> Excluir</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
        				<BR>
        				<a class="btn btn-primary btn-custom" data-toggle="collapse" href="#cadastrocontato" role="button" aria-expanded="false"><i class="fas fa-plus-circle"></i> Cadastrar Contato</a>
       					 <section>
							<div class="container mt-4">
								<div class="collapse mt-2 col-md-6 mx-auto" id="cadastrocontato">
									<div class="card card-body">
                    
									<h4 class="h5 text-center">Cadastro de Contato de Emergência</h4>
                    
									<form method="post" action="AcaoInserirContato">
                        
                        			<div class="form-group">
                        				<label>Nome:</label>
                            			<input class="form-control" type="text" name="nomeContato" required="required">
                           				<label>Telefone:</label>
                            			<input class="form-control" onkeydown="javascript: formatarTelefone(this);" maxlength="14" type="text" name="telefoneContato" required="required">
                            			<label>Email:</label>
                            			<input class="form-control" type="text" name="emailContato" required="required">
                        			</div>                    
                        			<div class="d-flex justify-content-end">
                           				<button type="submit" class="btn btn-primary m-2">Cadastrar</button>
                       				</div>
									</form>
									</div>
								</div>          
							</div>
			 			</section>
 				</div>
 			
 			
 			
		</div>
	
<!-- Início da Área de Edições -->
	<jsp:include page="PopUps.html" />
<!-- Fim da Área de Edições -->


	
	</div>
		
		<jsp:include page="Rodape.html" />	
	

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://kit.fontawesome.com/9b1e32f7a8.js"></script>
    <script src="popper/popper.min.js" ></script>
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/CarregarConteudoDoPopUp.js"></script>
    

  </body>
</html>