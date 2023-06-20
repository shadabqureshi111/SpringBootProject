<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
</style>
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js" ></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">

		<h1 style="color: red">Pay Slip Generator</h1>
		<div style="background-color: gray">
			<form action="./excel" method="post"
				enctype="multipart/form-data">
				<fieldset>
					<div class="row py-5 px-5">
						<div class="col-md-6">
							<label>upload excel file*</label> <input
								class="form-control" type="file" name="file">
						</div>
						<!-- <div class="col-md-2 py-4">
							<input style="background-color: red" class="form-control"
								type="submit" name="brower" value="browser">
						</div> -->
					</div>
					<div class="row py-2">
						<div class="col-md-1 offset-md-5">
							<input class="btn btn-primary" type="submit" value="import">
						</div>
					</div>



				</fieldset>

			</form>
		</div>

         <div style="padding-top: 100px; text-align: center">
		<h5>Employee Salary Details</h5>
		<table class="table table-striped ">
			<thead>
				<tr>
					<th>id</th>
					<th>emp_id</th>
					<th>month</th>
					<th>year</th>
					<th>hra</th>
					<th>da</th>
					<th>ta</th>
					<th>pf</th>
					<th>net_salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${EmpSalary}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.emp_id}</td>
						<td>${user.month}</td>
						<td>${user.year}</td>
						<td>${user.hra}</td>
						<td>${user.da}</td>
						<td>${user.ta}</td>
						<td>${user.pf}</td>
						<td>${user.net_salary}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button class="btn btn-primary" onclick="generatePDF()">Export As Pdf</button>
		</div>
	</div>

</body>
<script type="text/javascript">

function generatePDF() {
	
	$.ajax({
			type : "GET",
			url : "./downLoadSlip",  
			
			success : function(response){
				//console.log(response);
				
				const linkSource = "data:application/pdf;base64,"+response;
				const downloadLink = document.createElement("a");
				const fileName = "abc.pdf";
				downloadLink.href = linkSource;
				downloadLink.download = fileName;
				downloadLink.click(); 
			}
	});
}

</html>