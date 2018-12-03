<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Opciones Empleado</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>

<body>
	<form action="${pageContext.request.contextPath}/EmpleadoServlet" method="post">
		<table class="table table-borderless">
			<tr><td><h1>Gestión de Empleados</h1></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnEmpleado" value="alta" >Agregar Empleado</button></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnEmpleado" value="busqueda" >Buscar Empleado</button></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnEmpleado" value="volverMenu">Volver</button></td></tr>
		</table>
	</form>
</body>
</html>