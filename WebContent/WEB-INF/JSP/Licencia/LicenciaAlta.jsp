<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Licencia</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
	<div class="container">
		<h3> Nueva Licencia </h3>
		<form action="${pageContext.request.contextPath}/LicenciaServlet" method="post">
			<div class="form-group">
  				  <label for="id_licencia">Id de licencia:  ${ultimo_id} </label>
  			</div>
			<div class="form-group">
  				  <label for="fecha_inicio">Fecha de inicio:</label>
  				  <input type="text" name="fecha_inicio" class="form-control" id="fecha_inicio" placeholder="dd/mm/aaaa">
  			</div>
  			<div class="form-group">  
  				  <label for="fecha_fin">Fecha de finalización:</label>
  				  <input type="text" name="fecha_fin" class="form-control" id="fecha_fin" placeholder="dd/mm/aaaa">
  			</div>
  			<div class="form-group">
  				  <label for="fecha_solicitud">Fecha de solicitud</label>
  				  <input type="text" name="fecha_solicitud" class="form-control" id="fecha_solicitud" placeholder="${fecha_hoy}">
  			</div>
  			<div class="form-group">	  
  				  <input type="hidden" name="cant_dias" class="form-control" id="cant_dias" value="${cant_dias}">
  			</div>
  			<div class="form-group">  
  				  <label for="descripcion">Descripción:</label>
  				  <input type="text" name="descripcion" class="form-control" id="descripcion">
 			</div>
 			<div class="form-group">  
  				  <label for="motivo">Motivo:</label>
  				  <input type="text" name="motivo" class="form-control" id="motivo">
 			</div>
 			<div class="form-group">  
  				  <label for="certificado">Certificado:</label>
  				  <input type="text" name="certificado" class="form-control" id="certificado">
 			</div>
 			
 			<div class="form-gruop"><span class="error">${messages.error}</span></div>
 			
		  	<div class="form-group">
		  		<button type="submit" name="btnLicencia" value="volverOpciones">Volver</button>
		  		<button type="submit" name="btnLicencia" value="aceptaAlta">Aceptar</button>		  			
		  	</div>
		  	
		</form>
	</div>
</body>
</html>