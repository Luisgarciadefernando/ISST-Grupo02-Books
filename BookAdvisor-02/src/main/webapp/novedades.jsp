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
        <title>BookAdvisor - Novedades</title>
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
                        <h2 class="text-uppercase">Novedades Editoriales</h2>
                        <hr class="templatemo-section-header-hr">
                        <p class="text-uppercase templatemo-section-subheader margin-bottom-0">Listado de novedades</p>
                    </div>
                </div>
                
                <c:forEach items="${novedades}" var="novedad">
                    <div class="row" style="margin-top:50px;">
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class="post-img-container" style="margin-top: -20px;">
                                    <img src="${novedad.libro.imagen}" class="post-img img-responsive" style="height: 300px;width: 200px;">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 text-left" style="margin-left: -250px";>
                            <div class="post-title">
                                <h3 class="text-uppercase"><c:out value="${novedad.libro.titulo}" /></h3>
                            </div>
                            <div class="post-meta-data">
                                <p class="gold-text"><i><strong>Editorial:</strong> <c:out value="${novedad.asignacionesEditoriales.editorial.nombre}" /></i></p>
                            </div>
                            <div class="post-excerpt gray-text">
                                <p><strong>Formato:</strong> <c:out value="${novedad.asignacionesEditoriales.formato}" /></p>
                            </div>
                            <div class="post-excerpt gray-text">
                                <p><Strong>Idioma:</Strong> <c:out value="${novedad.asignacionesEditoriales.idioma}" /></p>
                            </div>
                            <div class="post-excerpt gray-text">
                                <p><strong>Fecha de publicación:</strong> <c:out value="${novedad.asignacionesEditoriales.fecha}" /></p>
                            </div>
                        </div>
                    </div>
                <hr>  
                </c:forEach>

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