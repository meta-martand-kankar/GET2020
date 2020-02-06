<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="record.MySqlConnection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Data Form</title>
</head>
<body>
	<%
		try {

			String id = request.getParameter("id");
			out.println("HELLO "+id);

			int stuId = Integer.parseInt(id);
			out.println("connected not database");
			Connection conn = MySqlConnection.initializeDatabase();
			out.println("connected database");
			Statement stmt = conn.createStatement();
			ResultSet rs= null; 
			String QueryString = "select * from student where id =" +stuId;
			rs = stmt.executeQuery(QueryString);
			rs.next();
	%>
	<h1>Update data from database</h1>
	<form method="post" action="updateProcess.jsp">
		<input type="text" name="id" value="<%=rs.getString("id")%>" Hidden>
		<br> First name:<br> <input type="text" name="first_name"
			value="<%=rs.getString("f_name")%>"> <br> Last name:<br>
		<input type="text" name="last_name"
			value="<%=rs.getString("l_name")%>"> <br> Father's name:<br>
		<input type="text" name="father_name"
			value="<%=rs.getString("father_name")%>"> <br> Email Id:<br>
		<input type="email" name="email" value="<%=rs.getString("email")%>">
		<br> Class:<br> <input type="number" name="class"
			value="<%=rs.getInt("class")%>"> <br> Age:<br> <input
			type="number" name="age" value="<%=rs.getInt("age")%>"> <br>
		<input type="submit" name="submit" value="submit">
	</form>
	<%
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>