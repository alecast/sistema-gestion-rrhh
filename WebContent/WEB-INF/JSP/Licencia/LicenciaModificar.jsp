<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Licencia</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/LicenciaServlet" method="post">
			<h1>Modificación de Licencia</h1>			
			<div class="form-group">
				<h3>Licencia: ${id_licencia} - Legajo: ${licencia.empleado.legajo}</h3>	
			</div>
			<div class="form-group">
				<label for="userPass1">Nueva descripción:</label>
    			<input type="text" class="form-control" name="descripcion" placeholder="Descripción">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva fecha de inicio:</label>
    			<input type="text" class="form-control" name="fecha_inicio" placeholder="Fecha de inicio">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva fecha de finalización:</label>
    			<input type="text" class="form-control" name="fecha_fin" placeholder="Fecha de finalización">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo motivo:</label>
    			<input type="text" class="form-control" name="motivo" placeholder="Motivo">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo certificado:</label>
    			<input type="text" class="form-control" name="certificado" placeholder="Certificado">	
			</div>
		  	
		    <input type="hidden" name="id_licencia${id_licencia}" value="${Legajo}">
		  	<div class="form-gruop"><span class="error">${messages.error}</span></div>
		  	<div class="form-group">
		  	
		  		<button type="submit" name="btnLicencia" value="volverOpciones">Volver</button>
		  		<button type="submit" name="btnLicencia" value="aceptaModifica${id_licencia}">Aceptar</button>  			
		  	</div>			
		</form>
	</div>
	
	<!-- <button type="submit" name="btnLicencia" value="volverOpciones">Volver</button>  -->
	
</body>
</html>