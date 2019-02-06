package controlador;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DateServlet
 */
@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static java.sql.Date ParseFecha(String fecha_ingreso)
    {
		java.util.Date date = new java.util.Date();
		
		
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      //  java.sql.Date fechaDate = null;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        try {
            sqlDate = (java.sql.Date) formato.parse(fecha_ingreso);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return (java.sql.Date) sqlDate;
    }


	
}
