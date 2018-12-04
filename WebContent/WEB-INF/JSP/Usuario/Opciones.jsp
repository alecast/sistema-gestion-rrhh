<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">  		
<script src="js/bootstrap.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Usuarios</title>
</head>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
<body>
	<div class="container">
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table class="table table-borderless">
			<tr><td><h1>Gestión de Usuarios</h1></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnUsuario" value="alta" >Agregar usuario</button></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnUsuario" value="busqueda" >Buscar usuario</button></td></tr>
			<tr><td><button type="submit" class="btn btn-primary" name="btnUsuario" value="volverMenu">Volver</button></td></tr>
		</table>
	</form>
	</div>
</body>
</html>