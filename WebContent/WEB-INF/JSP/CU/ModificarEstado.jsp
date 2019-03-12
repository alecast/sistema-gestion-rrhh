
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Empleado</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/MainServlet" method="post">
			<h1>Modificación Empleado</h1>		
			<span class="error">${messages.error}</span>	
			<div class="form-group">
				<h3>Licencia: ${id_licencia} </h3>	
			</div>
			
			<div class="form-group">
				<label for="userPass1">Motivo:</label>
    			<input type="text" class="form-control" name="motivo" id="motivo" >	
			</div>
			
			<div class="form-group">
				<label for="userPass2">Fecha Inicio:</label>
    			<input type="text" class="form-control" name="fecha_inicio" id="fecha1" >	
			</div>
			<div class="form-group">
				<label for="userPass2">Fecha Fin:</label>
    			<input type="text" class="form-control" name="fecha_fin" id="fecha2" >	
			</div>
			
		  		<button type="submit" name="btnMain" value="volverLicenciasCU">Volver</button>
		  		<button type="submit" name="btnMain" value="aceptaModifica${id_licencia}">Aceptar</button>		  	
		  			
		  		
		  	
		  	</form>		
		  		</div>	
		  	
</body>
