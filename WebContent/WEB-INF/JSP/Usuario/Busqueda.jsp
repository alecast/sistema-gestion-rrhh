<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar Usuario</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/UsuarioServlet" method="post">
		<table>
			<tr><td>Ingrese alguno de siguientes campos:</td></tr>
			<tr><td>Nombre Usuario: <input type="text" name="nombreUsuario" ></td></tr>
			<tr><td>ID Usuario: <input type="text" name="idUsuario"></td></tr>
			<tr><td>
				<button type="submit" name="btnUsuario" value="volverOpciones">Cancelar</button>
				<button type="submit" name="btnUsuario" value="confirmaBaja">Aceptar</button>
			</td></tr>
		</table>
		<div>
			
		</div>	
	</form>
</body>
</html>