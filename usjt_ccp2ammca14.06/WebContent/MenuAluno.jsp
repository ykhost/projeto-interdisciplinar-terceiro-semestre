<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/styleMenu.css" rel="stylesheet"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous"/>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark sticky-top" id="navTop">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand text-dark" href="#">
   <span class="menu-superior ">Controle de PI</span>
  </a>
  <div class="collapse navbar-collapse"  id="navbarNavDropdown">
    <ul class="nav navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link text-dark" href="controller.do?command=logoff">Sair</a>
      </li>
      <li class="nav-item d-sm-block d-md-none">
        <a class="nav-link" href="#">Acompanhar Avaliações</a>
      </li>
      <li class="nav-item d-sm-block d-md-none">
        <a class="nav-link" href="#">Realizar Entrega</a>
      </li>
      <li class="nav-item d-sm-block d-md-none">
        <a class="nav-link" href="#">Consultar Entregas</a>
      </li>
      <li class="nav-item d-sm-block d-md-none">
        <a class="nav-link" href="#">Visualizar Cronograma</a>
      </li>
      
    </ul>
  </div>
</nav>


<div class="row" id="body-row">
    <div id="sidebar-container" data-toggle="menu" class="sidebar-collapsed  d-none d-md-block">
        <ul class="list-group">
            <a href="TelaConsultarAvaliacao3.jsp" class=" list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-tasks fa-fw mr-3"></span>
                    <span class="d-none menu-collapsed">Acompanhar Avaliações</span>    
                </div>
            </a>
             <a href="#" class=" list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class=" fa fa-file-upload fa-fw mr-3"></span>
                    <span class="d-none menu-collapsed">Realizar Entrega</span>    
                </div>
            </a>
             <a href="#" class=" list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class=" fa fa-list-alt fa-fw mr-3"></span>
                    <span class="d-none menu-collapsed">Consultar Entregas</span>    
                </div>
            </a>
             <a href="#" class=" list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class=" fa fa-calendar fa-fw mr-3"></span>
                    <span class="d-none menu-collapsed">Visualizar Cronograma</span>    
                </div>
            </a>
        </ul>
        
    </div>
    </div>
 
		<script src="js/jquery-3.4.0.js"></script>
		<script src="js/bootstrap.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			
		
		
		
		$('[data-toggle=menu]').hover(function() {
		    SidebarAbre();
		});

		function SidebarAbre () {
			$('.menu-collapsed').toggleClass('d-flex');
			$('#body-row .collapse').collapse('hide'); 
		    $('#sidebar-container').toggleClass('sidebar-expanded sidebar-collapsed');
		    
		    
		}
		});
		
		</script>
</body>
</html>