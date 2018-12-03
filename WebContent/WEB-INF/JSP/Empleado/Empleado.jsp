<html>
<head>

<title>Nuevo Empleado</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>
<style type="text/css" media="screen">
      /*la directiva include copia el contenido de un archivo y lo incrusta en la pagina*/
     <%@ include file="EstiloEmpleado.css" %>
</style>
</head>
<body>
 <h3> Nuevo Empleado </h3>
<form action="EmpleadoServlet" method="post">
    <h5>Legajo:
    <input type="text" name="legajo" size="3" disabled>
    <br/>
    Cuil:
    <input type="text" name="cuil" size="2" maxlength="2">-<input type="text" name="DNI" size="8" maxlength="8">-<input type="text" name="cuil2" size="1" maxlength="1">
    <br/>
    Nombre:
    <input type="text" name="nombre">
    <br/>
    Apellido:
    <input type="text" name="apellido">
    <br/> 
    Domicilio:
    <input type="text" name="domicilio">
    <br/>  
    Telefono:
    <input type="text" name="telefono" size="8" maxlength="8">
    <br/>  
    Estado civil:<br/>
    <input type="Radio" name="estado_civil" value= "Soltero"checked> Soltero/a <br/>
   <input type="Radio" name= "estado_civil" value="Casado"> Casado/a <br/>
   <input type="Radio" name= "estado_civil" value="Divorsiado"> Divorsiado/a  <br/>
   <input type="Radio" name= "estado_civil" value="Viudo"> Viudo/a<br/>
    Fecha Ingreso:
    <input type="text" name="fecha_ingreso" size="10" maxlength="10" >
    <br/>
   Antiguedad:
    <input type="text" name="antiguedad">
    <br/>
   Cantidad de dias:
    <input type="text" name="cant_disponible">
    <br/>
   Tipo de Empleado:
    <select name="Tipo de Empleado">
      <option value="sistemas">Area sistemas
      <option value="recursos">Area recursos
    </select>
    <br/>
   Tipo de categoria:
    <select name="Tipo de Categoria">
      <option value="coordinador">Coordinador
      <option value="secretario">Secretario
      <option value="sub_secretario">Sub secretario
      <option value="empleado">Empleado
    </select>
    <br/>
    <!--<input type="submit" name="btnEmpleado" value="Cancelar"> <input type="submit" name="btnEmpleado" value="Cargar Empleado"> -->
     <button type="submit" name="btnEmpleado" value="Cancelar" >Cancelar</button><button type="submit" name="btnEmpleado" value="CargarE" >Cargar Empleado</button>
    </h5>
</form>
</body>
</html>