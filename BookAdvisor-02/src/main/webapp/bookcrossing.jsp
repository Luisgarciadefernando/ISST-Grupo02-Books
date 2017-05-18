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
               <div class="row">
                <!-- Main content -->
                <div class="row">
                    <div class="col-lg-12">
                        <h2 class="text-uppercase">Bookcrossing</h2>
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
							<li ><a href="bookcrossing">Bookcrossing</a></li>
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
                        
                </div>
            </div>
             <%int n=0;%>
             <c:forEach items="${bookcrossinglist}" var="booki">
             <%BookCrossing b = (BookCrossing)pageContext.getAttribute("booki");
             	Libro libro = LibroDAOImpl.getInstancia().readID(b.getLibro());
             	Lector user = LectorDAOImpl.getInstancia().readID(b.getLector());
             %>
                
                    <div class="conjuntoBook" style="margin-bottom: 100px;">
                    <div class="validarbook" style="width:50%;">
                        <div class="post-title">
                            <h3 class="text-uppercase" style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;"><%=libro.getTitulo() %></h3>
                        </div>
                        <div class="post-meta-data">
                            <p class="gold-text"><i><strong style="color:#333333">Dirección:</strong>&nbsp${booki.direccion}</i></p>
                        </div>
                        <div class="post-meta-data gold-text">
                            <p><i><strong style="color:#333333">Información:</strong>&nbsp${booki.informacion}</i></p>
                        </div>
                        <div class="bookcross">
                             <form class="" method="post" action="/bookcrossing">
                              <strong>¿Lo has encontrado? </strong>
                             <input  type="hidden"  name="encontrado" value="true">
                              <input class="form-control" placeholder="Introduce el código del libro" type="text" name="codigo" style="width: 50%;margin-top: 10px;">
                             <button type="submit" class="btn btn-primary"  id="boton-buscar" style="margin-left: 290px;margin-top: -59px; height: 100%;">Validar</button>
                        </form>
                        </div>
                        <div id="bookUser">
                            <p style="color:#D0B04C"><strong><span class="glyphicon glyphicon-user"></span>&nbspUsuario propietario del libro:&nbsp</strong><h11 style="color:black !important"><%=user.getNombre() %></h11></p>
                        </div>
                    </div>
                
                        <div class="fotobook" style="width:200px; height:250px;margin-left: 590px;border: solid;margin-top: -200px;">
                            <div class="post-img-container">
                                <a href="libro?id=${booki.libro}"><img src="${booki.imagen }" class="post-img img-responsive"></a>
                            </div>
                        </div>
                                                
                            <div id="map${booki.id}" style="width:250px !important; height:250px !important; margin-left: 850px;margin-top: -250px;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                 
     <script>
             
     
     <% String nS = String.valueOf(n);
     n++;
     %>
      function geocodeAddress<%=nS%>(geocoder, resultsMap) {
        var address = '${booki.direccion}';
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            //alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
      
    </script>              
                </c:forEach>
                
                       <script>
               
      function initMap() {
    	  <%n = 0; %>
                <c:forEach items="${bookcrossinglist}" var="booki">
                <%String nS=String.valueOf(n);
                n++;
                %>
                var map<%=nS%> = new google.maps.Map(document.getElementById('map${booki.id}'), {
          zoom: 15,
          center: {lat: -34.397, lng: 150.644}
        });
        var geocoder<%=nS%> = new google.maps.Geocoder();
          geocodeAddress<%=nS%>(geocoder<%=nS%>, map<%=nS%>);
                </c:forEach>
                  }
  
    </script> 
           
           
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
        <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnvg6gIvL86Ki2Gzkri258RHJ7M_3yckM&callback=initMap">
    </script> 

    </body>
</html>