<html>
<head>

<title>Solicitud de licencia</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>
<style type="text/css" media="screen">
      /*la directiva include copia el contenido de un archivo y lo incrusta en la pagina*/
     <%@ include file="/WEB-INF/JSP/Empleado/EstiloEmpleado.css" %>
</style>
</head>
<body>
 <h3> Nueva licencia </h3>
<form action="EmpleadoServlet" method="post">  <!-- falta crear el servlet -->
    <h5>ID de licencia:
    <input type="text" name="id_licencia" size="3">
    <br/>
    Fecha de inicio:
    <input type="text" name="fecha_inicio" size="10" maxlength="10">
    <br/>
    Fecha de finalización:
    <input type="text" name="fecha_fin" size="10" maxlength="10">
    <br/>
    Fecha de solicitud(hoy):
    <input type="text" name="fecha_solicitud" size="10" maxlength="10" disabled>
    <br/>
    Cantidad de días:
    <input type="text" name="cant_dias">
    <br/> 
    Descripción:
    <input type="text" name="descripcion">
    <br/>  
   
    <!--<input type="submit" name="btnEmpleado" value="Cancelar"> <input type="submit" name="btnEmpleado" value="Cargar Empleado"> -->
     <button type="submit" name="btnEmpleado" value="Cancelar" >Cancelar</button><button type="submit" name="btnEmpleado" value="CargarE" >Cargar Licencia</button>
    </h5>
</form>
</body>
</html>