
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css"> 		
<script src="js/bootstrap.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Principal</title>
</head>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
<body>
<div class="container">
	<h1>Bienvenido ${nombreUsuario} </h1>
	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
	    <button type="submit" name="btnMain" value="usuario" >Gestión de usuarios</button>
	    <button type="submit" name="btnMain" value="empleado" >Gestión de empleados</button>
	    <button type="submit" name="btnMain" value="licencia" >Gestión de Licencias</button>
	</form>
</div>
</body>
</html>