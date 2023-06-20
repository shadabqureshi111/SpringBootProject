<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
body {
	background: #007bff;
	background: linear-gradient(to right, #0062E6, #33AEFF);
}

.btn-login {
	font-size: 0.9rem;
	letter-spacing: 0.05rem;
	padding: 0.75rem 1rem;
}

.btn-google {
	color: white !important;
	background-color: #ea4335;
}

.btn-facebook {
	color: white !important;
	background-color: #3b5998;
}
</style>
</head>
<body>

	<div class="container">
		<c:if test="${not empty successMessage}">
			<div class="success">${successMessage}</div>
		</c:if>

		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card border-0 shadow rounded-3 my-5">


					<div class="card-body p-4 p-sm-5">
						<h5 class="card-title text-center mb-5 fw-light fs-5">Employee
							Registration</h5>
						<form action="./saveEmp" method="post" modelAttribute="emp">
							<div class="form-floating mb-3">
								<label for="floatingInput">Id</label> <input type="text"
									class="form-control" id="id" name="id"
									placeholder="Enter Employee Id">

							</div>
							<div class="form-floating mb-3">
								<label for="floatingPassword">Firstname</label> <input
									type="text" class="form-control" id="fname" name="fname"
									placeholder="Enter Employee Firstname">
							</div>

							<div class="form-floating mb-3">
								<label for="floatingPassword">lastname</label> <input
									type="text" class="form-control" id="lname" name="lname"
									placeholder="Enter Employee Lastname">
							</div>
							<div class="form-floating mb-3">
								<label for="floatingPassword">Salary</label> <input type="text"
									class="form-control" id="salary" name="salary"
									placeholder="Enter Employee Salary">

							</div>

							<div class="d-grid">
								<button class="btn btn-primary btn-login text-uppercase fw-bold"
									type="submit">Register</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>