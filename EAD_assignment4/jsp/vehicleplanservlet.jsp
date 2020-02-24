<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<%@ page import="com.parking.MysqlConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
String plan = request.getParameter("plan");
String currency = request.getParameter("currency");
String price = request.getParameter("price");
out.print(price);

int counter = 1;

try {
	Connection con = MysqlConnection.getConnection();
	PreparedStatement ps=con.prepareStatement("insert into vehicleplan values(?,?,?,?)"); 
	ps.setInt(counter++, id );
	ps.setString(counter++, plan );
	ps.setString(counter++, currency);
	ps.setString(counter++, price);
	
	if(ps.executeUpdate() > 0) {
		System.out.println("Added successfully price");
		response.sendRedirect("homepage.jsp?id="+id+"&status=0");
//		con.close();

	}
} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("sql exception");
}

%>
</body>
</html>