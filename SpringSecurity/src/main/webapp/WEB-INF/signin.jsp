<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.com">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3>Login Here</h3>
						<form th:action="@{/dologin}" method="post">
							
							<div th:if="${param.error}" class="text-danger">
								Invalid Username and Password
							</div>
							
							
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Username</label> 
								<input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" name="password" class="form-control" id="exampleInputPassword1">
							</div>
							
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>

				</div>

			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>