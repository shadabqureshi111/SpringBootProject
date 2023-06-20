<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String role = (String) request.getAttribute("role");
	System.out.print(role); %>

<% 
if (role.equals("admin")) 
	{ 
%>
		<h2>Admin Page</h2>
<%  } 
else if (role.equals("hr")) 
	{ 
%>
		<h2>HR Page</h2>
<%  } 
else 
	{ 
%>
		<h2>Guest Page</h2>
<%  }

%>
</body>
</html>