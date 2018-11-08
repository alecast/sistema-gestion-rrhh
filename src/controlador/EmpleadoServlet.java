package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.EmpleadoDAO;

/**
 * Servlet implementation class UsuarioAlta
 */
@WebServlet("/UsuarioAlta")
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
		String btn = request.getParameter("empleado");
		EmpleadoDAO empleDAO = new EmpleadoDAO();
		if(btn.equals("Cargar Empleado"))
				{
			
			 String DNI = request.getParameter("DNI");
			 String cuil = request.getParameter("cuil");
			 String nombre = request.getParameter("nombre");
			 String apellido = request.getParameter("apellido");
			 String domicilio = request.getParameter("domicilio");
			 String telefono = request.getParameter("telefono");
			 String estado_civil = request.getParameter("estado_civil");
			 String fecha_ingreso = request.getParameter("fecha_ingreso");
			 String antiguedad = request.getParameter("antiguedad");
			 String estado = request.getParameter("estado");
			 String cant_disponible = request.getParameter("cant_disponible");
			 
	          
	}
}
	}
