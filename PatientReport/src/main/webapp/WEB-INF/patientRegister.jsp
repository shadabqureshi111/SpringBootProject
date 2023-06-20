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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<style type="text/css">
.controls {
	width: 294px;
	margin: 15px auto;
}

#remove_fields {
	float: right;
}

.controls a i.fa-minus {
	margin-right: 5px;
}

a {
	color: black;
	text-decoration: none;
}

h1 {
	text-align: center;
	font-size: 48px;
	color: #232c3d;
}

* {
	box-sizing: border-box;
}

form.example input[type=text] {
	padding: 6px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 80%;
	background: #f1f1f1;
}

form.example button {
	float: left;
	width: 20%;
	padding: 6px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}
</style>


<script type="text/javascript">
	function ValidationForm()
	{
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
		/* var dob = document.getElementById("ddte").value;
		var d=new Date().getFullYear();
		var d1=new Date(dob).getFullYear();
		var date2=d1-d; */
		
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

	function ageCount() 
	{
		var dob = document.getElementById("ddte").value;
		var d=new Date().getFullYear();
		var d1=new Date(dob).getFullYear();
		var date2=d-d1;
		document.getElementById('age').value=date2;
	}
	
</script>

</head>

<body>
	<!-- Form 1 -->
	<div class="form-1-container section-container">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 form-1-box wow fadeInUp">
					<div class="card-header">
						<div class="indicatorslist">
							<form class="example" action="./fetchDetail"
								style="margin: auto; max-width: 300px; float: left;">
								<a href="http://localhost:8080/form/fetchDetail"> <input
									type="text" placeholder="Search..">
									<button type="submit">
										<i class="fa fa-search"></i>
									</button>
								</a>
							</form>
							<p class="mand" style="text-align: end;">
								<!-- <button type="reset" class="btn btn-primary btn-customized">Find Data</button> -->
								<span class="text-danger"> * Indicates mandatory </span>
							</p>
						</div>
					</div>
					<form action="./saveData" method="post" autocomplete="off"
						id="pDetails" onsubmit="return ValidationForm()">
						<!-- User's Credentials  -->
						<fieldset class="form-group border p-3">
							<legend class="w-auto px-2 text-primary">Patient
								Personal Details</legend>

							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="inputEmail4">First Name<span
										class="text-danger">*</span></label> <input type="text"
										class=" form-control" id="fn" name="firstName" value="vijay"
										placeholder="Enter First Name"> <span id="fnerr"
										style="color: red"></span>
								</div>


								<div class="form-group col-md-4">
									<label for="inputPassword4">Last Name<span
										class="text-danger">*</span></label> <input type="text"
										class="form-control" id="ln" name="lastName"
										placeholder="Enter Last Name" value="singh"> <span
										id="lnerr" style="color: red"></span>

								</div>

								<div class="form-group col-md-4">
									<label for="inputEmail4">Phone No<span
										class="text-danger">*</span></label> <input type="text"
										class=" form-control" id="num" name="number"
										placeholder="Enter Mobile Number" value="8276875434"
										oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
										onchange="getDet()"> <span id="numerr"
										style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputPassword4">Date of Birth<span
										class="text-danger">*</span></label> <input type="date"
										class="form-control" id="ddte" name="date" onchange="ageCount()"> <span
										id="ageerr" style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputPassword4">Age<span
										class="text-danger">*</span></label> <input type="text"
										class="form-control" id="age"  
										readonly="readonly">
								</div>
									<p ></p>


								<div class="form-group col-md-4">
									<label for="inputPassword4">Gender<span
										class="text-danger">*</span></label><br>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											id="male" value="male" selected> <label
											class="form-check-label" for="inlineRadio1">Male</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="gender"
											id="female" value="female"> <label
											class="form-check-label" for="inlineRadio2">Female</label>
									</div>
									<div>
										<span id="gerr" style="color: red"></span>
									</div>
								</div>

								<div class="form-group col-md-4">
									<label for="inputPassword4">Father Name<span
										class="text-danger">*</span><span
										class="text-danger"></span></label> <input type="text"
										class="form-control" id="fatherName" name="fatherName"
										value="sanju singh" 
										placeholder="Enter Age"> <span id="fnerr"
										style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputPassword4">Spouse Name</label> <input type="text"
										class="form-control" id="spouseName" name="spouseName"
										value="mana singh" placeholder="Enter Spouse Name">
									<span id="sperr" style="color: red"></span>
								</div>
							</div>

						</fieldset>


						<fieldset class="form-group border p-3">
							<legend class="w-auto px-2 text-primary">Address Details</legend>

							<div class="form-row">

								<div class="form-group col-md-4">
									<label for="inputCity">Address<span class="text-danger">*</span></label>
									<input type="text" class="form-control"
										placeholder="Enter Address" id="address" name="address"
										value="lal kothi"> <span id="adderr"
										style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputCity">City<span class="text-danger">*</span></label>
									<input type="text" class="form-control"
										placeholder="Enter City" id="city" name="city" value="jaipur">
									<span id="cityerr" style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputState">State<span class="text-danger">*</span></label>
									<input type="text" class="form-control"
										placeholder="Enter State" id="state" name="state"
										value="rajsthan"> <span id="stateerr"
										style="color: red"></span>
								</div>

								<div class="form-group col-md-4">
									<label for="inputZip">Pin Code<span class="text-danger">*</span></label>
									<input type="text" class="form-control" id="pincode"
										value="323454" name="pincode" placeholder="Enter PinCode"
										oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
										onchange="getDet()" value="234567"> <span id="pinerr"
										style="color: red"></span>
								</div>

							</div>

						</fieldset>


						<fieldset class="form-group border p-3">
							<legend class="w-auto px-2 text-primary">Patient Disease</legend>

							<%-- <div class="form-row" id="dynamicadd">
								<table style="width: 100%;">
									<tr>
										<td><label for="inputCity">Disease<span
												class="text-danger">*</span></label></td>
										<td><label for="inputCity">Doctor Name<span
												class="text-danger">*</span></label></td>
										<td><label for="inputCity">Prescription Details<span
												class="text-danger">*</span></label></td>
										<td style="text-align: center;">Action</td>
									</tr>
									<tr style="text-align: center;">
										<div class="form-group col-md-3">
											<!-- <label for="inputCity">Disease<span class="text-danger">*</span></label> -->
											<td><select name="diseaseName" id="diseaseId"
												class="form-control" onchange="getDocName()">
													<option selected disabled>Select Disease</option>
													<c:forEach items="${diseaseList}" var="dList">
														<option value="${dList.diseaseId}">${dList.diseaseName}</option>
													</c:forEach>
											</select> <span id="diseaseerr" style="color: red"></span></td>
										</div>

										<div class="form-group col-md-3">
											<!-- <label for="inputCity">Doctor Name</label> -->
											<td><input type="text" class="form-control"
												placeholder="" id="dname" readonly name="dname"> <span
												id="dddname"></span></td>
										</div>

										<div class="form-group col-md-3">
											<!-- <label for="inputCity">Prescription Details</label>  -->
											<td><input type="text" class="form-control"
												placeholder="Enter prescription" id="prescription_detail"
												name="prescription_detail"> <span id="preserr"
												style="color: red"></span></td>

										</div>
										<div class="form-group col-md-3">
											<td>
												<button type="button" class="btn btn-primary" id="add">Add</button>

											</td>
										</div>

									</tr>
								</table>

							</div> --%>
							<div class="form-row" id="dynamicadd">

								<!-- <div class="wrap">
									<button type="button"  class="add" class="btn btn-success">+</button>
								</div> -->
								<table style="width: 100%;">
									<tr>
										<td><label for="inputCity">Disease<span
												class="text-danger">*</span></label></td>
										<td><label for="inputCity">Doctor Name<span
												class="text-danger">*</span></label></td>
										<td><label for="inputCity">Prescription Details<span
												class="text-danger">*</span></label></td>
										<td style="text-align: center;">Add/Remove</td>
									</tr>
									<tr style="text-align: center;">

										<div class="form-group col-md-3">
											<td><select name="fk_disease_id" id="diseaseId"
												class="form-control" onchange="getDocName()">
													<option selected disabled>Select Disease</option>
													<c:forEach items="${diseaseList}" var="dList">
														<option value="${dList.diseaseId}">${dList.diseaseName}</option>
													</c:forEach>
											</select> <span id="diseaseerr" style="color: red;"></span></td>
										</div>


										<div class="form-group col-md-3">
											<td><input type="text" class="form-control"
												placeholder="" id="dname" readonly="readonly" name="dname">
												<span id="dddname"></span></td>
										</div>


										<div class="form-group col-md-3">
											<td><input type="text" class="form-control"
												placeholder="Enter prescription" id="prescription_detail"
												name="prescription_detail" value="namcold"> <span
												id="preserr" style="color: red"></span></td>
										</div>
										<td>
											<button type="button" class="btn btn-primary" id="add">Add</button>

										</td>
									</tr>
								</table>


							</div>
						</fieldset>
						<!-- <div class="form-group">
							<label>Verify</label>

							<div class="g-recaptcha"
								data-sitekey="6LfnrvcZAAAAAIbXw3sIxOELZzTejOtnZeJtsiCp"></div>
						</div> -->
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
			 	var id = $("#diseaseId").val();
			$.ajax({
				url : "./getDName",
				type : 'GET',
				data : { id : id },
				success : function(data) 
				{
					$('#dname').html(response);
					
				},
			}); 
 
			 /* var id=$("#diseaseId").val();
			   $.ajax({
				   type:"GET",
				   url: "./getDName",
			       data: {id:id},
			       success :function(response)
			       {
			      	 $("#dname").html(response);
			       }
				   }); 
		} */
	</script>

	<script type="text/javascript">
$( function() {
    $.datepicker.setDefaults({
        onClose:function(date, inst){
            $("#selectedDtaeVal").html(date);
        }
    });
 
    $( "#datepicker" ).datepicker();
});

</script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var i = 1;
							var html = '<table style="width:98.7%;" id="row'
									+ i
									+ '"><tr style="text-align: center;">'
									+ ' <div class="form-group "> <td> '
									+ '<select name="diseaseName" id="diseaseId" class="form-control" onchange="getDocName()"> '
									+ '<option selected disabled>Select Disease</option> '
									+ '<c:forEach items="${diseaseList}" var="dList"> '
									+ '<option value="${dList.diseaseId}">${dList.diseaseName}</option> '
									+ '</c:forEach> </select> <span id="diseaseerr" style="color: red"></span> '
									+ '</td> </div> <div class="form-group "> <td> '
									+ '<input type="text" class="form-control" placeholder="" id="dname" readonly name="dname">'
									+ ' <span id="dddname"></span>  </td> </div> <div class="form-group "> <td> '
									+ '<input type="text" class="form-control" placeholder="Enter prescription" ' +
	            'id="prescription_detail" name="prescription_detail"></td> </div><td>'
									+ '<button type="button" class="btn btn-danger" id="remove_row">Remove</button></td> '
									+ '</tr></table>'

							$('#add').click(function() {
								//alert('ok');
								if (i < 2) {
									$('#dynamicadd').append(html);
									//$('#dynamicadd').append('<p></p>');
									i++;
								}
							});
							$('#dynamicadd').on('click', '#remove_row',
									function() {
										//var row_id = $(this).attr("id");
										$('#row' + 1 + '').remove('');
										//$(this).closest('tr').remove();
										i--;
									});
						});
	</script>
</body>
</html>