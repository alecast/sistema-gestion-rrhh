<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">  
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css"> 		
<script src="js/bootstrap.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Men� Principal</title>
</head>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
<body>

<div class="container" >
	<h1>Bienvenido ${usuario.nombre_usuario} </h1>
	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
		<table>
		<c:if test="${usuario.tipo_usuario.descripcion == 'Administrador'}">
			<tr><td><button type="submit" name="btnMain" value="usuario" >Gesti�n de usuarios</button></td></tr>
	    	<tr><td><button type="submit" name="btnMain" value="empleado" >Gesti�n de empleados</button></td></tr>
	    </c:if>
	    	<tr><td><button type="submit" name="btnMain" value="licencia" >Gesti�n de licencias</button></td></tr>
	    	
		</table>
	</form>
</div>
</body>
</html>