<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<% BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService(); %>
    
<!DOCTYPE html>
<html lang="es">
<head>
    <title>BookCrossing</title>
    <meta charset="UTF-8" />
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/subir-style.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="img/logo2.png" />

</head>
<body>
    <div class="box" style="margin-left: -38px;margin-top: -38px;margin-bottom: -46px;">
        <a class="button" href="#popup3">BookCrossing</a>
    </div>      
    <div id="popup3" class="overlay" style="overflow: scroll;">
        <div class="popup" style="text-align:center;">
            <h1 style="text-align: center;text-decoration: underline;margin-bottom: 20px;"> Bookcrossing </h1>
            <form class="form-subir" role="form" method="post" action="/bookcrossing" style="margin-left: -3px;margin-top: 22px;">
                <div class="form-group">
                    <a class="close" href="#">&times;</a>
                    <label for="direccion">Dirección</label>
                    <input type="text" class="form-control" name="direccion" id="direccion"/>
           
                    <label for="info">Información adicional</label> 
                    <textarea class="form-control" name="info" style="width: 321px; height: 100px; border-radius: 4px"></textarea>
                        
                </div>
                <input type="hidden"  name="crear" value="true">
                <button type="submit" class="btn btn-primary">Enviar</button>
                <button type="reset" class="btn btn-default">Borrar todo</button>
            </form>
        </div>
    </div> 
</body>
</html>