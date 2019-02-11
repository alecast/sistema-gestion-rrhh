<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css"> 
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">  		
	<script src="js/bootstrap.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="masterHeader">
		<div class="titleHeader"><h1>Sistema Gestión RRHH</h1></div>
		<div class="loginHeader">
			<form action="${pageContext.request.contextPath}/MainServlet" method="post">
				<table>				
					<tr><td>${usuario.nombre_usuario}</td></tr>
					<tr><td>${usuario.tipo_usuario.descripcion}</td></tr>
					<tr><td><button type="submit" class="btn btn-primary" name="btnMain" value="cerrarSesion">Cerrar Sesión</button></td></tr>
					<tr><td>
						<c:if test="${usuario.tipo_usuario.descripcion == 'Administrador'}">
							<div class="d-flex flex-row-reverse bd-highlight">
								<button type="submit" class="btn btn-primary" name="btnMain" value="LicenciasCU">
									Licencias Pendientes
									<span class="badge badge-light"> ${licenciasPendientes}</span>
								</button>
							</div>
						</c:if>
						<c:if test="${usuario.tipo_usuario.descripcion == 'Empleado'}">
							<div class="d-flex flex-row-reverse bd-highlight">
								<button type="submit" class="btn btn-primary" name="btnMain" value="LicenciasCU">
									Licencias Aprobadas 
									<span class="badge badge-light"> ${licenciasAprobadas}</span>
								</button>
							</div>
						</c:if>				
					</td></tr>
				</table>
			</form>	 
		</div>
	</div>
</body>
</html>