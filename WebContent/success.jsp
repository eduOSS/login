<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.Connection" import="java.sql.ResultSet" import="java.sql.DriverManager" import="java.sql.Statement" import="java.sql.SQLException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>  
</head>
<body>
<%

try {
  // Step 1. Load the JDBC driver
  Class.forName("com.mysql.jdbc.Driver");
  // Step 2. Create a Connection object
  Connection con = DriverManager.getConnection(
		  "jdbc:mysql://localhost:3306/test", 
		  "root", "123456");
  System.out.println("got connection");

  Statement s = con.createStatement();
  String sql;
  ResultSet rs;
  
  while (rs.next()) {
    out.println(rs.getString(1) + " " + rs.getString(2) + "<br>");
  }
  rs.close();
  s.close();
  con.close();
}
catch (ClassNotFoundException e1) {
  // JDBC driver class not found, print error message to the console
  System.out.println(e1.toString());
}
catch (SQLException e2) {
  // Exception when executing java.sql related commands, print error message to the console
  System.out.println(e2.toString());
}
catch (Exception e3) {
  // other unexpected exception, print error message to the console
  System.out.println(e3.toString());
}
%>
</body>
</html>