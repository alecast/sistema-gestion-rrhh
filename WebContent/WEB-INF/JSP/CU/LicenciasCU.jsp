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
			<tr></tr>
			
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
			
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
				    
							
							<td><button type="submit" name="btnLicencia" value="modificarLicencia${licencia.id_licencia}">Modificar</button></td>
							<td><button type="submit" name="btnLicencia" value="eliminarLicencia${licencia.id_licencia}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
		
	<button type="submit" name="btnLicencia" value="volverOpciones">Volver</button>
	</form>
</div>
</body>
</html>