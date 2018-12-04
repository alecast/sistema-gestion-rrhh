<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Usuario</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
<div class="container">
	<h3> Nuevo Usuario </h3>
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table>
			<tr><td>Legajo: <input type="text" name="legajo"></td></tr>
			<tr><td>Nombre usuario: <input type="text" name="nombreUsuario" ></td></tr>
			<tr><td>Contrase�a: <input type="password" name="passUsuario" ></td></tr>
			<tr><td>Repita contrase�a: <input type="password" name="pass2Usuario" ></td></tr>
			<tr><td>Tipo: 
				<select name="tipoUsuario">
				  <option value="1">Administrador</option>
				  <option value="2">Empleado</option>
				</select>
			</td></tr>
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
				<button type="submit" name="btnUsuario" value="volverOpciones">Volver</button>
				<button type="submit" name="btnUsuario" value="confirmaAlta">Aceptar</button>
			</td></tr>
		</table>
	</form>
</div>
</body>
</html>