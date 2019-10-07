<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">		
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Bootstrap CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Menu de Navegação Superior</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
	
					</button>
					<a class="navbar-brand" href="entrada?acao=ListarOrientadorCombo">Cadastro de Grupos</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-left">
						<li class="nav-item"><a href="buscarGruposAlunos.jsp">Listar
								Grupos</a></li>
						<li class="nav-item"><a href="AtualizarGrupo.jsp">Atualizar grupos</a>
						</li>		
						<li class="nav-item"><a href="entrada?acao=ListarGruposCombo">Realizar
								Entrega</a></li>
						
						<li><a href="ListarUmaEntrega.jsp">Listar Entregas</a></li>
					</ul>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-left">
	
					</ul>
				</div>
			</div>
		</nav>
		
		<script src="js/jquery.mim.js"></script>
		<script src="js/bootstrap.mim.js"></script>
	</body>
</html>