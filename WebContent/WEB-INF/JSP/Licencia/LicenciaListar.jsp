<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar licencias</title>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">  		
<script src="js/bootstrap.min.js"></script> 
</head>
<body>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<div class="container">
	<form action="${pageContext.request.contextPath}/LicenciaServlet" method="post">
		<table>
			<tr>
			<!--
				<td>Nombre Usuario: <input type="text" name="nombreLike" ></td>
			
			<td><input type="checkbox" name="chbUsuInactivo" value="Inactivo"> Incluir usuarios inactivos
			-->
			</tr>
			<!-- 
			<tr><td>Ingrese alguno de siguientes campos:</td></tr>
			<tr><td>ID Usuario: <input type="text" name="idUsuario"></td></tr>  
			-->
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
			<!-- 
			<button type="submit" name="btnLicencia" value="aceptarBusqueda">Buscar</button>  
				<button type="submit" name="btnLicencia" value="listarTodo">Listado</button>
			-->
			</td></tr>
		</table>
				<c:if test="${not empty listaLicencias}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">ID</th>
					        <th scope="col">Descripción</th>
					        <th scope="col">Fecha inicio</th>
					        <th scope="col">Fecha fin</th>
					        <th scope="col">Fecha solicitud</th>
					        <th scope="col">Cantidad de días</th>
					        <th scope="col">Motivo</th>
					        <th scope="col">Certificado</th>
					        <th scope="col">Usuario aprobado</th>
					    </tr>
					</thead>
				    <c:forEach items="${listaLicencias}" var="licencia">
				        <tr>
				            <td>${licencia.id_licencia}</td>
				            <td>${licencia.descripcion}</td>
				            <td>${licencia.fecha_inicio}</td>
				            <td>${licencia.fecha_fin}</td>
				            <td>${licencia.fecha_solicitud}</td>
				            <td>${licencia.cant_dias}</td>
				            <td>${licencia.motivo}</td>
				            <td>${licencia.certificado}</td>
				            <td>${licencia.usuario_aprobado}</td>
				            <td>
					<!--             <c:out value="${licencia.usuario_aprobado}" />
					            <input type="hidden" name="nombreUsuario${licencia.usuario_aprobado}" value="${licencia.usuario_aprobado}">
					        </td>
					 -->        
							
							<td><button type="submit" name="btnLicencia" value="modificarLicencia${licencia.id_licencia}">Modificar</button></td>
							<td><button type="submit" name="btnLicencia" value="eliminarLicencia${licencia.id_licencia}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
		<!--
		<c:if test="${not empty listaUsuariosLike}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">ID</th>
					        <th scope="col">Nombre Usuario</th>
					        <th scope="col">Legajo</th>
					        <th scope="col">Estado</th>
					    </tr>
					</thead>
		 		    <c:forEach items="${listaUsuariosLike}" var="usuario">
				        <tr>
				            <td>${usuario.id_usuario}</td>
				            <td>
					            <c:out value="${usuario.nombre_usuario}" />
					            <input type="hidden" name="nombreUsuario${usuario.id_usuario}" value="${usuario.nombre_usuario}">
					        </td>				            
							<td><c:out value="${usuario.empleado.legajo}" /></td>
							<td>${usuario.estado}</td>
							<td><button type="submit" name="btnUsuario" value="modificarUsuario${usuario.id_usuario}">Modificar</button></td>
							<td><button type="submit" name="btnUsuario" value="eliminarUsuario${usuario.id_usuario}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
		 -->
	<button type="submit" name="btnLicencia" value="volverOpciones">Volver</button>
	</form>
</div>
</body>
</html>