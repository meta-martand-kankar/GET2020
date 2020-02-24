package com.book.Assignment_5_b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class establishes the connection with database.
 * @author Martand
 *
 */
public class mysqlConnection {
	private static mysqlConnection mySqlObject;
	private static Connection con = null;

	private mysqlConnection() {
		try {
			System.out.println("----------------idhar fata-------------------");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("-------------------udhar nahi idhar fata-----------------");	
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetail","root","groot");

			Statement stmt = null;
			stmt = con.createStatement();

			String mysql = "CREATE TABLE IF NOT EXISTS BOOK" +
					"(id INTEGER not NULL AUTO_INCREMENT, " +
					" title VARCHAR(20), " + 
					" writer VARCHAR(20), " + 
					" publisher VARCHAR(50), " +
					" published_year INTEGER(4), " +
					" PRIMARY KEY ( id )," +
					" UNIQUE (title))"; 

			stmt.executeUpdate(mysql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * This function is used to get connection statement
	 * @return the connection
	 */
	public static Connection getConnection() {
		if(con==null)
			mySqlObject = new mysqlConnection();
		return con;
	}
}