<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Usuarios</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table>
			<tr><td>Gestión de Usuarios</td></tr>
			<tr><td><button type="submit" name="btnUsuario" value="alta" >Agregar usuario</button></td></tr>
			<tr><td><button type="submit" name="btnUsuario" value="baja" >Eliminar usuario</button></td></tr>
			<tr><td><button type="submit" name="btnUsuario" value="modificacion" >Modificar usuario</button></td></tr>
			<tr><td><button type="submit" name="btnUsuario" value="listado" >Listar usuarios</button></td></tr>
		</table>
	</form>
</body>
</html>