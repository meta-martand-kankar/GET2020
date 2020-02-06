package record;

import record.MySqlConnection;
import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addStudent
 */
@WebServlet("/addStudent")
public class addStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try { 
			Connection conn = MySqlConnection.initializeDatabase(); 

			PreparedStatement stmt = conn 
					.prepareStatement("INSERT INTO STUDENT VALUES (id,?,?,?,?,?,?)"); 	 

			stmt.setString(1, request.getParameter("f_name"));
			stmt.setString(2, request.getParameter("l_name"));
			stmt.setString(3, request.getParameter("father_name"));
			stmt.setString(4, request.getParameter("stu_email"));
			stmt.setInt(5, Integer.valueOf(request.getParameter("class")));
			stmt.setInt(6, Integer.valueOf(request.getParameter("age"))); 

			stmt.executeUpdate(); 
			response.sendRedirect("index.html");
			stmt.close(); 
			conn.close(); 	
		} 
		catch (Exception e) { 
			PrintWriter outt = response.getWriter(); 
			outt.println(e);
			//	e.printStackTrace(); 
		} 
	}

}
