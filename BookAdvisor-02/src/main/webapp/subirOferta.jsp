<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Publicar Oferta</title>
    <meta charset="UTF-8" />
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/subir-style.css" rel="stylesheet">
    <link rel="icon" type="image/png" href="img/logo2.png" />

 
</head>
<body>
    <div class="box" style="margin-top: -5px;">
        <a class="button" href="#popup2">Publicar Oferta</a>
    </div>      
    <div id="popup2" class="overlay" style="overflow: scroll;">
        <div class="popup">
            <h1 style="text-align: center;text-decoration: underline;margin-bottom: -10px;"> Publicar Oferta </h1>
            <form class="form-subir" role="form" method="post" action="/subirOferta" style="margin-left: -3px;margin-top: 22px;">
                <div class="form-group">
                    <a class="close" href="#">&times;</a>
                    <label for="titulo">Título</label>
                    <input type="text" class="form-control" name="titulo" id="titulo"/>
                    <label for="descuento">Descuento</label>
                    <select name="descuento" class="form-control" id="descuento" style="text-align:center;">
                        <option value="0">Seleccione un descuento</option>
                        <option value="5">5%</option> 
                        <option value="10">10%</option>
                        <option value="15">15%</option> 
                        <option value="20">20%</option> 
                        <option value="25">25%</option> 
                        <option value="30">30%</option>
                        <option value="35">35%</option> 
                        <option value="40">40%</option>
                        <option value="45">45%</option> 
                        <option value="50">50%</option> 
                        <option value="55">55%</option> 
                        <option value="60">60%</option>
                        <option value="65">65%</option> 
                        <option value="70">70%</option> 
                        <option value="75">75%</option> 
                        <option value="80">80%</option>
                        <option value="85">85%</option> 
                        <option value="90">90%</option>
                        <option value="95">95%</option>
                    </select>
                    <label for="cupon"> Código del cupón de la oferta</label>
                    <input type="text" class="form-control" name="cupon" id="cupon" />
                    
                    
                    <label for="caducidad">Fecha de caducidad</label>
                    <select name="dia" class="form-control" id="dia" style="width:21%;text-align:center;">
                        <option value="D">Día</option>
                        <option value="1">1</option> 
                        <option value="2">2</option>
                        <option value="3">3</option> 
                        <option value="4">4</option> 
                        <option value="5">5</option> 
                        <option value="6">6</option>
                        <option value="7">7</option> 
                        <option value="8">8</option>
                        <option value="9">9</option> 
                        <option value="10">10</option> 
                        <option value="11">11</option> 
                        <option value="12">12</option>
                        <option value="13">13</option> 
                        <option value="14">14</option> 
                        <option value="15">15</option> 
                        <option value="16">16</option>
                        <option value="17">17</option> 
                        <option value="18">18</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    <select name="mes" class="form-control" id="mes" style="width: 43%;margin-left: 72px;margin-top:-34px;text-align:center;">
                        <option value="M">Mes</option>
                        <option value="Enero">Enero</option>
                        <option value="Febrero">Febrero</option>
                        <option value="Marzo">Marzo</option>
                        <option value="Abril">Abril</option>
                        <option value="Mayo">Mayo</option>
                        <option value="Junio">Junio</option>
                        <option value="Julio">Julio</option>
                        <option value="Agosto">Agosto</option>
                        <option value="Septiembre">Septiembre</option>
                        <option value="Octubre">Octubre</option>
                        <option value="Noviembre">Noviembre</option>
                        <option value="Diciembre">Diciembre</option>                
                    </select>
                    <select name="ano" class="form-control" id="year" style="width: 33%;margin-left: 215px;margin-top: -34px;text-align:center;">
                        <option value="Y">Año</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                    </select>
                   
                    <label for="descripcion" style="margin-top:10px;">Descripción</label> 
                    <textarea class="form-control" name="descripcion" style="width: 320px; height: 100px; border-radius: 4px"></textarea>                  
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
                <button type="reset" class="btn btn-default">Borrar todo</button>
            </form>
        </div>
    </div> 
</body>
</html>