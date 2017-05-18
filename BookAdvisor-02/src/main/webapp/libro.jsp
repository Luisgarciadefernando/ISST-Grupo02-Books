<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Valoracion" %>
<%@ page import = "es.upm.dit.isst.bookAdvisor.model.Libro" %>
<!DOCTYPE html>
<html lang="en">
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
        <section class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h3 id="nombre-libro" class="text-uppercase" style="margin-bottom: -40px;">${libro.titulo}</h3>
                    <hr class="templatemo-section-header-hr">
                    <p class="text-uppercase templatemo-section-subheader"></p>
                <div id ="div-derecha" style="margin-top:20px; margin-left:344px;">
                    <div id="div-derecha-sub">
                    <div id="resumen" class ="derecha-dentro">
                        <h5><strong>Resumen:</strong></h5>
                        <h6>${libro.resumen}
                        </h6>
                        <h5><strong>Autor:</strong></h5>
                        <h6>${libro.autor}
                        </h6>
                        <h5><strong>Género:</strong></h5>
                        <h6>${libro.genero}
                        </h6>
                        
                    </div>
                    
                    
                    <div id="valoracion"  class ="derecha-dentro">
                    Valoracion: ${libro.valoracion }<br>
                    Veces valorado:&nbsp<span class="badge"> ${libro.vecesValorado}</span><br>
                    <%Libro libro = (Libro)request.getSession().getAttribute("libro"); 
                    	int valoracionEntera = (int)libro.getValoracion();
                    	int estrellas =0;
                    	for (int i=0; i<5; i++){
                    		if(estrellas<valoracionEntera){
                    			estrellas++;
                    			%>
                    			 <label class="estrella-llena">&#9733;</label>
                    			<% 
                    		}
                    		else {
                    			
                    			%>
                    			 <label class="estrella-vacia">&#9733;</label>
                    			
                    <% 
                    		}
                    	}
                    %>
                      <!--  <label class="estrella-llena">&#9733;</label>
                      <label class="estrella-llena">&#9733;</label>
                      <label class="estrella-llena">&#9733;</label>
                      <label class="estrella-vacia">&#9733;</label>
                      <label class="estrella-vacia">&#9733;</label>
                      -->
                    </div>

                    
                    </div>
                </div>
                
                 <c:if test="${not empty lector and empty valoracion and empty admin}">
                  <div id="div-derecha2" style="margin-top: 20px;">
                    <div id="div-derecha2-sub">
                   
                    <div id="nuevo-comentario"  class ="derecha-dentro">
                        <h5 style="text-align: center;"><strong>Añadir valoración:</strong></h5>
                        <form class="" method="post" action="/valoracion">
                        <div class="rating">
  							  <span><input  class="star" type="radio" name="rating" id="str5" value="5"><label for="str5"></label></span>
  							  <span><input class="star" type="radio" name="rating" id="str4" value="4"><label for="str4"></label></span>
  							  <span><input class="star" type="radio" name="rating" id="str3" value="3"><label for="str3"></label></span>
   						  	 <span><input class="star" type="radio" name="rating" id="str2" value="2"><label for="str2"></label></span>
    						<span><input class="star" type="radio" name="rating" id="str1" value="1"><label for="str1"></label></span>
							</div>
							
							<input type="hidden" name="valoracionUser" id="valoracionUser" value="0">
							<input type="hidden" name="libro" id="libro" value="${libro.id}">
                             <textarea class="form-control" name="comentario" rows="5" id="comment"></textarea>
                             <button  type="submit" class="btn-default buscador" id="boton-comentar">Añadir</button>
                        </form>
                    </div>
                    
                    </div>
                   </div>
                    </c:if>  
                   
                </div>
            </div>
                <span>
             
                 <img style="border: black solid;" src="${libro.imagen}" alt="Error al cargar la imagen" id="libro-image" class="img-rounded imagen-libro">
                
                  </span>
                  <span>
                  </span>     
          
        </section> <!-- end "New Arrivals" -->

 
 		 
	
	
	<div id="botons2" style="margin-top: -30px;margin-bottom: 50px;margin-left: 70px;">
                   
                   
                   <c:if test="${not empty lector and empty loTiene and empty admin}">
                   
                        <form action="/intercambio" method="post" id="form-intercambio" >
                        <input type="hidden" name="tengo" value="true">
                        <input type="hidden" name="libro" value="${libro.id}" >
                        <div id="LotengoIntercambio" style="margin-left: 100px;">
                        <button class="button" type="submit" >Lo tengo para intercambio</button>
                        </div>
                        </form>
                        <div class="BookCross" style="margin-left:-200px; margin-bottom: 50px;">
                        <%@include file="formbookcrossing.jsp" %>
                        </div>
                        
                  	 	
                    </c:if>  
                     
                     
                     
                    <c:if test="${not empty lector and not empty loTiene}">
                        <div id="SiLotengo" style="margin-left:100px;">
                        	<p><Strong><span class="glyphicon glyphicon-hand-right"></span>&nbspLo tienes para intercambio</Strong></p> 	
                    	</div>
                    	<div class="BookCross2" style="margin-left: -201px;margin-bottom: 50px;">
                   		<%@include file="formbookcrossing.jsp" %>
                        </div>
                    </c:if>
         
                     
                   
                      <c:if test="${not empty libreria and empty loTiene}">
                   
                        <form action="/asignaLibreria" method="post" id="form-asignaLibreria" style="margin-bottom: 10px;">
                        <div id="formato" style="margin-bottom: 10px;">
                        <strong>Formato:&nbsp</strong>
                        <select class="form-control" required="" name="formato" id="formato" style="text-align:center;width: 18%;margin-left: 70px;margin-top: -26px;">
                        <option value="Sin Formato">Seleccione un formato</option>
                        <option value="Tapa dura">Tapa dura</option> 
                        <option value="Tapa blanda">Tapa blanda</option>
                        <option value="eBook">eBook</option> 
                        </select>
                        <br>
                        <strong style="margin-left: 0px;">Precio:&nbsp</strong>
                        <input class="form-control"required="" type="number" name="precio" step="0.50" min="1" style="margin-top: 10px;width: 8.4%;text-align:center;margin-left: 60px;margin-top: -25px;margin-bottom:-30px;">
                        <strong style="margin-left: 170px;">Euros</strong>
                        
                        <input type="hidden" name="tengo" value="true">
                        <input type="hidden" name="libro" value="${libro.id}" >
                        </div>
                        <button class="button" type="submit" style="margin-top: 10px;" >Lo tengo</button>
                        </form>
                  	 	
                    </c:if>  

                      <c:if test="${not empty biblioteca and empty loTiene}">
                   
                        <form action="/asignaBiblioteca" method="post" id="form-asignaLibreria" style="margin-bottom: 10px;">
                        <div id="formato" style="margin-bottom: 10px;">
                        <strong>Formato:&nbsp</strong>
                        <select  class="form-control" required="" name="formato" id="formato" style="text-align:center;width: 18%;margin-left: 70px;margin-top: -26px;">
                        <option value="Sin Formato">Seleccione un formato</option>
                        <option value="Tapa dura">Tapa dura</option> 
                        <option value="Tapa blanda">Tapa blanda</option>
                        <option value="eBook">eBook</option> 
                        </select>                    
                        <input type="hidden" name="tengo" value="true">
                        <input type="hidden" name="libro" value="${libro.id}" >
                        </div>
                        <button class="button" type="submit" >Lo tengo</button>
                        </form>
                  	 	
                    </c:if>     
                                     
                    <c:if test="${not empty editorial and empty loTiene}">
                   
                        <form action="/asignaEditorial" method="post" id="form-asignaEditorial" style="margin-bottom: 10px;">
                        <div id="formato" style="margin-bottom: 10px;">
                        <strong>Formato:&nbsp</strong>
                        <select  class="form-control" required="" name="formato" id="formato" style="text-align:center;width: 18%;margin-left: 70px;margin-top: -25px;">
                        <option value="Sin Formato">Seleccione un formato</option>
                        <option value="Tapa dura">Tapa dura</option> 
                        <option value="Tapa blanda">Tapa blanda</option>
                        <option value="eBook">eBook</option> 
                        </select>
                        <br>
                        <strong style="margin-left: 0px;">Idioma:&nbsp</strong>
                        <select class="form-control" required="" name="idioma" id="idioma" style="text-align:center;width: 18%;margin-left: 70px;margin-top: -25px;">
                        <option value="Sin idioma">Seleccione un idioma</option>
                        <option value="Espanol">Español</option> 
                        <option value="Ingles">Inglés</option>
                        <option value="Aleman">Alemán</option> 
                        <option value="Frances">Francés</option> 
                        </select>
                        
                        <input type="hidden" name="tengo" value="true">
                        <input type="hidden" name="libro" value="${libro.id}" >
                        </div>
                        <button class="button" type="submit" >Lo tengo</button>
                        </form>
                  	 	
                    </c:if> 
                    
                    <c:if test="${not empty libreria and not empty loTiene and not empty asignacionlib}">
                   	<div id="lotienes" style="margin-bottom: 10px;">
                        <strong><span class="glyphicon glyphicon-book"></span>&nbspLo tienes a un precio de:</strong> ${asignacionlib.precio} Euros<br>
                        <strong>En formato:</strong> ${asignacionlib.formato}
                  	 	</div>
                    </c:if>    
     				
     				<c:if test="${not empty biblioteca and not empty loTiene and not empty asignacionbib}">
                   	<div id="lotienes" style="margin-bottom: 10px;">
                        <strong><span class="glyphicon glyphicon-book"></span>&nbspLo tienes para alquilar en formato:</strong> ${asignacionbib.formato}
                  	 	</div>
                    </c:if>                    
                    
                
                <c:if test="${not empty lector}">
                   <form action="/disponibilidad" method="get">
                   <input type="hidden" value="true" name="intercambio">
                   <input type="hidden" value="${libro.id}" name="libro">
                   <button class="button" type="submit" >Disponibilidad intercambio</button><br>
                   </form>
                   <form action="/disponibilidad" method="get" style="margin-left: 160px;margin-top: -30px;">
                   <input type="hidden" value="true" name="librerias">
                   <input type="hidden" value="${libro.id}" name="libro">
                   <button class="button" type="submit" >Disponibilidad librerias</button>
                   </form>
                   <form action="/disponibilidad" method="get" style="margin-left: 300px;margin-top: -30px;">
                   <input type="hidden" value="true" name="bibliotecas">
                   <input type="hidden" value="${libro.id}" name="libro">
                   <button class="button" type="submit" >Disponibilidad bibliotecas</button>
                   </form>
                </c:if>    

    </div>
    
    <c:if test="${not empty lector and not empty valoracion}">
 					<div id="valoracion"  class ="" style="margin-left: 65px;margin-top: -25px;margin-bottom: 30px;">
                        <h4 class="text-uppercase" style="margin-bottom: -1px">Mi valoración:</h4>
                        <hr class="templatemo-section-header-hr">
                        
                        <h5><strong style="color:#D0B04C;"><span class="glyphicon glyphicon-heart-empty"></span>&nbspValoración:</strong>&nbsp${valoracion.valoracion}</h5>
                        <p style="margin-left:20px !important;">${valoracion.comentario}</p>
                  	</div>
                    </c:if> 
                   

					<div id="comentarios"  class ="" style="margin-left: 65px;margin-top: -15px;margin-bottom: 25px;">
                        <h4 class="text-uppercase" style="margin-bottom: -1px">Comentarios:</h4>
                        <hr class="templatemo-section-header-hr">
                        

                        <c:if test="${not empty valoraciones}">
                        <c:forEach items="${valoraciones}" var="vali">
                        <p>
                        <h5><strong style="color:#D0B04C;"><span class="glyphicon glyphicon-user"></span>&nbsp${vali.lectorNombre}</strong></h5>
                        </p>
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
        	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    // Check Radio-box
    $(".rating input:radio").attr("checked", false);
   
    $('.rating input').click(function () {
        $(".rating span").removeClass('checked');
        $(this).parent().addClass('checked');
        
    });

    $('input:radio').change(
      function(){
        var userRating = this.value;
       // document.getElementById("valoracion").value = (String)userRating;
       $(function () {
  		$('#valoracionUser').val(userRating);
		});
       //	alert($("#valoracionUser").val());
    }); 
});
</script>

    </body>
</html>
