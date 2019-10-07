<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Aldrich">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Audiowide">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
<link rel="stylesheet" href="css/styles.min.css">

</head>
<body style="background-image:url(images/background-home.jpg;);background-repeat:no-repeat;background-size:cover;background-position:center;height:100vh;">

	<c:if test="${usuario.identificador == 2}">
	<c:import url="HomeAdm.jsp"/>
	</c:if>
	
	<c:if test="${usuario.identificador == 1}">
	<c:import url="HomeProfessor.jsp"/>
	</c:if>
	
	<c:if test="${usuario.identificador == 0}">
	<c:import url="HomeAluno.jsp"/>
	</c:if>
	
	<c:if test="${not empty erro}">
		<div class="alert alert-danger" role="alert">
  			${erro}
		</div>
	</c:if>

	<!-- ISSO QUEBRA O MODELO MVC, o index deve ser outra coisa.
		 Hamilton tinha também comentado a respeito.
	
	<div id="main" class="container">
		<h3 class="page-header">Cadastro de Grupo de Alunos</h3>
		<form action="entrada?acao=CriarGruposAlunos" method="post">

			<div class="row">
				<div class="form-group col-md-12">
					<label for="orientador_id">Id do Orientador</label><br> <select
						name="orientador_id" id="orientador_id">
						<option selected>Selecione um Orientador</option>
						<c:forEach var = "professor" items="${professores}">
							<option value="${professor.id}"> ${professor.nome}</option>	
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-6">
					<label for="populacao">Número</label> <input type="tel"
						class="form-control" name="numero" id="numero" maxlength="15"
					 placeholder="Digite o número de integrantes" required/>
				</div>
				<div class="form-group col-md-6">
					<label for="nome">Nome</label> <input type="text"
						class="form-control" name="nome" id="nome"
						maxlength="100" placeholder="Digite o nome do grupo" required/>
				</div>
			</div>

			<hr />
			<div id="actions" class="row">
				<div class="md-col-6">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Criar">Cadastrar</button>

					<a class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	
	
		-->
<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
</body>
</html>