package com.parking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		String empname = req.getParameter("empname");
		String empemail = req.getParameter("empemail");
		String empgender = req.getParameter("empgender");
		String emppassword = req.getParameter("emppassword");
		String empcontact = req.getParameter("empcontact");
		String emporganisation = req.getParameter("emporganisation");
		
		int counter = 1;
		
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into register values(empid,?,?,?,?,?,?)"); 
			ps.setString(counter++, empname);
			ps.setString(counter++, empgender);
			ps.setString(counter++, empemail);
			ps.setString(counter++, emppassword);
			ps.setString(counter++, empcontact);
			ps.setString(counter++, emporganisation);
			
			
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
			}
			ps=con.prepareStatement("select empid from register where empname=?"); 
			ps.setString(1, empname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("empid");
			res.sendRedirect("vehicleregister.jsp?id="+id);

//			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}	