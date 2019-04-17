
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
<form action="${pageContext.request.contextPath}/EmpleadoServlet" method="post">
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 	
 	<table class="table">
			<tr><td><input type="text" name="CampoLike" >   Buscar Empleado por:   
			     <input type="Radio" name= "RadioBusquedaPor" value="dni"checked> DNI
  				 <input type="Radio" name= "RadioBusquedaPor" value="nombre"> Nombre
  				 <input type="Radio" name= "RadioBusquedaPor" value="apellido"> Apellido
  				 <input type="Radio" name= "RadioBusquedaPor" value="legajo"> Legajo .....................................................   Incluir empleados inactivos  <input type="checkbox" name= "Ch_inactivo" value="Inactivo"></td> </tr>
			
			<tr><td><span class="error">${messages.error}</span></td></tr>
			<tr><td>
				<button type="submit" name="btnEmpleado" value="aceptarBusqueda">Buscar</button> 
				<button type="submit" name="btnEmpleado" value="busqueda">Listado</button>
			</td></tr>
		</table>
 	
 	
 	
 <c:if test="${not empty listaEmpleados}">
 <div class="table-responsive {-xl}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">Legajo</th>
					        <th scope="col">DNI</th>
					        <th scope="col">Nombre</th>
					        <th scope="col">Apellido</th>
					        <th scope="col">Cuil</th>
					        <th scope="col">Domicilio</th>
					        <th scope="col">Email</th>
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
							<td>${empleado.email}</td>
							<td>${empleado.telefono}</td>
							<td>${empleado.estado_civil}</td>
							<td>${empleado.fecha_ingreso}</td>
							<td>${empleado.antiguedad}</td>
							<td>${empleado.estado}</td>
							<td>${empleado.cant_disponible}</td>
							
							<td><input type="hidden" name="nombreEmpleado${empleado.legajo}" value="${empleado.nombre}"></td>
							
			                   <td>   <button type="submit" name="btnEmpleado" value="modificar${empleado.legajo}" class="btn btn-outline-success">Modificar</button></td>
							
							
							
							
	 
							
							
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
				</table>
				</div>
		</c:if>
		
		<c:if test="${not empty listaEmpleadosLike}">
		<div class="table-responsive {-xl}">
				<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">Legajo</th>
					        <th scope="col">DNI</th>
					        <th scope="col">Nombre</th>
					        <th scope="col">Apellido</th>
					        <th scope="col">Cuil</th>
					        <th scope="col">Domicilio</th>
					        <th scope="col">Email</th>
					        <th scope="col">Telefono</th>
					        <th scope="col">Estado Civil</th>
					        <th scope="col">Fecha Ingreso</th>
					        <th scope="col">Antiguedad</th>
					        <th scope="col">Estado</th>
					        <th scope="col">Cantidad disponible</th>
					        
					    </tr>
					</thead>
				    <c:forEach items="${listaEmpleadosLike}" var="empleado">
				        <tr>
				            <td>${empleado.legajo}</td>
							<td>${empleado.DNI}</td>
							<td>${empleado.nombre}</td>
							<td>${empleado.apellido}</td>
							<td>${empleado.cuil}</td>
							<td>${empleado.domicilio}</td>
							<td>${empleado.email}</td>
							<td>${empleado.telefono}</td>
							<td>${empleado.estado_civil}</td>
							<td>${empleado.fecha_ingreso}</td>
							<td>${empleado.antiguedad}</td>
							<td>${empleado.estado}</td>
							<td>${empleado.cant_disponible}</td>
							
							<td><input type="hidden" name="nombreEmpleado${empleado.legajo}" value="${empleado.nombre}"></td>
						 <td>   <button type="submit" name="btnEmpleado" value="modificar${empleado.legajo}" class="btn btn-outline-success">Modificar</button></td>
							
							
							
							
	
							
				        </tr>
			    	</c:forEach>
			    	<tr><td><span >${messages.baja}</span></td></tr>
			    	
				</table>
				</div>
		</c:if>
		    <button type="submit"  name="btnEmpleado" value="volverOpciones" class="btn btn-primary btn-lg btn-block">Volver al menu</button>
		    
			
		</form>
</div>
</html>