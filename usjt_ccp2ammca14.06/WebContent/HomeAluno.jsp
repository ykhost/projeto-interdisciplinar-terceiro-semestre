<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<body style="background-image:url(images/background-home.jpg;);background-repeat:no-repeat;background-size:cover;background-position:center;height:100vh;">
    <c:import url="MenuAluno.jsp" />
    <div></div>
    <div class="register-photo" style="background-color:rgba(241,247,252,0);">
        <div class="form-container" style="font-size:50px;">
            <form style="background-color:rgba(255,255,255,0);color:rgb(255,255,255);width:452px;font-family:'Source Sans Pro', sans-serif;font-size:36px;">
                <h1 class="text-left" style="font-size:56px;font-family:Montserrat, sans-serif;"><strong>Bem vindo</strong></h1>
                <h4 class="text-left" style="font-size:38px;">sistema para controle de projetos interdisciplinares.<br></h4>
            </form>
            <form style="background-color:rgba(255,255,255,0);color:rgb(255,255,255);width:452px;font-family:'Source Sans Pro', sans-serif;">
                <h1 class="text-left" style="font-size:41px;font-family:Montserrat, sans-serif;"><strong>&nbsp;</strong><br></h1>
                <h4 class="text-left" style="font-size:26px;">&nbsp;</h4>
            </form>
        </div>
    </div>
   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    
</body>

</html>