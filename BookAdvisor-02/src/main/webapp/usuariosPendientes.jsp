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
                        <h2 class="text-uppercase">Usuarios pendientes</h2>
                        <hr class="templatemo-section-header-hr">
                        <p class="text-uppercase templatemo-section-subheader">Página de administración</p>
                    </div>
                   
                </div>
	            
            </div>
            
        </section> <!-- end Product Type -->
 	<c:forEach items="${libreriasPendientes}" var="libreria">
 		   <section class="container">
 		  <form action="/admin" method="post">
            <div class="row" style="margin-top:-100px;margin-bottom: 200px;">
                    <h3 id="nombre-libreria" class="text-uppercase" style="margin-bottom: -40px;">${libreria.nombre} (Librería)</h3>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader"></p>
                	<div id ="div-izq">
                        <h5><strong>Nombre:</strong></h5>
                        <input type="text" name="nombre" value="${libreria.nombre}"><br>
                        <h5><strong>Localización:</strong></h5>
                        <input type="text" name="localizacion" value="${libreria.localizacion}"><br>
                        <h5><strong>Descripción:</strong></h5>
                        <textarea type="text" name="descripcion" style="resize: inherit;height: 100px;">${libreria.descripcion}</textarea><br>
                        <h5><strong>Url:</strong></h5>
                        <input type="text" name="url" value="${libreria.url}"><br>
                        <h5><strong>Email:</strong></h5>
                       <input type="text" name="email" value="${libreria.email}"><br>
                       <input type="hidden" name="libreriaId" value="${libreria.id}"><br>
                       
                	</div>    
             		<div id="div-derecha" style="margin-left: 270px;margin-top: -380px;">
                		 <img  src="${libreria.imagen}" style="width:200px; height:200px;border: black solid;border-radius: 100px;" alt="Error al cargar la imagen" id="libreria-image" class="img-rounded imagen-libro">
							
          						<button style="margin-left:20px;" action="submit" name="aceptarLibreria" value="true" class="button">Aceptar</button>
          						<button style="margin-left:10px;" action="submit" name="rechazarLibreria" value="true" class="button">Rechazar</button>
                			
                	</div> 
           		
           </div>
          </form>
        </section>
       </c:forEach>
       <c:forEach items="${bibliotecasPendientes}" var="biblioteca">
 		   <section class="container">
 		  <form action="/admin" method="post">
            <div class="row" style="margin-top:-100px;margin-bottom: 200px;">
                    <h3 id="nombre-biblioteca" class="text-uppercase" style="margin-bottom: -40px;">${biblioteca.nombre} (Biblioteca)</h3>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader"></p>
                	<div id ="div-izq">
                        <h5><strong>Nombre:</strong></h5>
                        <input type="text" name="nombre" value="${biblioteca.nombre}"><br>
                        <h5><strong>Localización:</strong></h5>
                        <input type="text" name="localizacion" value="${biblioteca.localizacion}"><br>
                        <h5><strong>Descripción:</strong></h5>
                        <textarea type="text" name="descripcion" style="resize: inherit;height: 100px;">${biblioteca.descripcion}</textarea><br>
                        <h5><strong>Url:</strong></h5>
                        <input type="text" name="url" value="${biblioteca.url}"><br>
                        <h5><strong>Email:</strong></h5>
                       <input type="text" name="email" value="${biblioteca.email}"><br>
                       <input type="hidden" name="bibliotecaId" value="${biblioteca.id}"><br>
                       
                	</div>    
             		<div id="div-derecha" style="margin-left: 270px;margin-top: -380px;">
                		 <img  src="${biblioteca.imagen}" style="width:200px; height:200px;border: black solid;border-radius: 100px;" alt="Error al cargar la imagen" id="libreria-image" class="img-rounded imagen-libro">
							
          						<button style="margin-left:20px;" action="submit" name="aceptarBiblioteca" value="true" class="button">Aceptar</button>
          						<button style="margin-left:10px;" action="submit" name="rechazarBiblioteca" value="true" class="button">Rechazar</button>
                			
                	</div> 
           		
           </div>
          </form>
        </section>
       </c:forEach>
       
       <c:forEach items="${editorialesPendientes}" var="editorial">
 		   <section class="container">
 		  <form action="/admin" method="post">
            <div class="row" style="margin-top:-100px;margin-bottom: 40px;">
                    <h3 id="nombre-editorial" class="text-uppercase" style="margin-bottom: -40px;">${editorial.nombre} (Editorial)</h3>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader"></p>
                	<div id ="div-izq">
                        <h5><strong>Nombre:</strong></h5>
                        <input type="text" name="nombre" value="${editorial.nombre}"><br>
                        <h5><strong>Email:</strong></h5>
                       <input type="text" name="email" value="${editorial.email}"><br>
                       <input type="hidden" name="editorialId" value="${editorial.id}"><br>
                    </div>
                    
                    <div id="div-derecha" style="margin-left: 270px;margin-top: -175px;">
                		 <img  src="${editorial.imagen}" style="width:200px; height:200px;border: black solid;border-radius: 100px;" alt="Error al cargar la imagen" id="libreria-image" class="img-rounded imagen-libro">
							
          					<button style="margin-left:20px;" action="submit" name="aceptarEditorial" value="true" class="button">Aceptar</button>
          					<button style="margin-left:10px;" action="submit" name="rechazarEditorial" value="true" class="button">Rechazar</button>
                			
                	</div> 
           		 
                      
               </div> 
           		
       
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