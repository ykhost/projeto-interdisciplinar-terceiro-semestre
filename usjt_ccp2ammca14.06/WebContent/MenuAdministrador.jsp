<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/styleMenu.css" rel="stylesheet"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
		<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous"/>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark sticky-top" id="navTop">
  <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand text-dark" href="#">
   <span class="menu-superior">Controle de PI</span>
  </a>
  <div class="collapse navbar-collapse"  id="navbarNavDropdown">
    <ul class="nav navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link text-dark" href="controller.do?command=logoff">Sair</a>
      </li>
        <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Alunos
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item text-dark" href="#">Cadastrar Alunos</a>
            <a class="dropdown-item text-dark" href="#">Consultar Alunos</a>
            <a class="dropdown-item text-dark" href="#">Alterar Alunos</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle  text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Temas
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="controller.do?command=CargaTema">Cadastrar Temas</a>
            <a class="dropdown-item" href="controller.do?command=ListarTemaReiniciar">Consultar Temas</a>
            <a class="dropdown-item" href="#">Alterar Temas</a>
            <a class="dropdown-item" href="#">Selecionar Temas</a>
            <a class="dropdown-item" href="#">Associar Turmas e Temas</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Grupos
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="#">Cadastrar Grupos</a>
            <a class="dropdown-item" href="#">Consultar Grupos</a>
            <a class="dropdown-item" href="#">Alterar Grupos</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Professores
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="#">Cadastrar Professores</a>
            <a class="dropdown-item" href="#">Consultar Professores</a>
            <a class="dropdown-item" href="#">Alterar Professores</a>
            <a class="dropdown-item" href="#">Associar Orientador a Turma</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Cadastrar Avaliação
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="#">Cadastrar Avaliação Semanal</a>
            <a class="dropdown-item" href="#">Consultar Avaliação Semanal</a>
            <a class="dropdown-item" href="#">Cadastrar Avaliação de Banca</a>
            <a class="dropdown-item" href="#">Consultar Avaliação de Banca</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Atividade
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="controller.do?command=CargaAtividade">Cadastrar  Atividade</a>
            <a class="dropdown-item" href="controller.do?command=ListarAtividadeReiniciar">Consultar Atividade</a>
            <a class="dropdown-item" href="#">Alterar Atividade</a>
        </div>
      </li>
      <li class="nav-item dropdown d-sm-block d-md-none">
        <a class="nav-link dropdown-toggle text-dark" href="#" id="smallerscreenmenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gerenciar Banca
        </a>
        <div class="dropdown-menu" aria-labelledby="smallerscreenmenu">
            <a class="dropdown-item" href="#">Cadastrar Banca</a>
            <a class="dropdown-item" href="#">Consultar Banca</a>
            <a class="dropdown-item" href="#">Alterar Banca</a>
        </div>
      </li>
      <li class="nav-item d-sm-block d-md-none text-dark">
        <a class="nav-link" href="#">Gerar Declaração</a>
      </li>
      <li class="nav-item d-sm-block d-md-none text-dark">
        <a class="nav-link" href="#">Consultar Entregas</a>
      </li>
      <li class="nav-item d-sm-block d-md-none text-dark">
        <a class="nav-link" href="#">Consultar Cronograma</a>
      </li>
      
      
    </ul>
  </div>
</nav>

<div class="row text-dark" id="body-row">
    <div id="sidebar-container" data-toggle="menu" class="sidebar-collapsed d-none d-md-block">
        <ul class="list-group">         
            <a href="#submenuAluno" data-toggle="collapse" aria-expanded="false" class="list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-address-card fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Alunos</span>
                    <span class="fa fa-caret-down ml-auto menu-collapsed d-none"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuAluno' class="collapse sidebar-submenu">
                <a href="TelaAluno2.jsp" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Alunos</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Alunos</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Alunos</span>
                </a>
            </div>
            <a href="#submenuTurma" data-toggle="collapse" aria-expanded="false" class="list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-users fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Turmas</span>
                    <span class="fa fa-caret-down ml-auto menu-collapsed d-none"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuTurma' class="collapse sidebar-submenu">
                <a href="controller.do?command=CargaTurma" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Turmas</span>
                </a>
                <a href="controller.do?command=ListarTurmaReiniciar" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Turmas</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Turmas</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Selecionar Turmas</span>
                </a>
                <a href="AlunoTurma.jsp" class=" text-dark list-group-item list-group-item-action">
                    <span class="menu-collapsed">Associar aluno a turma</span>    
            	</a>
            </div>
             <a href="#submenuTema" data-toggle="collapse" aria-expanded="false" class=" list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-clipboard fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Temas</span>
                    <span class="fa fa-caret-down ml-auto menu-collapsed d-none"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuTema' class="collapse sidebar-submenu">
                <a href="controller.do?command=CargaTema" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Temas</span>
                </a>
                <a href="controller.do?command=ListarTemaReiniciar" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Temas</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Temas</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Selecionar Temas</span>
                </a>
                <a href="#" class=" text-dark list-group-item list-group-item-action">
                    <span class="menu-collapsed">Associar Turmas e Temas</span>    
            	</a>
            </div>
            <a href="#submenuGrupo" data-toggle="collapse" aria-expanded="false" class=" list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-user-friends fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Grupos</span>
                    <span class="fa fa-caret-down ml-auto menu-collapsed d-none"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuGrupo' class="collapse sidebar-submenu">
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Grupos</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Grupos</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Grupos</span>
                </a>
            </div>
            <a href="#submenuProfessor" data-toggle="collapse" aria-expanded="false" class=" list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-user fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Professores</span>
                    <span class="fa fa-caret-down ml-auto menu-collapsed d-none"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuProfessor' class="collapse sidebar-submenu">
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Professores</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Professores</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Professores</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Associar Orientador a Turma</span>
                </a>
            </div>
            <a href="#submenuAvaliacao" data-toggle="collapse" aria-expanded="false" class="list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-check fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Cadastrar Avaliação</span>
                    <span class="fa fa-caret-down d-none ml-auto menu-collapsed"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuAvaliacao' class="collapse sidebar-submenu">
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Avaliação Semanal</span>
                </a>
                <a href="TelaConsultarAvaliacao2.jsp" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Avaliação Semanal</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Avaliação de Banca</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Avaliação de Banca</span>
                </a>
            </div>
            <a href="#submenuAtividade" data-toggle="collapse" aria-expanded="false" class="list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-tasks fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Atividades</span>
                    <span class="fa fa-caret-down d-none ml-auto menu-collapsed"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuAtividade' class="collapse sidebar-submenu">
                <a href="controller.do?command=CargaAtividade" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Atividade</span>
                </a>
                <a href="controller.do?command=ListarAtividadeReiniciar" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Atividade</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Atividade</span>
                </a>
            </div>
            <a href="#submenuBanca" data-toggle="collapse" aria-expanded="false" class="list-group-item text-dark list-group-item-action flex-column align-items-start">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-chalkboard-teacher fa-fw mr-3"></span> 
                    <span class="menu-collapsed d-none">Gerenciar Banca</span>
                    <span class="fa fa-caret-down d-none ml-auto menu-collapsed"></span>
                </div>
            </a>
            <!-- Submenu content -->
            <div id='submenuBanca' class="collapse sidebar-submenu">
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Cadastrar Banca</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Consultar Banca</span>
                </a>
                <a href="#" class="list-group-item list-group-item-action text-dark">
                    <span class="menu-collapsed">Alterar Banca</span>
                </a>
            </div>
            <a href="#" class="list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-scroll fa-fw mr-3"></span>
                    <span class="menu-collapsed d-none">Gerar Declaração</span>
                </div>
            </a>
            <a href="#" class="list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-newspaper fa-fw mr-3"></span>
                    <span class="menu-collapsed d-none">Consultar Entregas</span>
                </div>
            </a>
             <a href="#" class=" list-group-item text-dark list-group-item-action">
                <div class="d-flex w-100 justify-content-start align-items-center">
                    <span class="fa fa-calendar fa-fw mr-3"></span>
                    <span class="menu-collapsed d-none">Visualizar Cronogama</span>
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