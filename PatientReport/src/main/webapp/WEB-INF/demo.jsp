<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width = device-width, initial-scale = 1, shrink-to-fit = no">



<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<style type="text/css">
.wrap {
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 100%;
	margin-bottom: 40px;
	padding-bottom: 15px;
	border-bottom: 2px solid #e4e1e1;
}

.add {
	text-decoration: none;
	display: inline-block;
	width: 30px;
	height: 30px;
	background: #8bc34a;
	font-size: 2rem;
	font-weight: bold;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
}

.flex {
	display: flex;
	gap: 1.5em;
}

.delete {
	text-decoration: none;
	display: inline-block;
	background: #f44336;
	color: #fff;
	font-size: 1.5rem;
	font-weight: bold;
	width: 30px;
	height: 30px;
	margin-left: auto;
	display: flex;
	justify-content: center;
	align-items: center;
	cursor: pointer;
}
</style>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Registration</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script src="validScript.js"></script>  -->
<script src="validScript.js"></script>



<script type="text/javascript">
	function ValidationForm() {
		var fname = document.getElementById("fn").value;
		var lname = document.getElementById("ln").value;
		var num = document.getElementById("num").value;
		var age = document.getElementById("age").value;
		var male = document.getElementById("male").checked;
		var female = document.getElementById("female").checked;
		var address = document.getElementById("address").value;
		var city = document.getElementById("city").value;
		var state = document.getElementById("state").value;
		var pincode = document.getElementById("pincode").value;
		var disease = document.getElementById("diseaseId").value;
		var prescription = document.getElementById("prescription_detail").value;
		if (fname.length<3||fname.length>21 || fname == "" || fname == null) {
			fnerr.innerHTML = "Enter Atleast 3 Character";
			return false;
		} else if (lname.length<3||lname.length>21 || lname == ""
				|| lname == null) {
			lnerr.innerHTML = "Enter Atleast 3 Character";
			return false;
		} else if (num.length<10 || num.length>10) {
			numerr.innerHTML = "Enter 10 Digit Number";
			return false;
		} else if (age < 12) {
			ageerr.innerHTML = "Age Should Be Minimum 12 ";
			return false;
		} else if (male == false && female == false) {
			gerr.innerHTML = "Select Gender ";
			return false;
		} else if (address == "" || address == null || address.length < 3) {
			adderr.innerHTML = "Enter Address"
			return false;
		} else if (city == "" || address == null || city.length < 3) {
			cityerr.innerHTML = "Enter Address"
			return false;
		} else if (state == "" || state == null || state.length < 3) {
			stateerr.innerHTML = "Enter Address"
			return false;
		} else if (pincode.length<6||pincode.length>6) {
			pinerr.innerHTML = "Enter PinCode"
			return false;
		} else if (disease == "Select Disease") {
			diseaseerr.innerHTML = "Select Disease"
			return false;
		} else if (prescription < 3) {
			preserr.innerHTML = "Enter Atleast 3 Character"
			return false;
		}
		return true;
	}
</script>
<style type="text/css">

.wrap {
	display: flex;
	justify-content: space-between;
	align-items: center;
	width: 100%;
	margin-bottom: 15px;
	padding-bottom: 15px;
	border-bottom: 2px solid #e4e1e1;
}

.add {
	text-decoration: none;
	display: inline-block;
	width: 45px;
	height: 25px;
	background: #8bc34a;
	font-size: 20px;
	font-weight: bold;
	color: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	cursor: pointer;
}
</style>
</head>

<body>
	<!-- Form 1 -->
	<div class="form-1-container section-container">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 form-1-box wow fadeInUp">
					<form action="./getData" method="post" autocomplete="off"
						onsubmit="return ValidationForm()">
						<!-- User's Credentials  -->

						<fieldset class="form-group border p-3">
							<legend class="w-auto px-2 text-primary">Patient Disease</legend>

							<div class="form-row" id="dynamicadd">
							
								<!-- <div class="wrap">
									<button type="button"  class="add" class="btn btn-success">+</button>
								</div> -->
<table style="width: 100%;">							
<tr>
<td><label for="inputCity">Disease<span class="text-danger">*</span></label></td>
<td><label for="inputCity">Doctor Name<span class="text-danger">*</span></label></td>
<td><label for="inputCity">Prescription Details<span class="text-danger">*</span></label></td>
<td>Add/Remove</td></tr>
	<tr style="text-align: center;">

								<div class="form-group col-md-3">
									<td>
									<select name="diseaseName" id="diseaseId" class="form-control"
										onchange="getDocName()">
										<option selected disabled>Select Disease</option>
										<c:forEach items="${diseaseList}" var="dList">
											<option value="${dList.diseaseId}">${dList.diseaseName}</option>
										</c:forEach>
									</select> <span id="diseaseerr" style="color: red"></span>
									</td>
								</div>


								<div class="form-group col-md-3">
								<td>
									<input type="text"
										class="form-control" placeholder="" id="dname" readonly
										name="dname"> <span id="dddname"></span>
								</td>
								</div>


								<div class="form-group col-md-3">
							<td>
									<input
										type="text" class="form-control"
										placeholder="Enter prescription" id="prescription_detail"
										name="prescription_detail"> <span id="preserr"
										style="color: red"></span>
							</td>
							<td>
							<button type="button" class="btn btn-primary" id="add">Add</button>
								
							</td>
								</div>
</tr>
</table>


							</div>
						</fieldset>

						<!-- Submit Button  -->
						<div class="form-group row text-center">

							<div class="col">
								<button type="reset" class="btn btn-primary btn-customized">Reset</button>
								<button type="submit" class="btn btn-primary btn-customized">Submit</button>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function getDocName() {
			var did = $("#diseaseId").val();
			// dname.value = dname; 
			$.ajax({
				url : "./getDoctorName",
				type : 'GET',
				data : {
					did : did
				},
				success : function(data) {
					$('#dname').val(data);
				}
			});
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() 
				{
				var i = 1;
				var html='<table style="width: 98.7%;" id="row'+i+'"><tr style="text-align: center;">' +
	            ' <div class="form-group "> <td> ' +
	            '<select name="diseaseName" id="diseaseId" class="form-control" onchange="getDocName()"> ' +
	            '<option selected disabled>Select Disease</option> ' +
	            '<c:forEach items="${diseaseList}" var="dList"> ' +
	            '<option value="${dList.diseaseId}">${dList.diseaseName}</option> ' +
	            '</c:forEach> </select> <span id="diseaseerr" style="color: red"></span> ' +
	            '</td> </div> <div class="form-group "> <td> ' +
	            '<input type="text" class="form-control" placeholder="" id="dname" readonly name="dname">' +
	            ' <span id="dddname"></span>  </td> </div> <div class="form-group "> <td> ' +
	            '<input type="text" class="form-control" placeholder="Enter prescription" ' +
	            'id="prescription_detail" name="prescription_detail"></td> </div><td>' +
	            '<button type="button" class="btn btn-danger" id="remove_row">Remove</button></td> ' +
	            '</tr></table>'
				
					$('#add').click(function() 
							{
								//alert('ok');
								if(i<2)
								   {
								      $('#dynamicadd').append(html);
									  //$('#dynamicadd').append('<p></p>');
									  i++;
								   }
							 });
					$('#dynamicadd').on('click', '#remove_row', function() {
								 //var row_id = $(this).attr("id");
								$('#row' + 1 + '').remove(''); 
								//$(this).closest('tr').remove();
								i--;
							});
						});
	</script>
</body>
</html>