<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Valoracion" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Libro" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LibroDAO" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Usuario</title>
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
        <link href="css/libro-style.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="icon" type="image/png" href="img/logo2.png" />



    </head>
    <body>
      <%@include file="cabecera.jsp" %>
      
         <!-- end Header -->

        <!-- "New Arrivals" -->

               
		<p style="margin-left: 70px;margin-top: 30px;"><strong><span class="glyphicon glyphicon-user"></span>&nbspUsuario:</strong> ${lectorPerfil.nombre}
		 <br><strong style="margin-left: 20px;">Email:</strong>&nbsp${lectorPerfil.email}
		 
				<c:if test="${not empty admin}">
					<form action="/admin" method="post">
                     <input type="hidden" name="usuarioAEliminar" value="${lectorPerfil.id}">
                     <button class="button" type="submit" name="eliminaUsuario" value="true" style="margin-left: 90px;">Eliminar usuario</button>
                     <button class="button" href="/admin?usuarios=true" name="volverUsuario" value="true" style="margin-left: 20px;">Lista de usuarios</button>
                    
                     </p>
                 </c:if>
		<div id="comentarios"  class ="" style="margin-left: 65px;margin-top: 25px;margin-bottom: 25px;">
                        <h4 ><strong style="text-decoration: underline;">Comentarios de: ${lectorPerfil.nombre}:</strong></h4>

                     <c:if test="${not empty valoraciones}">
                      <c:forEach items="${valoraciones}" var="vali">
                      <p>
                    </p>
                    <%Valoracion valoracion = (Valoracion)pageContext.getAttribute("vali");
                    	LibroDAO librodao = LibroDAOImpl.getInstancia();
                    	Libro libro = librodao.readID(valoracion.getLibro());
                    	String titulo = libro.getTitulo();
                    %>
                    <h5><strong style="color:#D0B04C;"><span class="glyphicon glyphicon-heart-empty"></span>&nbsp<%= titulo %></strong></h5>
                    <p style="margin-left:20px !important;">
                     ${vali.comentario}
     
                     </p>
                     </c:forEach>
                        </c:if>
                    </div>
                    
       
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
