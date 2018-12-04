<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Empleado</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
<div class="container">
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:if test="${not empty listaEmpleados}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">Legajo</th>
					        <th scope="col">DNI</th>
					        <th scope="col">Nombre</th>
					        <th scope="col">Apellido</th>
					        <th scope="col"> Cuil</th>
					        <th scope="col">Domicilio</th>
					        <th scope="col">Telefono</th>
					        <th scope="col">Estado Civil</th>
					        <th scope="col">Fecha Ingreso</th>
					        <th scope="col">Antiguedad</th>
					        <th scope="col">Estado</th>
					        <th scope="col">Cantidad disponible</th>
					        
		        
					    </tr>
					</thead>
				    <c:forEach items="${listaEmpleados}" var="empleado">
				        <tr>
				            <td>${empleado.legajo}</td>
							<td>${empleado.DNI}</td>
							<td>${empleado.nombre}</td>
							<td>${empleado.apellido}</td>
							<td>${empleado.cuil}</td>
							<td>${empleado.domicilio}</td>
							<td>${empleado.telefono}</td>
							<td>${empleado.estado_civil}</td>
							<td>${empleado.fecha_ingreso}</td>
							<td>${empleado.antiguedad}</td>
							<td>${empleado.estado}</td>
							<td>${empleado.cant_disponible}</td>
							
							
							<td><button type="submit" name="btnEmpleado" value="modificarUsuario${usuario.id_usuario}">Modificar</button></td>
							<td><button type="submit" name="btnEmpleado" value="eliminarUsuario${usuario.id_usuario}">Eliminar</button></td>
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
		</c:if>
</div>
</body>
</html>