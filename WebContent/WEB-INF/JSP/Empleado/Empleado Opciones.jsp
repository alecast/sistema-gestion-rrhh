
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Empleados</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/EmpleadoServlet" method="post">
		<table>
			<tr><td>Gestión de Empleados</td></tr>
			<tr><td><button type="submit" name="btnEmpleado" value="alta" >Agregar Empleado</button></td></tr>
			<tr><td><button type="submit" name="btnEmpleado" value="busqueda" >Buscar Empleado</button></td></tr>
			<tr><td><button type="submit" name="btnEmpleado" value="listado" >Listar Empleado</button></td></tr>
			<tr><td><button type="submit" name="btnEmpleado" value="volverMenu">Volver</button></td></tr>
		</table>
	</form>
</body>
</html>