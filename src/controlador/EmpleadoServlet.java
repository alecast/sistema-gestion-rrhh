package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
			request.getRequestDispatcher("/WEB-INF/JSP/Empleado/Empleado.jsp").forward(request, response);
			}
		else if (btnEmpleado.equals("CargarE"))
			
			
				{ 
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/WEB-INF/JSP/Empleado/EmpleadoNuevo.jsp").forward(request, response);
		     //  int Legajo = Integer.parseInt(request.getParameter("Legajo"));
			   int DNI = Integer.parseInt(request.getParameter("DNI"));
			  // int cuil = Integer.parseInt(request.getParameter("cuil"));
			   int telefono = Integer.parseInt(request.getParameter("telefono"));
			   int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
			   int cant_disponible = Integer.parseInt(request.getParameter("cant_disponible"));
			   Date fecha_ingreso = null;
			try {
				fecha_ingreso = dateFormat.parse(request.getParameter("fecha_ingreso"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
				   EmpleadoVO empleaVO = new EmpleadoVO (5 , DNI, "cuil", request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("domicilio"), telefono,  request.getParameter("estado_civil"), fecha_ingreso, antiguedad, "Activo", cant_disponible );
         
                    try {
						empleDAO.AltaEmpleado( empleaVO);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 }
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
			int index = Integer.parseInt(btnEmpleado.substring(9,btnEmpleado.length())); //�ndice que saca del value en el JSP, lo usa para modificar ese usuario
			String nombreEmpleado = request.getParameter("nombreEmpleado"+btnEmpleado.substring(9,btnEmpleado.length()));
			request.setAttribute("Legajo", index);
			request.setAttribute("nombreEmpleado", nombreEmpleado);
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
				EmpleadoDAO EmpleDAO = new EmpleadoDAO();
				List<EmpleadoVO> listaEmpleadosLike = EmpleDAO.getListaEmpleadosPorNombre(CampoLike,RadioBusquedaPor ,Ch_inactivo );
				request.setAttribute("listaEmpleadosLike", listaEmpleadosLike);
				request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
			}
		   }

		else if(btnEmpleado.contains("Inactivo")){
			String EstadoEmpleado = request.getParameter("nombreEmpleado"+btnEmpleado.substring(0,btnEmpleado.length()));
			int legajo = Integer.parseInt(btnEmpleado.substring(8,btnEmpleado.length()));
			EmpleadoDAO EmpleDao= new EmpleadoDAO();
		     EmpleDao.BajarEmpleado(EstadoEmpleado,legajo);
		     request.getRequestDispatcher("WEB-INF/JSP/Empleado/ModificarEmpleados.jsp").forward(request, response);
			
		}
		}
	       
		
	
	
	
	}

