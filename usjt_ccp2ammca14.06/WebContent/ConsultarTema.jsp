<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<body style="background-image:url(images/background.jpg;);background-repeat:no-repeat;background-size:cover;background-position:center;height:150vh;">

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

    <div class="register-photo" style="background-color:rgba(241,247,252,0);">
        <div class="form-container"></div>
        <div style="height:17px;"></div>
        <div class="form-container">
               <form action="controller.do" method="get">
                <div class="container">
                    <h1 class="text-left" style="font-size:23px;">Pesquise um tema</h1>
                    <div class="d-flex flex-column justify-content-center">
                        <div class="container d-flex flex-row justify-content-center" style="height:35px;line-height:24px;/*border-radius:2;*/">
                        			<input name="data[search]" class="form-control" id="search" type="text" placeholder="Digite o t�tulo do tema (deixe vazio para trazer todos)" style="border-radius:20px;">
                        			
                            <div class="btn-toolbar d-flex justify-content-start" data-aos="fade" data-aos-duration="200">
                                
                                <div class="btn-group" role="group"></div>
                            </div>
                        	
                        	<button type="submit" name="command" value="ListarTemaBuscar" style="font-size:20px;border-radius:20px;background-color:rgba(208,108,129,0)"><i class="nav-link text-dark fas fa-search" style="font-size:20px;"></i></button>
                        </div>
                         <div class="form-group d-flex flex-row">
		                    <button class="btn btn-primary btn-block" type="submit" name="command" value="CargaTema" style="border-radius:20px;">Cadastrar Tema</button>
		                    <button class="btn btn-primary btn-block" type="submit" name="command" value="ListarTemaReiniciar" style="border-radius:20px;background-color:rgba(208,108,129,0);color:rgb(0,31,191);">Limpar</button>
               			</div>
                    </div>
               
            </form>
             <c:if test="${not empty lista}">
            	<div class="table-responsive" style="margin-top:13px ;">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Titulo</th>
                            <th><br>Introdu��o</th>
                            <th>Requisitos</th>
                            <th>Data de cadastro</th>
                        </tr>
                    </thead>
                    <tbody>
                     <c:forEach var="tema" items="${lista}">
                        <tr>
                            <td>${tema.titulo}</td>
                            <td>${tema.introducao}</td>
                            <td>${tema.requisitos}</td>
                            <td><fmt:formatDate value="${tema.dtCadastro}" pattern="dd/MM/yyyy"/></td>
                            <td class="actions">
                                    <a class="btn btn-success btn-xs" href="controller.do?command=VisualizarTema&id=${tema.id}" style="background-color:#5DA1FF; border-color:#5DA1FF; color:white"><i class="fas fa-eye"></i></a>  
                           </td>
                        </tr>
                        	</c:forEach>
                    </tbody>
                </table>
            </div>
           </c:if>
            
        </div>
        
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>

</html>