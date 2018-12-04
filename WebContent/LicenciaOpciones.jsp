<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>

</head>
<body>
	<form action="${pageContext.request.contextPath}/LicenciaServlet" method="post">
		<table>
			<tr><td>Gestión de Licencias</td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="alta" >Nueva Licencia</button></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="baja" >Eliminar Licencia</button></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="modificacion" >Modificar Licencia</button></td></tr>
			<tr><td><button type="submit" name="btnLicencia" value="listado" >Listado de Licencias</button></td></tr>
		</table>
	</form>
</body>
</html>