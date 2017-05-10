<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="es.upm.dit.isst.bookAdvisor.model.Lector" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Libro</title>
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
        <link href="css/home-style.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="img/logo2.png" />
        <style>
       

          .usuario{
            margin-top: -64px !important;
            margin-left: 120px !important; 
          }

          .credenciales {
            border: 2px solid #D0991E !important;
            padding-bottom: 15px;
            padding-top: 5px !important;
            width: 48% !important;
            margin-left: 60px !important;
            border-radius: 10px !important;
            margin-top: 10px !important;
          }

          h11{
            font-weight: bold !important;
            color: #D0991E !important;
          }

          h10{
            
            font-weight: bold !important;
            color: black !important;
          }

  
          
          .botones {
          	margin-left: 160px !important;
			margin-top: -140px;
          }
          
          .imagen {
          	margin-left:-10px !important;
          
          }
          
          .img-circle {
          width:80px !important;
          height: 80px !important;
          margin-left: 30px !important;
          
          }
          .log {
         margin-top: 24px !important;
		 margin-left: 23px !important;
		padding-bottom: 42px !important;
          }
          
        
          
          

        </style>

    </head>
    <body>
        <!-- Header -->
         <div class="templatemo-container">
            <div class="templatemo-block-left">
                <div class="templatemo-header-left">
                    <div class="templatemo-header-text-wrap">
                        <div class="templatemo-header-text">
                            <hr class="templatemo-header-hr">
                            <p class="text-uppercase templatemo-slogan">Passion for Reading</p>
                            <p><img src="img/logo1.png" align="right"></p>
                        </div>
                    </div>
                    <div class="templatemo-header-left-overlay"></div>
                    <div class="templatemo-social templatemo-gray-bg">
        

                    </div>
                </div>
            </div>
            <div class="templatemo-block-right">
                <div class="templatemo-header-right">
                    <div class="templatemo-header-right-overlay"></div>
                    <div class="mobile-menu-icon">
                        <i class="fa fa-bars"></i>
                    </div>
                    
                </div>
            </div>
        </div> 
      <div class="templatemo-container">
            <nav class="templatemo-nav">
                <ul class="text-uppercase">
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="/libros">Libros</a></li>
                    <li><a href="autores">Autores</a></li>
                    <li><a href="bibliotecas">Bibliotecas</a></li>
                    <li><a href="librerias">Librerías</a></li>
                    <li><a href="editoriales.jsp">Editoriales</a></li>
                     <li><a href="ofertas" style="margin-left: -15px;">Ofertas y descuentos</a></li>
        
                </ul>
            </nav>
        </div>
       <c:if test="${not empty admin}">
            
      <div class="credenciales">
        <div class="templatemo-container">
      	  <div class="imagen"><img src="img/no-disponible.jpg" alt="" class="img-circle"> </div>
          <div class="usuario">
      	     <h10>${lector.nombre}</h10> 
            <p><h11> Administrador </h11></p>
            
          </div>
          <div class="log">
          <a href="/admin" class="autenticado">Administración del sistema</a><br>
       	  <a href="/admin?usuarios=true" class="autenticado">Listado de usuarios</a><br>
       	  <a href="/admin?usuariosPendientes=true" class="autenticado">Listado de usuarios pendientes de confirmación</a><br>
       	  <a href="/logout" class="autenticado">Logout</a>
       	  </div>
          <div class="botones" style="margin-top: -163px !important;padding-bottom: 70px;">
          
            <!--<a href="/subir.jsp" class="autenticado">Subir ficha</a>-->
            <%@include file="subir.jsp" %>
         
         </div>
        </div>
      </div> 
        
     </c:if>
     <c:if test="${not empty lector and empty admin}">
            
      <div class="credenciales" style="padding-bottom: 67px !important;">
        <div class="templatemo-container">
      	  <div class="imagen"><img src="img/no-disponible.jpg" alt="" class="img-circle"> </div>
          <div class="usuario">
      	     <h10>${lector.nombre}</h10> 
            <p><h11> Lector </h11></p>
       	    
       	    </div>
       	    <div class="log">
       	    <a href="/logout" class="autenticado">Logout</a>
       	    </div>
          </div>
          
          <div class="botones">
         
            <!--<a href="/subir.jsp" class="autenticado">Subir ficha</a>-->
            <%@include file="subir.jsp" %>
          
          </div>
        </div>
     
        
     </c:if>
         <c:if test="${not empty libreria}">
        <div class="credenciales">
        <div class="templatemo-container">
          <div class="imagen"><img src="img/no-disponible.jpg" alt="" class="img-circle"> </div>
          <div class="usuario">
             <h10>${libreria.nombre}</h10> 
            <p><h11> Librería </h11></p>
            </div>
            <div class="log">
            <a href="/logout" class="autenticado">Logout</a>
          	</div>
          </div>
          <div class="botones">
          
            <!--<a href="/subir.jsp" class="autenticado">Subir ficha</a>-->
            <%@include file="subir.jsp" %>
            <!--<a href="/subirOferta.jsp" class="autenticado">Publicar oferta</a>-->
            <%@include file="subirOferta.jsp" %>
          
        </div>
        </div>
      
     </c:if>
         <c:if test="${not empty biblioteca}">
        <div class="credenciales" style="padding-bottom: 67px !important;">
        <div class="templatemo-container">
          <div class="imagen"><img src="img/no-disponible.jpg" alt="" class="img-circle"></div>
          <div class="usuario">
             <h10>${biblioteca.nombre}</h10> 
            <p><h11> Biblioteca </h11></p>
            </div>
            <div class="log">
            	<a href="/logout" class="autenticado">Logout</a>
         	</div>
         </div>
          <div class="botones">
          
            <!--<a href="/subir.jsp" class="autenticado">Subir ficha</a>-->
            <%@include file="subir.jsp" %>
          
          </div>
        </div>
     
     </c:if>
      <c:if test="${not empty editorial}">
        <div class="credenciales" style="padding-bottom: 122px !important;">
        <div class="templatemo-container">
          <div class="imagen"><img src="img/no-disponible.jpg" alt="" class="img-circle"> </div>
          <div class="usuario">
             <h10>${editorial.nombre}</h10> 
            <p><h11> Editorial </h11></p>
            </div>
            <div class="log">
            	<a href="/logout" class="autenticado">Logout</a>
          	</div>
          </div>
        <div class="botones">
        </div>
        </div>
    
     </c:if>
         <!-- end Header -->


</body>
</html>