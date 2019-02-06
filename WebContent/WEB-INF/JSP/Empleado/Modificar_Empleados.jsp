
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
			<span class="error">${messages.error}</span>	
			<div class="form-group">
				<h3>Empleado: ${nombreEmpleado} - Legajo: ${Legajo} </h3>	
			</div>
			<div class="form-group">
				<label for="userPass1">Fecha de Cambio:</label>
    			<input type="text" class="form-control" name="fechaAhora" id="fechaAhora" value="${fechaAhora}"  >	
			</div>
			<div class="form-group">
				<label for="userPass1">Nuevo Nombre:</label>
    			<input type="text" class="form-control" name="nombreEmpleado" id="nombreEmpleado" value="${nombreEmpleado}" >	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Apellido:</label>
    			<input type="text" class="form-control" name="apellido" id="apellido" value="${apellido}">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo DNI:</label>
    			<input type="text" class="form-control" name="dni" id="dni" value = "${dni}">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo CUIL:</label>
    			<input type="text" class="form-control" name="cuil" id="cuil" value = "${cuil}">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Domicilio:</label>
    			<input type="text" class="form-control" name="domicilio" id="domicilio" value = "${domicilio}">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nuevo Telefono:</label>
    			<input type="text" class="form-control" name="telefono" id="telefono" value = "${telefono}">	
			</div>
			<div class="form-group">
			<fieldset>
				<label for="userPass2">Nuevo Estado Civil:</label><br/>
    			 <input type="Radio" name= "estado_civil" value="Soltero" checked> Soltero/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Casado"> Casado/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Divorciado"> Divorsiado/a  <br/>
  				 <input type="Radio" name= "estado_civil" value="Viudo"> Viudo/a<br/>
			</fieldset>
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Fecha Ingreso:</label>
    			<input type="text" class="form-control" name="fecha" id="fecha" value = "${fecha}">	
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Antiguedad:</label>
    			<input type="text" class="form-control" name="antiguedad" id="antiguedad" value = "${antiguedad}">	
			</div>
			<div class="form-group">
			<fieldset>
				<label for="userPass2">Cambiar Estado:</label><br/>
    			<input type="Radio" name= "estado" value="Activo" checked > Activo/a  
  				<input type="Radio" name= "estado" value="Ausente"> Ausente<br/>
  			</fieldset>	
			</div>
			<div class="form-group">
				<label for="userPass2">Nueva Cantidad de dias disponible:</label>
    			<input type="text" class="form-control" name="cantidad_dias" id="cantidad_dias" value = "${cantidadDis}">	
			</div>
			
			
			<div class="form-group">
			    <label for="selectTipoUsuario">Nuevo tipo de Empleado:</label>
			    <select multiple class="form-control" name="tipo_empleado" id="tipo_empleado">
					 <option value="1" selected>Area sistemas</option>
     				 <option value="2">Area recursos</option>
     			</select>
		  	</div>
		  	
		  	<div class="form-group">
			    <label for="selectTipoUsuario">Nuevo tipo de Categoria de empleado:</label>
			    <select multiple class="form-control" name="categoria_empleado" id="categoria_empleado">
					   <option value="4" selected>Empleado</option>
					   <option value="1">Coordinador</option>
     				   <option value="2">Secretario</option>
    				   <option value="3">Sub secretario</option>
     	      		   
  			  </select>
		  	</div>
		  	
		      <input type="hidden" name="nombreEmpleado${nombreEmpleado}" value="${Legajo}">
		  	<div class="form-gruop"><span class="error">${messages.error}</span></div>
		  	<div class="form-group">
		  		<button type="submit" name="btnEmpleado" value="volverOpciones">Volver</button>
		  		<button type="submit" name="btnEmpleado" value="aceptarModifica${Legajo}">Aceptar</button>		  	
		  		<button type="submit" name="btnEmpleado" value="Inactivo${Legajo}">Dar de baja Empleado</button>			
		  	</div>			
		</form>
	</div>
</body>
