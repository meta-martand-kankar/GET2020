package com.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class establishes the connection with database.
 * @author Martand
 *
 */
public class MysqlConnection {
	private static MysqlConnection mySqlObject;
	private static Connection con = null;

	private MysqlConnection() {
		try {
			System.out.println("------------------In the database initializer-------------------");
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parkingsystem","root","groot");

			Statement stmt = null;
			stmt = con.createStatement();

			String mysql = "CREATE TABLE IF NOT EXISTS REGISTER" +
					"( empid INTEGER(10) not NULL AUTO_INCREMENT,"+ 
					" empname VARCHAR(20), " + 
					" empgender VARCHAR(20), " + 
					" empemail VARCHAR(50), " +
					" emppassword VARCHAR(20), " +
					"empcontact VARCHAR(10)," +
					"emporganization VARCHAR(20)," +
					" PRIMARY KEY ( empid )," +
					" UNIQUE (empemail))"; 

			stmt.executeUpdate(mysql);
			
			String mysql_1 = "CREATE TABLE IF NOT EXISTS VEHICLEPLAN" +
					"(empid INTEGER(10) NOT NULL, " +
					" plan VARCHAR(20), " + 
					" currency VARCHAR(20), " + 
					" price VARCHAR(50), " +
					" FOREIGN KEY (empid) REFERENCES REGISTER(empid)," +
					" PRIMARY KEY (empid))"; 

			stmt.executeUpdate(mysql_1);
			
			String mysql_2 = "CREATE TABLE IF NOT EXISTS VEHICLEREGISTER" +
					"(empid INTEGER(10) NOT NULL, " +
					" vehiclename VARCHAR(20), " + 
					" vehicletype VARCHAR(20), " + 
					" vehiclenumber VARCHAR(50), " +
					" vehicledescription varchar(100)," +
					" FOREIGN KEY (empid) REFERENCES REGISTER(empid)," +
					" PRIMARY KEY (empid))"; 

			stmt.executeUpdate(mysql_2);
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
			mySqlObject = new MysqlConnection();
		return con;
	}
}
