<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Usuario</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
			<h1>Modificación Usuario</h1>			
			<div class="form-group">
				<h3>Usuario: ${nombreUsuario} - ID: ${idUsuario}</h3>	
			</div>
			<div class="form-group">
				<label for="userPass1">Nueva contraseña:</label>
    			<input type="password" class="form-control" name="userPass" id="userPass1" placeholder="Password">	
			</div>
			<div class="form-group">
				<label for="userPass2">Confirme nueva contraseña:</label>
    			<input type="password" class="form-control" name="userPass2" id="userPass2" placeholder="Password">	
			</div>
			<div class="form-group">
			    <label for="selectTipoUsuario">Nuevo tipo de usuario:</label>
			    <select multiple class="form-control" name="tipoUsuario" id="selectTipoUsuario">
					<option value="1">Administrador</option>
					<option value="2" selected>Empleado</option>
			    </select>
		  	</div>
		  	<div class="form-gruop"><span class="error">${messages.error}</span></div>
		  	<div class="form-group">
		  		<button type="submit" name="btnUsuario" value="volverOpciones">Volver</button>
		  		<button type="submit" name="btnUsuario" value="aceptaModifica${idUsuario}">Aceptar</button>		  			
		  	</div>			
		</form>
	</div>
</body>
</html>