<html>
<head>
<title>Nueva Licencia</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Estilos.css">
<link rel="stylesheet" href="css/bootstrap.min.css">   		
<script src="js/bootstrap.min.js"></script> 
<jsp:include page="/WEB-INF/JSP/MasterHeader.jsp"/>
</head>

<!--
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>
 -->
 
<body>

<form action="LicenciaServlet" method="post">

<br/>

<b> Se cargó la nueva licencia con los siguientes datos: </b>

<%
   /*podemos leer los datos del request a una variable*/
  
   out.print("<br/>");
   out.print("<br/>");
 //  out.print("   Nombre: "+request.getParameter("bucar nombre"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Fecha de inicio: "+ request.getParameter("fecha_inicio"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Fecha de finalización: "+ request.getParameter("fecha_fin"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Fecha de solicitud: "+ request.getParameter("fecha_solicitud"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Cantidad de días: "+ request.getParameter("cant_dias"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Descripción: "+ request.getParameter("descripcion"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Motivo: "+ request.getParameter("motivo"));
   out.print("<br/>");
   out.print("<br/>");
   out.print("	Certificado: "+ request.getParameter("certificado"));
   out.print("<br/>");
   
   /*
   out.print("tienes "+ request.getParameter("domicilio") +" de domicilio");
   out.print("tienes "+ request.getParameter("estado_civil") +" de estado_civil");
   out.print("tienes "+ request.getParameter("fecha_ingreso") +" de fecha_ingreso");
   out.print("tienes "+ request.getParameter("cant_disponible") +" de cant_disponible");
   out.print("tienes "+ request.getParameter("tipo de Empleado") +" de tipo de Empleado");
   out.print("tienes "+ request.getParameter("Tipo de Categoria") +" de Tipo de Categoria");
   */
   
 %>
 
 <br/>
 <br/>
 
 <div class="form-group">
		  		<button type="submit" name="btnLicencia" value="volverAlta">Volver</button>	  			
		  	</div>
 
</body>
</html>