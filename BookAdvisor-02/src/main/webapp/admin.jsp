<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.upm.dit.isst.bookAdvisor.model.Editorial" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Admin</title>
        <meta name="description" content="">
        <meta name="author" content="templatemo">
        <!-- 
        Luxury Gold Template
        http://www.templatemo.com/preview/templatemo_456_luxury_gold
        -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,400italic,700' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Dancing+Script' rel='stylesheet' type='text/css'>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/editoriales-style.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" type="image/png" href="img/logo2.png" />
        
	</head>
	<body>
		<!-- Header -->
		 <%@include file="cabecera.jsp" %>
		<!-- end Header -->
		
		<!-- "Secciones" -->
        <section class="templatemo-white-bg">
            <div class="container" style="margin-bottom: 40px;">
                <div class="row">
                    <div class="col-lg-12" style="margin-bottom: -50px;">
                        <h2 class="text-uppercase">Administrador</h2>
                        <hr class="templatemo-section-header-hr">
                        <p class="text-uppercase templatemo-section-subheader">Página de administración</p>
                    </div>
                   
                </div>
	            
            </div>
            <nav class="templatemo-nav2" id = "nav-libros">
                        <ul class="text-uppercase">
                            <li ><a href="/admin">Libros pendientes</a></li>
							<li ><a href="/admin?usuarios=true">Usuarios</a></li>           
                        </ul> 
              </nav>
        </section> <!-- end Product Type -->
 	<c:forEach items="${librosPendientes}" var="libro">
 		   <section class="container">
 		  <form action="/admin" method="post">
            <div class="row">
                <div class="col-lg-12">
                    <h3 id="nombre-libro" class="text-uppercase" style="margin-bottom: -40px;">${libro.titulo}</h3>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader"></p>
                <div id ="div-derecha">
                    <div id="div-derecha-sub">
                    <div id="resumen" class ="derecha-dentro">
                        <h5><strong>Titulo:</strong></h5>
                        <input type="text" name="titulo" value="${libro.titulo}"><br>
                        <h5><strong>Resumen:</strong></h5>
                        <input type="text" name="resumen" value="${libro.resumen}"><br>
                        
                        <h5><strong>Autor:</strong></h5>
                        <input type="text" name="autor" value="${libro.autor}"><br>
                        <h5><strong>Género:</strong></h5>
                       <input type="text" name="genero" value="${libro.genero}"><br>
                       <input type="hidden" name="libroId" value="${libro.id}"><br>
                    </div>                    
                    </div>
                </div> 
                   
                </div>
            </div>
                <span>
             
                 <img  src="img/${libro.imagen}" style="width:300px; height:400px;" alt="Error al cargar la imagen" id="libro-image" class="img-rounded imagen-libro">
				<br>
                  </span>
                  <span>
                  </span>     
          <button action="submit" name="aceptar" value="true">Aceptar</button>
          <button action="submit" name="rechazar" value="true">Rechazar</button>
          </form>
        </section>
       </c:forEach>
 		
 		<!-- "About Us" -->
 		
        <!-- end "About Us" -->

        <footer class="text-center">
            <p class="text-uppercase">
                <img src="img/logo2.png" style="width: 50px;">
                2017 BookAdvisor 
            </p>
        </footer>
        <!-- JS -->
        <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>      <!-- jQuery -->
        <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->
   	</body>
</html>