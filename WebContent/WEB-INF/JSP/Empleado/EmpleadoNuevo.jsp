<html>
<head>
<title>Nuevo Empleado</title>
</head>
<body>
 
 Se Cargo el nuevo Empleado
 Con estos datos:
         <%
   
  
   out.print(" Nombre y Apellido del Empleado "+request.getParameter("nombre")+" "+request.getParameter("apellido"));
   out.print("<br/>");
   out.print("DNI "+ request.getParameter("DNI") +" de DNI");
   out.print("<br/>");
   out.print("Cuil "+ request.getParameter("cuil") +" de cuil");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("telefono") +" de telefono");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("cant_disponible") +" de cantidad disp");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("legajo") +" de legajo");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("domicilio") +" de domicilio");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("estado_civil") +" de estado_civil");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("fecha_ingreso") +" de fecha_ingreso");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("cant_disponible") +" de cant_disponible");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("tipo de Empleado") +" de tipo de Empleado");
   out.print("<br/>");
   out.print("tienes "+ request.getParameter("tipo de Categoria") +" de Tipo de Categoria");
   out.print("<br/>");
   
   
       %>
 
</body>
</html>