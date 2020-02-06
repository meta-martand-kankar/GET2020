<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="record.MySqlConnection"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Searched Students List</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>List Of Students</h1>

				<%
					try {
						String firstName = request.getParameter("f_name");
						String lastName = request.getParameter("l_name");
						Connection conn = MySqlConnection.initializeDatabase();
						String QueryString = "SELECT * from student where f_name=? and l_name=? order by class";
						PreparedStatement stmt = conn.prepareStatement(QueryString);
						stmt.setString(1, firstName);
						stmt.setString(2, lastName);
						ResultSet rs = stmt.executeQuery();
				%>

				<table id="displayData">
					<tr style="padding: 5px; margin: 5px;">
						<th style="padding: 5px; margin: 5px;">Student Name</th>
						<th style="padding: 5px; margin: 5px;">Father's Name</th>
						<th style="padding: 5px; margin: 5px;">Email</th>
						<th style="padding: 5px; margin: 5px;">Class</th>
						<th style="padding: 5px; margin: 5px;">Age</th>
					</tr>
					<%
						while (rs.next()) {
					%>
					<TR style="padding: 5px; margin: 5px;">
						<TD style="padding: 5px; margin: 5px;"><%=rs.getString("f_name") + " "
							+ rs.getString("l_name")%></TD>
						<TD style="padding: 5px; margin: 5px;"><%=rs.getString("father_name")%></TD>
						<TD style="padding: 5px; margin: 5px;"><%=rs.getString("email")%></TD>
						<TD style="padding: 5px; margin: 5px;"><%=rs.getInt("class")%></TD>
						<TD style="padding: 5px; margin: 5px;"><%=rs.getInt("age")%></TD>
					</TR>
					<%
						}
					%>
					<a href="index.html">Home</a>
					<%
						rs.close();
							stmt.close();
							conn.close();
						} catch (Exception ex) {
							out.println("Unable to connect to database.");
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>