<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Usuario</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Estilos.css">
</head>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table>
			<tr><td>Nombre Usuario: <input type="text" name="nombreLike" ></td></tr>
			<!-- 
			<tr><td>Ingrese alguno de siguientes campos:</td></tr>
			<tr><td>ID Usuario: <input type="text" name="idUsuario"></td></tr>  
			-->
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
				<button type="submit" name="btnUsuario" value="volverOpciones">Volver</button>
				<button type="submit" name="btnUsuario" value="aceptarBusqueda">Aceptar</button>
			</td></tr>
		</table>
				<c:if test="${not empty listaUsuarios}">
				<table>
				    <tr>
				        <th>ID</th>
				        <th>Nombre Usuario</th>
				        <th>Legajo</th>
				    </tr>
				    <c:forEach items="${listaUsuarios}" var="usuario">
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
		<c:if test="${not empty listaUsuariosLike}">
				<table>
				    <tr>
				        <th>ID</th>
				        <th>Nombre Usuario</th>
				        <th>Legajo</th>
				    </tr>
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
	</form>
</body>
</html>