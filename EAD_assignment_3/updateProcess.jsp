<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="record.MySqlConnection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updation Query Execution Page</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String f_name = request.getParameter("first_name");
		String l_name = request.getParameter("last_name");
		String father_name = request.getParameter("father_name");
		String email = request.getParameter("email");
		String stuClass = request.getParameter("class");
		String age = request.getParameter("age");
		
		if (id != null) {
			PreparedStatement ps = null;
			int personID = Integer.parseInt(id);
			int studentClass = Integer.parseInt(stuClass);
			int studentAge = Integer.parseInt(age);
			try {
				Connection conn = MySqlConnection.initializeDatabase();
				String stmt = "Update student set f_name=?,l_name=?,father_name=?,email=?,class=?,age=? where id="+ personID;
				
				ps = conn.prepareStatement(stmt);
				ps.setString(1, f_name);
				ps.setString(2, l_name);
				ps.setString(3, father_name);
				ps.setString(4, email);
				ps.setInt(5, studentClass);
				ps.setInt(6, studentAge);
				
			//	out.println(ps.toString());
				int i = ps.executeUpdate();
				if (i > 0) {
					out.print("Record Updated Successfully");
				} else {
					out.print("There is a problem in updating Record.");
				}
				%>
	<a href="index.html">Home</a>
	<%
			} catch (SQLException sql) {
				out.println(sql);
			}
		}
	%>
</body>
</html>