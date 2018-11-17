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
			request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
			}
		else if (btnEmpleado.equals("CargarE"))
			
			
				{ 
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/EmpleadoNuevo.jsp").forward(request, response);
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
			  
			
			   
			//   java.sql.Date f =  convertJavaDateToSqlDate(fecha_ingreso);
			  
					   
		/*		   
					 java.sql.Date f = DateServlet.ParseFecha(request.getParameter("fecha_ingreso")); 
				          
				         DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				         java.sql.Date date;
				          try {
				              date = (java.sql.Date)dateFormat.parse("fecha_ingreso");
				              System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

				              String output = dateFormat.format(date);
				              System.out.println(output); // 2013-12-04
				          } 
				          catch (ParseException e) {
				              e.printStackTrace();
				          
				          }
			   
			   */
			   
			   EmpleadoVO empleaVO = new EmpleadoVO (5 , DNI, cuil, request.getParameter("nombre"), "apellido", "domicilio", telefono, "estado_civil", fecha_ingreso, antiguedad,"estado", cant_disponible );
           //  try { // empleDAO.Alta(empleaVO);
                    try {
						empleDAO.AltaEmpleado( empleaVO);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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

/*
public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
    return new java.sql.Date(date.getTime());
}*/
}
