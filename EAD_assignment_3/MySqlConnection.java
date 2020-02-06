package record;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection initializeDatabase() 
			throws SQLException, ClassNotFoundException 
	{ 
		// Initialize all the information regarding 
		// Database Connection 
		String dbDriver = "com.mysql.jdbc.Driver"; 
		String dbName = "studentRecord"; 
		String dbURL = "jdbc:mysql://localhost:3306/"+dbName; 
		// Database name to access 
		String dbUsername = "root"; 
		String dbPassword = "groot"; 

		Class.forName(dbDriver); 

		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword); 

		Statement stmt = null;
		stmt = conn.createStatement();



		String mysql = "CREATE TABLE IF NOT EXISTS STUDENT" +
				"(id INTEGER not NULL AUTO_INCREMENT, " +
				" f_name VARCHAR(20), " + 
				" l_name VARCHAR(20), " + 
				" father_name VARCHAR(50), " +
				" email VARCHAR(50), " +
				" class INTEGER(2), " +
				" age INTEGER(2), " +
				" PRIMARY KEY ( id )," +
				" UNIQUE (email))"; 

		stmt.executeUpdate(mysql);

		return conn; 
	} 
}