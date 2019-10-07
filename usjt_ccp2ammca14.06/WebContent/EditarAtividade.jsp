<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ProjetoInter</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,800,900">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
<link rel="stylesheet" href="css/styles.min.css">
</head>

<body
	style="background-image: url(images/background.jpg;); background-repeat: no-repeat; background-size: cover; background-position: center;height:150vh;">
	<c:if test="${usuario.identificador == 2}">
		<c:import url="MenuAdministrador.jsp"/>
	</c:if>
	
	<c:if test="${usuario.identificador == 1}">
		<c:import url="MenuProfessor.jsp"/>
	</c:if>
	
	<c:if test="${usuario.identificador == 0}">
		<c:import url="MenuAluno.jsp"/>
	</c:if>
	
	<c:if test="${not empty erro}">
		<div class="alert alert-danger" role="alert">
  			${erro}
		</div>
	</c:if> 
	<div class="register-photo"
		style="background-color: rgba(241, 247, 252, 0);">
		<div class="form-container">
			<form action=controller.do method="post">
				<h2 class="text-center">
					<strong>Alteração de Atividade</strong>
				</h2>
					<input type="hidden" name="id" value="${atividade.id }" />
				<label>Numero da Atividade</label>
				<div class="form-group">
					<input class="form-control" type="number" id="inputBox" name="atv_numero" value="${atividade.atv_numero}" required
						style="background-color: #f9f9f9; border-radius: 20px;">
				</div>
				<label>Descrição</label>
				<div class="form-group">
					<input class="form-control" type="text" name="atvDescricao" value="${atividade.atvDescricao}" required
						style="background-color: #f9f9f9; border-radius: 20px;">
				</div>
				<label>Formato de entrega</label>
				<div class="form-group">
					<input class="form-control" type="text" name="atvFormato" value="${atividade.atvFormato}" required
						style="background-color: #f9f9f9; border-radius: 20px;">
				</div>
				<div class="form-row">
						<div class="col">
							<input class="form-control" type="text" data-mask="00/00/0000" maxlength="10" autocomplete="off" name="dataInicio" id="dataInicio" style="margin-top: 29px;" required
								placeholder="Data de inicio" value="<fmt:formatDate value="${atividade.dataInicio}" pattern="dd/MM/yyyy"/>">
						</div>
						<div class="col">
							<input class="form-control" type="text" data-mask="00/00/0000" maxlength="10" autocomplete="off" name="dataFinal" id="dataFinal" style="margin-top: 29px;" required
								placeholder="Data de fim" value="<fmt:formatDate value="${atividade.dataFinal}" pattern="dd/MM/yyyy"/>">
						</div>
					</div>				
				<label>Tema</label>
				<div class="form-row">
						<div class="col">
							<select name="tema_id"
								class="form-control d-flex flex-column align-self-start order-6"
								style="margin-top: 33px; background-color: #f9f9f9; border-radius: 20px;">
								<optgroup label="temas">
									<c:forEach var="tema" items="${lista}">                          
										<option id="tema_id" value="${tema.id}">${tema.titulo}</option> 		                       
	                        	 	</c:forEach> 
								</optgroup>
							</select>
						</div>
						<div class="col" style="height: 70px;">
							<a class="btn btn-primary btn-block" role="submit" href="cadastroTema.jsp"
								style="border-radius: 20px;background-color:#80ccff">Criar Tema</a>
						</div>
				</div>
				<div class="form-group d-flex">
					<button class="btn btn-primary btn-block" type="submit" name="command" value="AlterarAtividade"
						style="border-radius: 20px;">Editar</button> 
					<button class="btn btn-primary btn-block" type="submit" name="command" value="ListarAtividadeReiniciar"
						style="border-radius: 20px; background-color: rgb(255, 255, 255); color: rgb(0, 5, 130);">Cancelar</button>
				</div>
			</form>
		</div>
		<div style="height: 17px;"></div>

		
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery.mask.min.js"></script>
	<script type="text/javascript">
			$('dataMask').mask("00/00/0000")
		</script>
	<script type="text/javascript">
		var inputBox = document.getElementById("inputBox");
	
		var invalidChars = [
		  "-",
		  "+",
		  "e",
		];
	
		inputBox.addEventListener("keydown", function(e) {
		  if (invalidChars.includes(e.key)) {
		    e.preventDefault();
		  }
		});
		</script>
	
</body>

</html>