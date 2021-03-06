<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="es.upm.dit.isst.bookAdvisor.model.Libro" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Libros</title>
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

       
        <link rel="icon" type="image/png" href="img/logo2.png" />
        <style>
			.templatemo-nav2>li {
				float:left;
			}
			
			.templatemo-nav2 li a {
				background-color:#000;
				display:block;
			}
			
			.templatemo-nav2 li a:hover {
				background-color:#434343;
			}
			
			.templatemo-nav2 li ul {
				display:none;
				position:absolute;
				min-width:140px;
			}
			
			.templatemo-nav2 li:hover > ul {
				display:block;
			}   
		
		
		</style>

    </head>
    <body>
            <!-- Header -->
 		<%@include file="cabecera.jsp" %>
    
        <!-- end Header -->

        <!-- "New Arrivals" -->
        <section class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2 class="text-uppercase">Libros</h2>
                    <hr class="templatemo-section-header-hr">
                     <p class="text-uppercase templatemo-section-subheader margin-bottom-0">Listado de libros</p>
                     </div>
                </div>
                    <div id="buscador">
                           <form class="" action="/libros" method="get">
                              <strong>Buscar libro: </strong>
                              <input class="buscador" name = "busqueda" type="text" class="entrada-form form-control" id="busqueda">
                             <button type="submit" class="btn-default buscador" id="boton-buscar">Buscar</button>
                        </form>
                        
                        </div>
                    
                    <c:if test="${not empty lector}">
                    <nav class="templatemo-nav2" id = "nav-libros">
                        <ul class="text-uppercase">
                            <li ><a href="libros?recomendados=true">Recomendados</a></li>
							<li ><a href="bookcrossing">Bookcrossing</a></li>
                            <li><a href="libros?novedades=true">Novedades</a></li>
                            <li><a href="">Género</a>
                    			<ul>
             				 		<li><a href="/libros?genero=aventura">Aventura</a></li>
              				 		<li><a href="/libros?genero=cienciaficcion">Ciencia ficción</a></li>
             				 		<li><a href="/libros?genero=policia">Policial</a></li>
             			     		<li><a href="/libros?genero=romantico">Romántico</a></li>
              				 		<li><a href="/libros?genero=terror">Terror</a></li>
           			    		</ul> 
           					</li>      
                        </ul> 
                    </nav>
                    </c:if>
                    <c:if test="${empty lector}">
                    <nav class="templatemo-nav2" id = "nav-libros" style="width: 420px;">
                        <ul class="text-uppercase">
                            <li ><a href="libros?recomendados=true">Recomendados</a></li>
							
                            <li><a href="libros?novedades=true">Novedades</a></li>
                            <li><a href="">Género</a>
                    			<ul>
             				 		<li><a href="/libros?genero=aventura">Aventura</a></li>
              				 		<li><a href="/libros?genero=cienciaficcion">Ciencia ficción</a></li>
             				 		<li><a href="/libros?genero=policia">Policial</a></li>
             			     		<li><a href="/libros?genero=romantico">Romántico</a></li>
              				 		<li><a href="/libros?genero=terror">Terror</a></li>
           			    		</ul> 
           					</li>      
                        </ul> 
                    </nav>
                    </c:if>
                </div>
            </div>

           
            <% int columna = 0; %>
            <c:forEach items="${libros}" var="libroi">
            <%if(columna == 0) {%>
            <div class="row">
            <%} %>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 text-center">
              <div class="new-arrival-container" style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">   
              <strong>${libroi.titulo}</strong> <br> (<span class="glyphicon glyphicon-star"></span>:&nbsp${libroi.valoracion})<br>    
              <a href="libro?id=${libroi.id}"><img src="${libroi.imagen}" alt="Imagen no encontrada" class="img-rounded imagen-libro" style="border: solid black;margin-top: 10px;"> </a>

              </div>
            </div>
            <%if(columna == 2) {%>
            </div>
            <%
            columna = 0;
            } else {
            columna++;
            }%>
            </c:forEach>
            <%if(columna != 2) {%>
            </div>
            <%} %>
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