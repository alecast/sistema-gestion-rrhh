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
import datos.LicenciaDAO;
import modelo.LicenciaVO;

/**
 * Servlet implementation class UsuarioAlta
 */
@WebServlet("/LicenciaServlet")
public class LicenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LicenciaServlet() {
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
		String btnLicencia = request.getParameter("btnLicencia");
		LicenciaDAO licenDAO = new LicenciaDAO();
		if(btnLicencia.equals("alta"))
			{
			request.getRequestDispatcher("/Licencia.jsp").forward(request, response);
			}
		else if (btnLicencia.equals("CargarE"))
			
			
				{ 
			 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				request.getRequestDispatcher("/EmpleadoNuevo.jsp").forward(request, response);
		     //  int Legajo = Integer.parseInt(request.getParameter("Legajo"));
			   int id_licencia = Integer.parseInt(request.getParameter("id_licencia"));
			 //  int fecha_inicio = Integer.parseInt(request.getParameter("fecha_inicio"));
			//   int fecha_fin = Integer.parseInt(request.getParameter("fecha_fin"));
			//   int fecha_solicitud = Integer.parseInt(request.getParameter("fecha_solicitud"));
			   int cant_dias = Integer.parseInt(request.getParameter("cant_dias"));
			   Date fecha_inicio = null;
			   Date fecha_fin = null;
			   Date fecha_solicitud = null;
			try {
				fecha_inicio = dateFormat.parse(request.getParameter("fecha_inicio"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fecha_fin = dateFormat.parse(request.getParameter("fecha_fin"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fecha_solicitud = dateFormat.parse(request.getParameter("fecha_solicitud"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			
			   
			   LicenciaVO licenVO = new LicenciaVO (id_licencia, cant_dias, fecha_inicio, fecha_fin, fecha_solicitud, request.getParameter("descripcion") );
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
		else if(btnLicencia.equals("Cancelar"))
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
