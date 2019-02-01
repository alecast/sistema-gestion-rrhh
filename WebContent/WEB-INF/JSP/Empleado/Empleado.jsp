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
			<h1>Alta Empleado</h1>			
			<div class="form-group">
				<label for="userPass1">Legajo:</label>
    			<input type="text" class="form-control" name="legajo" id="userPass1" placeholder="${j}" disabled>	
			</div>
			<div class="form-group">
				<label for="userPass1">Nombre:</label>
    			<input type="text" class="form-control" name="nombre" id="userPass1" placeholder="Nombre">	
			</div>
			<div class="form-group">
				<label for="userPass2">Apellido:</label>
    			<input type="text" class="form-control" name="apellido" id="userPass2" placeholder="Apellido">	
			</div>
<table class="table">
					<thead class="thead-dark">
					    <tr>
					        <th scope="col">Cuil- Primeros 2 numeros</th>
					        <th scope="col">DNI</th>
					        <th scope="col">Cuil- Ultimo número</th>
					        
					    </tr>
					</thead>
					<tr>
				            <td><input type="text" class="form-control" name="Cuil1" id="Cuil1" placeholder="CUIL"></td>
							<td><input type="text" class="form-control" name="DNI" id="DNI" placeholder="DNI"></td>
							<td><input type="text" class="form-control" name="Cuil2" id="Cuil2" placeholder="CUIL"></td>
                     </tr>
</table>
			
			
			<div class="form-group">
				<label for="userPass2">Domicilio:</label>
    			<input type="text" class="form-control" name="domicilio" id="userPass2" placeholder="Domicilio">	
			</div>
			<div class="form-group">
				<label for="userPass2">Telefono:</label>
    			<input type="text" class="form-control" name="telefono" id="userPass2" placeholder="Telefono">	
			</div>
			<div class="form-group">
				<label for="userPass2">Estado Civil:</label><br/>
    			 <input type="Radio" name= "estado_civil" value="Soltero" checked> Soltero/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Casado"> Casado/a <br/>
  				 <input type="Radio" name= "estado_civil" value="Divorsiado"> Divorsiado/a  <br/>
  				 <input type="Radio" name= "estado_civil" value="Viudo"> Viudo/a<br/>
			</div>
			<div class="form-group">
				<label for="userPass2">Fecha Ingreso:</label>
    			<input type="text" class="form-control" name="fecha_ingreso" id="userPass2" placeholder="DD/MM/AAAA">	
			</div>
			<div class="form-group">
				<label for="userPass2">Antiguedad:</label>
    			<input type="text" class="form-control" name="antiguedad" id="userPass2" placeholder="Antiguedad">	
			</div>
			
			<div class="form-group">
				<label for="userPass2">Cantidad de dias disponible:</label>
    			<input type="text" class="form-control" name="cant_disponible" id="userPass2" placeholder="Cantidad de dias disponible">	
			</div>
			
			
			<div class="form-group">
			    <label for="selectTipoUsuario">Tipo de Empleado:</label>
			    <select multiple class="form-control" name="tipoEmpleado" id="selectTipoEmpleado">
					 <option value="1" selected>Area sistemas</option>
     				 <option value="2">Area recursos</option>
     			</select>
		  	</div>
		  	
		  	<div class="form-group">
			    <label for="selectCategoriaEmpleado">Categoria de empleado:</label>
			    <select multiple class="form-control" name="tipoCategoria" id="selectCategoriaEmpleado">
					   <option value="4" selected>Empleado</option>
					   <option value="1">Coordinador</option>
     				   <option value="2">Secretario</option>
    				   <option value="3">Sub secretario</option>
     	      		   
  			  </select>
		  	</div>

		  	<div class="form-group">
		  		
		  		<button type="submit" class="btn btn-danger" name="btnEmpleado" value="volverOpciones">Cancelar</button>	
		  		<button type="submit" class="btn btn-success" name="btnEmpleado" value="CargarE">Aceptar</button>  	
		 			
		  	</div>			
		</form>
	</div>
</body>
</html>