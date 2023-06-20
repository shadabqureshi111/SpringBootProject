<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="java.sql.*"%>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost/shadab"; 
	String username = "root";
	String password = "root";

try 
	{
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, username, password);
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT * FROM emp");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body >
<br>
	<a href='insert.jsp' ><button type="button" class="btn btn-primary">Add New Employee</button></a>
	<br><br>
<table>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Salary</th>
    <th>Action</th>
  </tr>
  
	<%while (rs.next()) 
		{
		    String id = rs.getString(1);
		    String name = rs.getString(2);
		    Double salary = rs.getDouble(3); 
	%>

  <tr>
      <td><%= id %></td>
      <td><%= name %></td>
      <td><%= salary %></td>
      <td><a href="update.jsp?id=<%=id %>">Edit</a>&nbsp;&nbsp;&nbsp;
      	  <a href="DeleteData?id=<%=id %>">Delete</a>
      </td>
      
    </tr>

	
	
	<%}
	}
catch (Exception e) 
{
e.printStackTrace();
} %>
	</table>
	
	
<%-- <table >
  <tr >
    <th>Employee Id</th>
    <th>Employee Name</th>
    <th>Employee Salary</th>
    <th>Action</th>
  </tr>
   <c:forEach var="d" items="${requestScope.data}">
  <tr>
    <td>${data.id}</td>
    <td>${d.name}</td>
    <td>${d.salary}</td>
    <td><a>Edit</a>&nbsp;&nbsp;&nbsp;<a>Delete</a></td>
  </tr>
   </c:forEach>
</table>

<script type="text/javascript">
function fetchData() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "Insert", true);
    xhr.onload = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var data = JSON.parse(xhr.responseText);
            displayData(data);
        }
    };
    xhr.send();
}
</script> --%>
</body>
</html>