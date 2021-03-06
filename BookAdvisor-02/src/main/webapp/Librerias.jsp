<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="es.upm.dit.isst.bookAdvisor.model.Libreria" %>
<%@ page import="es.upm.dit.isst.bookAdvisor.model.AsignacionesLibrerias" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>BookAdvisor - Librerías</title>
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
        <link href="css/libraries-bookstores-style.css" rel="stylesheet">

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

        <!-- "Librerias" -->
        <div class="container" style="margin-top: 50px;">
            <div class="row">
                <!-- Main content -->
                <div class="row">
                    <div class="col-lg-12" style="margin-bottom: 40px;">
                        <h2 class="text-uppercase">Librerías</h2>
                        <hr class="templatemo-section-header-hr">
                        <c:if test="${not empty libro}">
                        	<p class="text-uppercase templatemo-section-subheader margin-bottom-0">Listado de librerías que disponen de <c:out value="${libro.titulo}"/></p>
                        </c:if>
                        <c:if test="${empty libro}">
                        	<p class="text-uppercase templatemo-section-subheader margin-bottom-0">Listado de librerías</p>
                       	</c:if>
                    </div>
                </div>
                

 				<%int n=0;%>
                <c:forEach items="${librerias}" var="libreria">
                	<c:if test="${libreria.confirmado != false}">
   <%-- 					<c:if test="${not empty asignacionesLibrerias}">
	                	<%
	                	List<AsignacionesLibrerias> asignacionesLibrerias = (List<AsignacionesLibrerias>)request.getSession().getAttribute("asignacionesLibrerias");
	                	Libreria libreria = (Libreria)pageContext.getAttribute("libreria");
	            		String formato = "";
	            		double precio = 0.0;
	                	for (AsignacionesLibrerias a: asignacionesLibrerias){
	                		if (a.getLibreria().equals(libreria.getId())){
	                			formato = a.getFormato();
	                			precio = a.getPrecio();
	                		}
	                	}
	                	%>
	                	<p class="gold-text"><i>Formato: <%= formato %></i></p>
	                	<p class="gold-text"><i>Precio: <%= precio %> euros</i></p>
	                </c:if>
	                --%>
                    <div class="row">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 text-left">
                            <div class="post-title">
                                <h3 class="text-uppercase"><c:out value="${libreria.nombre}" /></h3>
                            </div>
                            <div class="post-meta-data">
                                <p class="gold-text"><i><c:out value="${libreria.localizacion}" /></i></p>
                            </div>
                            <div>
			   					<c:if test="${not empty asignacionesLibrerias}">
			   						<c:forEach items="${asignacionesLibrerias}" var="a">
			   							<c:if test="${a.libreria ==libreria.id }">
			   								<p><strong style="color:#333333">Formato:</strong> <c:out value="${a.formato }"/></p>
				                			<p><strong style="color:#333333">Precio:</strong> <c:out value="${a.precio }"/> euros</p>
			                			</c:if>
			   		<%--					<%
					            		String formato = "";
					            		double precio = 0.0;
			   							AsignacionesLibrerias a = (AsignacionesLibrerias)pageContext.getAttribute("asignacionesLibrerias");
			   							Libreria libreria = (Libreria)pageContext.getAttribute("libreria");
			   							if (a.getLibreria().equals(libreria.getId())){
				                			formato = a.getFormato();
				                			precio = a.getPrecio();
				                		}
			   							%>
				                		<p class="gold-text"><i>Formato: <%= formato %></i></p>
				                		<p class="gold-text"><i>Precio: <%= precio %> euros</i></p>
				                		--%>
				                	</c:forEach>
				                </c:if>
			                </div>
                            <div class="post-excerpt gray-text">
                                <p><c:out value="${libreria.descripcion}" /></p>
                            </div>
                            <a href="${libreria.url}" class="gray-text margin-top-10 post-read-more">
                                <i class="fa fa-arrow-circle-o-right fa-2x v-align-middle"></i> Visitar la web
                            </a>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class="post-img-container">
                                    <img src="${libreria.imagen}" class="post-img img-responsive">
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class="templatemo-block-right">
                                    <div id="map${libreria.id}" style="height: 250px;width: 250px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                <hr>    
                <script>
             
     
     
     <% String nS = String.valueOf(n);
     n++;
     %>
      function geocodeAddress<%=nS%>(geocoder, resultsMap) {
        var address = '${libreria.localizacion}';
        geocoder.geocode({'address': address}, function(results, status) {
          if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
              map: resultsMap,
              position: results[0].geometry.location
            });
          } else {
            alert('Geocode was not successful for the following reason: ' + status);
          }
        });
      }
      
    </script>    
      
    </c:if>
                </c:forEach>

                <script>
               
      function initMap() {
    	  <%n = 0; %>
                <c:forEach items="${librerias}" var="libreria">
                <%String nS=String.valueOf(n);
                n++;
                %>
                var map<%=nS%> = new google.maps.Map(document.getElementById('map${libreria.id}'), {
          zoom: 15,
          center: {lat: -34.397, lng: 150.644}
        });
        var geocoder<%=nS%> = new google.maps.Geocoder();
          geocodeAddress<%=nS%>(geocoder<%=nS%>, map<%=nS%>);
                </c:forEach>
                  }
  
    </script> 
            

            </div>
                <div class="row">
                    <div class="col-lg-12 text-right">
                    
                </div>
            </div> <!-- end "Bibliotecas" -->
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
         <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnvg6gIvL86Ki2Gzkri258RHJ7M_3yckM&callback=initMap">
    </script> 
    </body>
</html>