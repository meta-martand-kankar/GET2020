package com.parking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VehicleServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		String vehiclename = req.getParameter("vehiclename");
		String vehicletype = req.getParameter("vehicletype");
		String vehiclenumber = req.getParameter("vehiclenumber");
		String vehicledescription = req.getParameter("vehicledescription");
		
		int counter = 1;
		
		try {
			Connection con = MysqlConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into vehicleregister values(?,?,?,?,?)"); 
			ps.setInt(counter++, id);
			ps.setString(counter++, vehiclename );
			ps.setString(counter++, vehicletype);
			ps.setString(counter++, vehiclenumber);
			ps.setString(counter++, vehicledescription);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Added successfully , "+vehicletype);
				req.setAttribute("vehicletype", vehicletype);
				req.setAttribute("id", id);
				RequestDispatcher rd = req.getRequestDispatcher("vehicleplan.jsp");
				rd.forward(req, res);
//				con.close();

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception");
		} 
	}
}
