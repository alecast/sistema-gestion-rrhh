<html>
<head>

<title>Nuevo Empleado</title>
<style type="text/css" media="screen">
      /*la directiva include copia el contenido de un archivo y lo incrusta en la pagina*/
     <%@ include file="EstiloEmpleado.css" %>
</style>
</head>
<body>
 <h3> Nuevo Empleado </h3>
<form action="EmpleadoNuevo.jsp" method="post">
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
    <input type="Radio" name="preferencia" value= "estado_civil"checked> Soltero/a <br/>
   <input type="Radio" name= "preferencia"value="estado_civil"> Casado/a <br/>
   <input type="Radio" name= "preferencia"value="estado_civil"> Divorsiado/a  <br/>
   <input type="Radio" name= "preferencia" value="estado_civil"> Viudo/a<br/>
    Fecha Ingreso:
    <input type="text" name="fecha_i">
    <br/>
   Antiguedad:
    <input type="text" name="antiguedad">
    <br/>
   Cantidad de dias:
    <input type="text" name="cant_dias">
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