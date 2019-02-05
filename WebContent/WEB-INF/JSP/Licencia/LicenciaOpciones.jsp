<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión de Licencias</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>


</head>
<body>
	<form action="${pageContext.request.contextPath}/LicenciaServlet" method="post">
		<table>
			<tr><td><h1>Gestión de Licencias</h1></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="alta" >Nueva Licencia</button></td></tr>
			<!-- 
			<tr><td><button type="submit" name="btnLicencia" value="baja" >Eliminar Licencia</button></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="modificacion" >Modificar Licencia</button></td></tr>
			 -->
			<tr><td><button type="submit" name="btnLicencia" value="listado" >Listado de Licencias</button></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="volverMenu" >Volver</button></td></tr>
		</table>
	</form>
</body>
</html>