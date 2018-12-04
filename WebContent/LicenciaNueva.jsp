<html>
<head>
<title>Nuevo Empleado</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" integrity="sha384-pjaaA8dDz/5BgdFUPX6M/9SUZv4d12SUPF0axWc+VRZkx5xU3daN+lYb49+Ax+Tl" crossorigin="anonymous"></script>

<body>
 
Se Cargo el nuevo Empleado
Con estos datos:
         <%
   /*podemos leer los datos del request a una variable*/
  
   out.print("tu nombre es "+request.getParameter("nombre")+" "+request.getParameter("apellido"));
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("DNI") +" de DNI");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("cuil") +" de cuil");
   out.print("tienes "+ request.getParameter("telefono") +" de telefono");
   out.print("tienes "+ request.getParameter("cant_disponible") +" de cantidad disp");
   out.print("tienes "+ request.getParameter("legajo") +" de legajo");
   out.print("tienes "+ request.getParameter("domicilio") +" de domicilio");
   out.print("tienes "+ request.getParameter("estado_civil") +" de estado_civil");
   out.print("tienes "+ request.getParameter("fecha_ingreso") +" de fecha_ingreso");
   out.print("tienes "+ request.getParameter("cant_disponible") +" de cant_disponible");
   out.print("tienes "+ request.getParameter("tipo de Empleado") +" de tipo de Empleado");
   out.print("tienes "+ request.getParameter("Tipo de Categoria") +" de Tipo de Categoria");
   
   
 %>
 
</body>
</html>