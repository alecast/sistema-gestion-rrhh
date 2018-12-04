<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio de Sesión</title>
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
</head> 
<body>

<!-- dentro de lps div es html. 
	el form es un formulario
	el a es un link -->

<div class="vertical-center">
    <div class="container login">
	    <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	    <p id="profile-name" class="profile-name-card"></p>
	    <form class="form-signin" action="MainServlet" method="post">
	        <input type="text" name="userLogin" class="form-control" placeholder="Usuario" required autofocus>
	        <input type="password" name="passLogin" class="form-control" placeholder="Contraseña" required>
	        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" name="btnMain" value="login">Inicia sesión</button>
	    </form><!-- /form -->
	    <a href="#" class="forgot-password">
	        ¿Olvidó su contraseña?
	    </a>
    </div><!-- /container -->
</body>
</html>