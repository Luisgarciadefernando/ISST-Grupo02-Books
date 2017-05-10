<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Libro" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Lector" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LibroDAOImpl" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LibroDAO" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LectorDAOImpl" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.dao.LectorDAO" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.BookCrossing" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Bookcrossing</title>
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
        <link href="css/libros-style.css" rel="stylesheet">
        <link href="css/bookcrossing.css" rel="stylesheet">

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
 <%
    if (request.getSession().getAttribute("mensaje")!=null){
    	String mensaje = (String)request.getSession().getAttribute("mensaje");
    %>	
    	<div class="alert alert-warning">
    	  <strong><%= mensaje %></strong>
    	</div>
    <%
    	request.getSession().removeAttribute("mensaje");
    }
    %>
        <!-- "New Arrivals" -->
        <section class="container">
            <div class="row">
               <div class="row">
                <!-- Main content -->
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="text-uppercase">Bookcrosing</h2>
                        <hr class="templatemo-section-header-hr">
                        <p class="text-uppercase templatemo-section-subheader margin-bottom-0">Encuentra tu libro</p>
                    </div>
                </div>
                    <div id="buscador">
                           <form class="">
                              <strong>Buscar libro: </strong>
                              <input class="buscador" type="text" class="entrada-form form-control" id="busqueda">
                             <button type="submit" class="btn-default buscador" id="boton-buscar">Buscar</button>
                        </form>
                        
                        </div>
                    <nav class="templatemo-nav2" id = "nav-libros">
                        <ul class="text-uppercase">
                            <li class="active"><a href="#">BookCrossing</a></li>
                            <li ><a href="libros.html">Recomendados</a></li>
                            <li ><a href="libros.html">Novedades</a></li>
                        </ul> 
                    </nav>
                        
                </div>
            </div>
             <c:forEach items="${bookcrossinglist}" var="booki">
             <%BookCrossing b = (BookCrossing)pageContext.getAttribute("booki");
             	Libro libro = LibroDAOImpl.getInstancia().readID(b.getLibro());
             	Lector user = LectorDAOImpl.getInstancia().readID(b.getLector());
             %>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 text-left">
                        <div class="post-title">
                            <h3 class="text-uppercase"><%=libro.getTitulo() %></h3>
                        </div>
                        <div class="post-meta-data">
                            <p class="gold-text"><i>${booki.direccion}</i></p>
                        </div>
                        <div class="post-excerpt gray-text">
                            <p>${booki.informacion}</p>
                        </div>
                        <div class="post-excerpt gray-text">
                             <form class="" method="post" action="/bookcrossing">
                              <strong>Lo he encontrado: </strong>
                             <input type="hidden"  name="encontrado" value="true">
                              <input class="buscador" type="text" name="codigo" class="entrada-form form-control" id="busqueda">
                             <button type="submit" class="btn-default buscador"  id="boton-buscar">Validar</button>
                        </form>
                        </div>
                        <div class="post-excerpt gray-text">
                            <p><%=user.getNombre() %></p>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="post-img-container">
                                <a href="libro?id=${booki.libro}"><img src="img/<%=libro.getImagen()%>" class="post-img img-responsive"></a>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div id="google-map"><iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.1410705191!2d-3.6979402483875257!3d40.42787506278295!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd42288e8561bb0b%3A0xc07cc7157bae1a9f!2sPlaza+Alonso+Mart%C3%ADnez%2C+28004+Madrid!5e0!3m2!1ses!2ses!4v1491848366884" width="300" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
                            <div class="templatemo-block-right">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                </c:forEach>
            </div>
        </section> <!-- end "New Arrivals" -->

       
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