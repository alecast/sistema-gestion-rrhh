package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * @param fecha_ingreso 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			   int cuil = Integer.parseInt(request.getParameter("cuil"));
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
			  
			
			   EmpleadoVO empleaVO = new EmpleadoVO (5 , DNI, cuil, request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("domicilio"), telefono,  request.getParameter("estado_civil"), fecha_ingreso, antiguedad, "Activo", cant_disponible );
       
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
			request.getRequestDispatcher("WEB-INF/JSP/Menu.jsp").forward(request, response);
		}
     }
         

}
