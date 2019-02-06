package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EmpleadoVO;

import datos.EmpleadoDAO;
import datos.UsuarioDAO;


/**
 * Servlet implementation class UsuarioAlta
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @param btn 
	 * @param fecha_ingreso 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Map<String, String> messages = new HashMap<String, String>();
	        request.setAttribute("messages", messages);
		String btnEmpleado = request.getParameter("btnEmpleado");
		EmpleadoDAO empleDAO = new EmpleadoDAO();
		if(btnEmpleado.equals("alta"))
			{
			
			int j = empleDAO.getMaxLegajo();
			request.setAttribute("j", j);
			request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado.jsp").forward(request, response);
			}
		else if (btnEmpleado.equals("CargarE"))
			
			
				{ 
			 if(request.getParameter("Cuil1").isEmpty() || request.getParameter("DNI").isEmpty() || request.getParameter("Cuil2").isEmpty() || request.getParameter("telefono").isEmpty() || request.getParameter("antiguedad").isEmpty() || request.getParameter("cant_disponible").isEmpty() || request.getParameter("tipoEmpleado").isEmpty() || request.getParameter("tipoCategoria").isEmpty() || request.getParameter("fecha_ingreso").isEmpty() || request.getParameter("nombre").isEmpty() || request.getParameter("apellido").isEmpty() || request.getParameter("domicilio").isEmpty() || request.getParameter("estado_civil").isEmpty()  ) {
					messages.put("error","Debe completar todos los campos");
					int j = empleDAO.getMaxLegajo();
					request.setAttribute("j", j);
					request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado.jsp").forward(request, response);
				} else {
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				//request.getRequestDispatcher("/WEB-INF/JSP/Empleado/EmpleadoNuevo.jsp").forward(request, response);
		     //  int Legajo = Integer.parseInt(request.getParameter("Legajo"));
			   
			   String Cuil=(request.getParameter("Cuil1")+request.getParameter("DNI")+request.getParameter("Cuil2"));
			   int DNI = Integer.parseInt(request.getParameter("DNI"));
			   int telefono = Integer.parseInt(request.getParameter("telefono"));
			   int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
			   int cant_disponible = Integer.parseInt(request.getParameter("cant_disponible"));
			   Date fecha_ingreso = null;
			   
			   int x = empleDAO.getMaxLegajo();
			   int tipo = Integer.parseInt(request.getParameter("tipoEmpleado"));
			   int categoria = Integer.parseInt(request.getParameter("tipoCategoria"));
			   
			try {
				fecha_ingreso = dateFormat.parse(request.getParameter("fecha_ingreso"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			     if( empleDAO.getEmpleadoPorDni(DNI)!=(null)){
			       
				   EmpleadoVO empleaVO = new EmpleadoVO (1000 , DNI, Cuil, request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("domicilio"), telefono,  request.getParameter("estado_civil"), fecha_ingreso, antiguedad, "Activo", cant_disponible );
         
                    try {
						empleDAO.AltaEmpleado( empleaVO);
						empleDAO.AltaTipo(x,tipo,fecha_ingreso);
					    empleDAO.AltaCategoria(x,categoria,fecha_ingreso);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado Opciones.jsp").forward(request, response);
			    	    
			     }
			   
			
			     else {
			    	 messages.put("error","Ya existe un empleado con ese numero de DNI");
			    	 request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado.jsp").forward(request, response);
			    	 
			     }}}
			 
		 else if(btnEmpleado.equals("Cancelar"))
				{
			request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado Opciones.jsp").forward(request, response);
				}
		else if(btnEmpleado.equals("volverMenu"))
		{
			request.getRequestDispatcher("/WEB-INF/JSP/Menu.jsp").forward(request, response);
		}
		else if(btnEmpleado.equals("volverOpciones"))
		{
			request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado Opciones.jsp").forward(request, response);
		}
		else if(btnEmpleado.equals("busqueda"))
		{
	  
		EmpleadoDAO EmpleDAO = new EmpleadoDAO();
		List<EmpleadoVO> listaEmpleado = EmpleDAO.getListaEmpleados();
		request.setAttribute("listaEmpleados", listaEmpleado);
		request.getRequestDispatcher("/WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);	
		}
		
		else if(btnEmpleado.contains("modificar")) { //Se fija que se haya apretado alguno de los "modificarUsuario"
			int index = Integer.parseInt(btnEmpleado.substring(9,btnEmpleado.length())); //Índice que saca del value en el JSP, lo usa para modificar ese usuario
			String nombreEmpleado = request.getParameter("nombreEmpleado"+btnEmpleado.substring(9,btnEmpleado.length()));
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			EmpleadoDAO EmpleDAO = new EmpleadoDAO();
			EmpleadoVO EmpleVO = new EmpleadoVO();
			EmpleVO = EmpleDAO.getEmpleado(index);
			
			request.setAttribute("Legajo", index);
			request.setAttribute("nombreEmpleado", nombreEmpleado);
			request.setAttribute("apellido", EmpleVO.getApellido());
			request.setAttribute("antiguedad", EmpleVO.getAntiguedad());
			request.setAttribute("cantidadDis", EmpleVO.getCant_disponible());
			request.setAttribute("dni", EmpleVO.getDNI());
			request.setAttribute("domicilio", EmpleVO.getDomicilio());
			request.setAttribute("estado_c", EmpleVO.getEstado_civil());
			request.setAttribute("fecha", EmpleVO.getFecha_ingreso());
			request.setAttribute("telefono", EmpleVO.getTelefono());
			request.setAttribute("cuil", EmpleVO.getCuil());
			
			
			Calendar c = new GregorianCalendar();
			int dia = (c.get(Calendar.DATE));
			int mes = (c.get(Calendar.MONTH))+1;
			int año = (c.get(Calendar.YEAR));
			//int a = ("0" + (c.get(Calendar.DATE)).slice(-2));
				
			String dia2="";
			String mes2="";
			if (dia < 10) {
				dia2 = "0" + dia;
			}
			if (mes < 10) {
				mes2 = "0" + mes;
			}
			
			
			String fecha_actual=(""+dia2+"/"+mes2+"/"+año+"");
			
			/*try {
				fecha_ahora = dateFormat.parse("+fecha_actual+");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			request.setAttribute("fechaAhora", fecha_actual);
			request.getRequestDispatcher("WEB-INF/JSP/Empleado/Modificar_Empleados.jsp").forward(request, response);	
		}
		else if(btnEmpleado.equals("aceptarBusqueda")) {
			String CampoLike = request.getParameter("CampoLike");
			String RadioBusquedaPor = request.getParameter("RadioBusquedaPor");
			String Ch_inactivo = request.getParameter("Ch_inactivo");
			if(CampoLike.isEmpty()) {
				messages.put("error","Debe completar todos los campos");
				request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);	
			} else {
				if(Ch_inactivo==null) {
				 Ch_inactivo="";
					
				}
				
				EmpleadoDAO EmpleDAO = new EmpleadoDAO();
				List<EmpleadoVO> listaEmpleadosLike = EmpleDAO.getListaEmpleadosPorNombre(CampoLike,RadioBusquedaPor ,Ch_inactivo );
				request.setAttribute("listaEmpleadosLike", listaEmpleadosLike);
				request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
			}
		   }

		else if(btnEmpleado.contains("Inactivo")){
			//String EstadoEmpleado = request.getParameter("nombreEmpleado"+btnEmpleado.substring(0,btnEmpleado.length()));
			String EstadoEmpleado ="Inactivo";
			int legajo = Integer.parseInt(btnEmpleado.substring(8,btnEmpleado.length()));
			EmpleadoDAO EmpleDao= new EmpleadoDAO();
			//UsuarioDAO UserDao = new UsuarioDAO();
			// UserDao.bajaUsuarioPorLegajo(legajo);
		     EmpleDao.BajarEmpleado(EstadoEmpleado,legajo);
		     request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
			
		}
		
	       
	else if(btnEmpleado.contains("aceptaModifica")) {
		String CampoLike = request.getParameter("CampoLike");
		String RadioBusquedaPor = request.getParameter("RadioBusquedaPor");
		String Ch_inactivo = request.getParameter("Ch_inactivo");
		if(CampoLike.isEmpty()) {
			messages.put("error","Debe completar todos los campos");
			request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);	
		} else {
			if(Ch_inactivo==null) {
			 Ch_inactivo="";
				
			}
			
			EmpleadoDAO EmpleDAO = new EmpleadoDAO();
			List<EmpleadoVO> listaEmpleadosLike = EmpleDAO.getListaEmpleadosPorNombre(CampoLike,RadioBusquedaPor ,Ch_inactivo );
			request.setAttribute("listaEmpleadosLike", listaEmpleadosLike);
			request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
		}
	   }
	
	else if(btnEmpleado.contains("aceptarModifica")) {
		
		 if(request.getParameter("cuil").isEmpty() || request.getParameter("dni").isEmpty() || request.getParameter("estado").isEmpty() || request.getParameter("telefono").isEmpty() || request.getParameter("antiguedad").isEmpty() || request.getParameter("cantidad_dias").isEmpty() || request.getParameter("tipo_empleado").isEmpty() || request.getParameter("categoria_empleado").isEmpty() || request.getParameter("fecha").isEmpty() || request.getParameter("nombreEmpleado").isEmpty() || request.getParameter("apellido").isEmpty() || request.getParameter("domicilio").isEmpty() || request.getParameter("estado_civil").isEmpty()  ) {
				messages.put("error","Debe completar todos los campos");
				
				request.getRequestDispatcher("WEB-INF/JSP/Empleado/Modificar_Empleados.jsp").forward(request, response);
			} else {
		   DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		   DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		
		   int legajo = Integer.parseInt(btnEmpleado.substring(15,btnEmpleado.length()));
		   String Cuil=(request.getParameter("cuil"));
		   String estado=(request.getParameter("estado"));
		   int DNI = Integer.parseInt(request.getParameter("dni"));
		   int telefono = Integer.parseInt(request.getParameter("telefono"));
		   int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
		   int cant_disponible = Integer.parseInt(request.getParameter("cantidad_dias"));
		   Date fecha_ingreso = null;
		   Date fecha_ahora = null;
		   
		
		   int tipo = Integer.parseInt(request.getParameter("tipo_empleado"));
		   int categoria = Integer.parseInt(request.getParameter("categoria_empleado"));
		   
	
		try {
			fecha_ingreso = dateFormat2.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			fecha_ahora = dateFormat.parse(request.getParameter("fechaAhora"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		       
			   EmpleadoVO empleaVO = new EmpleadoVO (legajo , DNI, Cuil, request.getParameter("nombreEmpleado"), request.getParameter("apellido"), request.getParameter("domicilio"), telefono,  request.getParameter("estado_civil"), fecha_ingreso, antiguedad, estado, cant_disponible );
  
             try {
					empleDAO.modificarEmpleado( empleaVO );
					empleDAO.modificarCategoria(legajo, categoria, fecha_ahora);
					empleDAO.modificarTipo(legajo, tipo, fecha_ahora);
					empleDAO.AltaTipo(legajo,tipo,fecha_ahora);
				    empleDAO.AltaCategoria(legajo,categoria,fecha_ahora);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			
			
			request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
		}
	       }
	
	
	

	
	
	}
}

