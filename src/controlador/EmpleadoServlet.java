package controlador;

import java.io.IOException;
import java.sql.SQLException;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btnEmpleado = request.getParameter("btnEmpleado");
		EmpleadoDAO empleDAO = new EmpleadoDAO();
		if(btnEmpleado.equals("alta"))
			{
			request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
			}
		else if (btnEmpleado.equals("CargarE"))
			
			
				{ 
				request.getRequestDispatcher("/EmpleadoNuevo.jsp").forward(request, response);
		     //  int Legajo = Integer.parseInt(request.getParameter("Legajo"));
			   int DNI = Integer.parseInt(request.getParameter("DNI"));
			   int cuil = Integer.parseInt(request.getParameter("cuil"));
			   int telefono = Integer.parseInt(request.getParameter("telefono"));
			   int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
			   int cant_disponible = Integer.parseInt(request.getParameter("cant_disponible"));
			   
			   EmpleadoVO empleaVO = new EmpleadoVO (5 , DNI, cuil, "nombre", "apellido", "domicilio", telefono, "estado_civil", "fecha_ingreso", antiguedad,"estado", cant_disponible );
           //  try { // empleDAO.Alta(empleaVO);
                    try {
						empleDAO.AltaEmpleado( empleaVO);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//	empleDAO.Insertar(DNI,cuil,request.getParameter("nombre"),request.getParameter("apellido"),request.getParameter("domicilio"),telefono ,request.getParameter("estado_civil"),request.getParameter("fecha_ingreso"), antiguedad ,request.getParameter("estado"), cant_disponible);    
			//	} catch(Exception e) 
            /*        {
			         System.out.println("Error!, Servlet");
			     }*/ }
		else if(btnEmpleado.equals("Cancelar"))
				{
			request.getRequestDispatcher("/Empleado Opciones.jsp").forward(request, response);
				}
        	}
         
     /*	else
		{
			request.getRequestDispatcher("/Empleado Opciones.jsp").forward(request, response);
		}*/
		//( btnEmpleado.equals("Modificar")
}

