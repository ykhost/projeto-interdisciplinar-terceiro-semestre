<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ProjetoInter</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700,800,900">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.css">
    <link rel="stylesheet" href="css/styles.min.css">
</head>

<body style="background-image:url(images/background.jpg;);background-repeat:no-repeat;background-size:cover;background-position:center;height:100vh;">
	<c:import url="MenuAdministrador.jsp" />
    <div class="register-photo" style="background-color:rgba(241,247,252,0);">
        <div class="form-container">
            <form action=controller.do method="post">
                <h2 class="text-center"><strong>${turma.sigla}</strong></h2>
            
                <div class="form-group"><strong>Semestre letivo: &nbsp;</strong>
                    <blockquote class="blockquote">
                        <p class="mb-0">${semestre}</p>
                       
                    </blockquote>
                </div>
                <div class="form-group"><strong>Ano letivo: &nbsp;</strong>
                    <blockquote class="blockquote">
                        <p class="mb-0">${turma.ano_letivo}</p>
                        
                    </blockquote>
                </div>
                <div class="form-group"><strong>Tema: &nbsp;</strong>
                    <blockquote class="blockquote">
                        <p class="mb-0">${turma.titulo}</p>
                        
                    </blockquote>
                </div>
                 
                <div class="form-group d-flex">
	              
	                
                	<a class="btn btn-primary btn-block voltar" href="controller.do?command=EditarTurma&id=${turma.id }">Editar</a>
                	<button class="btn btn-primary btn-block voltar" type="submit" name=command value=ListarTurmaReiniciar style="border-radius:20px;background-color:rgba(108,92,207,0);color:rgb(108,92,207);">Voltar</button>
                </div>
            </form>
        </div>
        <div style="height:17px;"></div>
        <div class="form-container"></div>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
  
</body>

</html>