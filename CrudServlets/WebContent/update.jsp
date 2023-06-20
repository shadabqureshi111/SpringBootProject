<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%
	Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String url = "jdbc:mysql://localhost/shadab";
String username = "root";
String password = "root";
String idd = null;
String name = null;
String salary = null;

try {
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, username, password);
	stmt = con.createStatement();
	String id = request.getParameter("id");
	rs = stmt.executeQuery("SELECT * FROM emp where id=" + id);
	while (rs.next()) {
		idd = rs.getString(1);
		name = rs.getString(2);
		salary = rs.getString(3);
	}

} catch (Exception e) {
	e.printStackTrace();
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<h2 style="margin-left: 35%;">Employee Updation Form</h2>

	<div class="container mt-3 w-25">
		<a href="fetch.jsp"><button type="button" class="btn btn-primary"
				style="margin: 13px 0px 25px 285px;">View Employees</button></a>
		<form action="./UpdateData" method="post">
			<div class="form-group">
				<label>EMPLOYEE ID</label>
				<input type="text" class="form-control" id="id" name="id"
					value="<%=idd%>" placeholder="Enter Employee Id" readonly="readonly">
			</div>

			<div class="form-group">
				<label>EMPLOYEE NAME</label> <input type="text" value="<%=name%>"
					class="form-control" id="name" name="name"
					placeholder="Enter Employee Name">
			</div>
			<div class="form-group">
				<label>SALARY</label> <input type="text" class="form-control"
					value=<%=salary%> id="salary" name="salary"
					placeholder="Enter Employee Salary">
			</div>

			<input type="submit" class="btn btn-primary">
		</form>
	</div>
	<%
		
	%>
</body>
</html>