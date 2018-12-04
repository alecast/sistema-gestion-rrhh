<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Usuario</title>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">  		
<script src="js/bootstrap.min.js"></script> 
</head>
<body>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table>
			<tr><td>Nombre Usuario: <input type="text" name="nombreLike" ></td></tr>
			<!-- 
			<tr><td>Ingrese alguno de siguientes campos:</td></tr>
			<tr><td>ID Usuario: <input type="text" name="idUsuario"></td></tr>  
			-->
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
				<button type="submit" name="btnUsuario" value="aceptarBusqueda">Buscar</button>
				<button type="submit" name="btnUsuario" value="busqueda">Listado</button>
			</td></tr>
		</table>
				<c:if test="${not empty listaUsuarios}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">ID</th>
					        <th scope="col">Nombre Usuario</th>
					        <th scope="col">Legajo</th>
					    </tr>
					</thead>
				    <c:forEach items="${listaUsuarios}" var="usuario">
				        <tr>
				            <td>${usuario.id_usuario}</td>
				            <td><c:out value="${usuario.nombre_usuario}" /></td>
				            <td><input type="hidden" name="nombreUsuario${usuario.id_usuario}" value="${usuario.nombre_usuario}"></td>
							<td><c:out value="${usuario.legajo}" /></td>
							<td><button type="submit" name="btnUsuario" value="modificarUsuario${usuario.id_usuario}">Modificar</button></td>
							<td><button type="submit" name="btnUsuario" value="eliminarUsuario${usuario.id_usuario}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
		<c:if test="${not empty listaUsuariosLike}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">ID</th>
					        <th scope="col">Nombre Usuario</th>
					        <th scope="col">Legajo</th>
					    </tr>
					</thead>
				    <c:forEach items="${listaUsuariosLike}" var="usuario">
				        <tr>
				            <td>${usuario.id_usuario}</td>
				            <td><c:out value="${usuario.nombre_usuario}" /></td>
							<td><c:out value="${usuario.legajo}" /></td>
							<td><button type="submit" name="btnUsuario" value="modificarUsuario${usuario.id_usuario}">Modificar</button></td>
							<td><button type="submit" name="btnUsuario" value="eliminarUsuario${usuario.id_usuario}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
	<button type="submit" name="btnUsuario" value="volverOpciones">Volver</button>
	</form>
</div>
</body>
</html>