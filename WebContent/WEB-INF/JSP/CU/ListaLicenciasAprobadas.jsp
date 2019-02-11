<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar licencias Pendientes</title>
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">  		
<script src="js/bootstrap.min.js"></script> 
</head>
<body>
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<div class="container">
	<form action="${pageContext.request.contextPath}/MainServlet" method="post">
		<table>
			<tr></tr>
			
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
			
			</td></tr>
		</table>
				<c:if test="${not empty listaLicenciasAprobadas}">
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
					        <th scope="col">Estado</th>
					        <th scope="col">Fecha_ini</th>
					        <th scope="col">Fecha_Fin</th>
					        <th scope="col">Motivo</th>
					    </tr>
					</thead>
				    <c:forEach items="${listaLicenciasAprobadas}" var="estado">
				        <tr>
				            <td>${estado.licencia.id_licencia}</td>
				            <td>${estado.licencia.descripcion}</td>
				            <td>${estado.licencia.fecha_inicio}</td>
				            <td>${estado.licencia.fecha_fin}</td>
				            <td>${estado.licencia.fecha_solicitud}</td>
				            <td>${estado.licencia.cant_dias}</td>
				            <td>${estado.licencia.motivo}</td>
				            <td>${estado.licencia.certificado}</td>
				            <td>${estado.licencia.legajo_adm}</td>
				             <td>${estado.estado}</td>
				            <td>${estado.fecha_iniciacion}</td>
				            <td>${estado.fecha_finalizacion}</td>
				            <td>${estado.motivo_cambio}</td>
				          
				    
							
						<!--  	<td><button type="submit" name="btnMain" value="AceptaPendiente${licencia.id_licencia}">Aceptar</button></td> -->
							
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
		
	<button type="submit" name="btnMain" value="volver">Volver</button>
	</form>
</div>
</body>
</html>