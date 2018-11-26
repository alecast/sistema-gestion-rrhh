<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Principal</title>
</head>
<body>
	<h1>Bienvenido ${nombreUsuario} </h1>
</body>
	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
		<table>
			<tr><td><button type="submit" name="btnMain" value="usuario" >Gestión de usuarios</button></td></tr>
	    	<tr><td><button type="submit" name="btnMain" value="empleado" >Gestión de empleados</button></td></tr>
		</table>
	</form>
</html>