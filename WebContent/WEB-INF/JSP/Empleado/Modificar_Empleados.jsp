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
		<form action="${pageContext.request.contextPath}/EmpleadoServlet" method="post">
			<h1>Modificación Empleado</h1>			
			<div class="form-group">
				<h3>Empleado: ${nombreEmpleado} - Legajo: ${Legajo}</h3>	
			</div>
			<div class="form-group">
				<label for="userPass1">Nuevo Nombre:</label>
    			<input type="text" class="form-control" name="userPass" id="userPass1" placeholder="Nombre">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Apellido:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="Apellido">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo DNI:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="DNI">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo CUIL:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="CUIL">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Domicilio:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="Domicilio">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Telefono:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="Telefono">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Estado Civil:</label><br/>
    			 <input type="Radio" name= "estado_civil" value="Soltero"checked> Soltero/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Casado"> Casado/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Divorsiado"> Divorsiado/a  <br/>
  				 <input type="Radio" name= "estado_civil" value="Viudo"> Viudo/a<br/>
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Fecha Ingreso:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="DD/MM/AAAA">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Antiguedad:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="Antiguedad">	
			</div>
			<div class="form-group">
				<label for="userPass2">Cambiar Estado:</label><br/>
    			<input type="Radio" name= "estado_civil" value="Divorsiado" checked> Activo/a  
  				<input type="Radio" name= "estado_civil" value="Viudo"> Ausente<br/>
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Cantidad de dias disponible:</label>
    			<input type="text" class="form-control" name="userPass2" id="userPass2" placeholder="Cantidad de dias disponible">	
			</div>
			
			
			<div class="form-group">
			    <label for="selectTipoUsuario">Nuevo tipo de Empleado:</label>
			    <select multiple class="form-control" name="tipoUsuario" id="selectTipoUsuario">
					 <option value="sistemas">Area sistemas</option>
     				 <option value="recursos">Area recursos</option>
     			</select>
		  	</div>
		  	
		  	<div class="form-group">
			    <label for="selectTipoUsuario">Nuevo tipo de Categoria de empleado:</label>
			    <select multiple class="form-control" name="tipoUsuario" id="selectTipoUsuario">
					   <option value="coordinador">Coordinador</option>
     				   <option value="secretario">Secretario</option>
    				   <option value="sub_secretario">Sub secretario</option>
     	      		   <option value="empleado">Empleado</option>
  			  </select>
		  	</div>
		  	
		      <input type="hidden" name="nombreEmpleado${nombreEmpleado}" value="${Legajo}">
		  	<div class="form-gruop"><span class="error">${messages.error}</span></div>
		  	<div class="form-group">
		  		<button type="submit" name="btnEmpleado" value="volverOpciones">Volver</button>
		  		<button type="submit" name="btnEmpleado" value="aceptaModifica${Legajo}">Aceptar</button>		  	
		  		<button type="submit" name="btnEmpleado" value="Inactivo${Legajo}">Dar de baja Empleado</button>			
		  	</div>			
		</form>
	</div>
</body>
</html>