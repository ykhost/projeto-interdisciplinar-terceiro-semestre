<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,java.util.ArrayList, model.Aluno"%>
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
	style="background-image: url(images/background.jpg;); background-repeat: no-repeat; background-size: cover; background-position: center; height: 100vh;">
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
					<strong>Altera��o de Tema</strong>
				</h2>
				
					<input type="hidden" name="id"  value="${tema.id}" />
				<label>Data de Cadastro</label>
				<div class="form-group">
					<input class="form-control" type="text" name="dtCadastro" readonly="readonly" required required
						maxlength="100" style="background-color: #f9f9f9; border-radius: 20px;"
						value="<fmt:formatDate value="${tema.dtCadastro}" pattern="dd/MM/yyyy"/>">
				</div>
				<label>Titulo</label>
				<div class="form-group">
					<input class="form-control" type="text" name="titulo" id="titulo" value="${tema.titulo}" required
						style="background-color: #f9f9f9; border-radius: 20px;">
				</div>
				<label>Introdu��o</label>
				<div class="form-group">
					<textarea class="form-control" rows="14" name="introducao" id="introducao" required
						style="border-radius: 20px; background-color: #f9f9f9;">${tema.introducao}</textarea>
				</div>
				<label>Requisitos</label>
				<div class="form-group">
					<textarea class="form-control" rows="14" name="requisitos" id="requisitos" required
						style="border-radius: 20px; background-color: #f9f9f9;">${tema.requisitos}</textarea>
				</div>
				<div class="form-group d-flex">
					<button class="btn btn-primary btn-block" type="submit" name="command" value="AlterarTema"
						style="border-radius: 20px;">Editar</button>
					<button class="btn btn-primary btn-block" type="submit" name="command" value="ListarTemaReiniciar"
						style="border-radius: 20px; background-color: rgb(255, 255, 255); color: rgb(0, 5, 130);">Cancelar</button>
				</div>
			</form>
		</div>
		<div style="height: 17px;"></div>
		<div class="form-container"></div>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/jquery.mask.min.js"></script>
	<script type="text/javascript">
			$('dataMask').mask("00/00/0000")
		</script>
	
</body>

</html>