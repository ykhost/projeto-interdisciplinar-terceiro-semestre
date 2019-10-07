<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<body style="background-image:url(images/usjt-1.jpg;); background-position:center;background-size:cover;background-repeat:no-repeat;">
    <div class="d-flex flex-row align-items-center align-content-center login-clean" style="background-color:rgba(241,247,252,0);height:100vh;">
        <form role="form" action="controller.do?command=Login" method="post">
            <div class="illustration" style="background-image:url(images/logo.png;);background-size:contain;background-repeat:no-repeat;background-position:center;height:74px;"></div>
            <div>
                <p>&nbsp;</p>
            </div>
            <div>
                <p class="text-center" style="color:rgb(247,0,0);">E-mail ou senha incorretos<br></p>
            </div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email" style="border-radius:20px;"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Senha" style="border-radius:20px;"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit" style="border-radius:20px;">ENTRAR</button></div><a href="#" class="forgot">Esqueci minha senha</a>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/aos/2.1.1/aos.js"></script>
    <script src="js/script.min.js"></script>
</body>

</html>