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

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Batch</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!-- <script src="validScript.js"></script>  -->
<script src="validScript.js"></script>
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

.form-format {
	margin: 0px -50px 0px 230px;
}

label {
	font-weight: bold;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

th {
	background-color: #eb9f13;
}

td, th {
	border: 2px solid black;
	text-align: left;
	padding: 8px;
}

.downloadLink:hover {
	color: blue;
	cursor: pointer;
	text-decoration: underline;
}
</style>



</head>

<body>
	<!-- Form 1 -->
	<div class="form-1-container section-container">
		<div class="container">
			<div class="row">
				<div class="col-md-10 offset-md-1 form-1-box wow fadeInUp mt-5">

					<form action="./saveData" method="post" autocomplete="off"
						id="pDetails" onsubmit="return ValidationForm()">
						<!-- User's Credentials  -->
						<fieldset class="form-group border p-3 "
							style="background-color: #b3d9e3;">

							<div class="form-format">

								<div class="form-row ">
									<label for="inputEmail4">Select Doctor</label>
									<div class="form-group col-md-4">
										<select class="form-control" onchange="getPatient()"
											id="Doctorid"
											style="margin: 0px 0px 0px 100px; background-color: #f59a81;">
											<option hidden="hidden">Select Doctor</option>
											<c:forEach items="${doctorList}" var="dList">
												<option value="${dList.getDoctor_id()}">${dList.doctorName}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-row ">
									<label for="inputPassword4">Select Patient</label>
									<div class="form-group col-md-4">
										<select class="form-control" id="patientDropdown"
											name="doctorAppointmentId" onchange="getPatientData()"
											style="margin: 0px 0px 0px 98px; background-color: #f59a81;">

										</select>
									</div>
								</div>

								<div
									style="border: 2px solid black; height: 36px; margin: 0px 0px 10px -100px; padding: au; width: 90%;">
									<div style="display: flex; padding: 0px 0px 0px 45px;">
										&nbsp;&nbsp;

										<div style="display: flex;">
											<p>Patient Phone :</p>
											&nbsp;
											<h6 id="patientPhone" style="margin: 3px 0px 0px 0px;"></h6>
										</div>


										&nbsp;&nbsp;&nbsp;
										<div style="display: flex; margin: 0px 0px 0px 65px;">
											<p>Date Of Appointment :</p>
											&nbsp;
											<h6 id="dateOfAppointment" style="margin: 3px 0px 0px 0px;"></h6>

										</div>

									</div>
								</div>
								<div class="form-row ">
									<label for="inputEmail4">Select Disease</label>
									<div class="form-group col-md-4">
										<select class="form-control" id="DiseaseId" name="diseaseId"
											style="margin: 0px 0px 0px 94px; background-color: #f59a81;"
											onchange="getDisease()">
											<option hidden="hidden">Select Disease</option>

											<c:forEach items="${diseaseList}" var="dList">
												<option value="${dList.getDisease_id()}">${dList.getDisease_Name()}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="form-row ">
									<label for="inputEmail4">Select Medicine</label>
									<div class="form-group col-md-4">
										<select class="form-control" id="medicineId" name="medicineId"
											style="margin: 0px 0px 0px 83px; background-color: #f59a81;">
											<option hidden="hidden">Select Medicine</option>
										</select>
									</div>
								</div>

								<div class="form-row ">
									<label for="inputEmail4">Enter Prescription</label>
									<div class="form-group col-md-4"
										style="margin: 0px 0px 0px 66px;">
										<textarea class="form-control" id="prescriptionInput"
											name="prescriptions_detail"
											style="background-color: #f59a81;"></textarea>
									</div>
								</div>

								<div class="col" style="margin: 13px 0px 0px 175px;">
									<button type="submit" class="btn btn-primary btn-customized">Submit</button>
								</div>
							</div>
						</fieldset>




					</form>
				</div>
			</div>
		</div>
	</div>
	<table style="width: 90%; margin: auto;">
		<tr>
			<th>SlNo</th>
			<th>Date Of Appointment</th>
			<th>Doctor Name</th>
			<th>Patient Name</th>
			<th>Disease Name</th>
			<th>Medicine Name</th>
			<th>Appointment Status</th>
			<th></th>
		</tr>
		<c:forEach items="${pData}" var="patientData" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${patientData.doctorAppointmentId.getDate_Of_appointment()}</td>
				<td>${patientData.doctorAppointmentId.doctorId.doctorName}</td>
				<td>${patientData.doctorAppointmentId.patientName}</td>
				<td>${patientData.diseaseId.disease_Name}</td>
				<td>${patientData.medicineId.medicine_Name}</td>
				<td>${patientData.doctorAppointmentId.getPatient_Status()}</td>
				<!-- <td><p class="downloadLink">Download Prescription</p></td> -->
				<td><c:if
						test="${patientData.doctorAppointmentId.getPatient_Status().equals('p')}">
						<a href="/download/${patientData.description}"
							class="downloadLink">Download Prescription</a>
					</c:if></td>



			</tr>
		</c:forEach>
	</table>

	</div>

	<script>
		//Fetch Doctor List
		function getPatient() {
			var value = document.getElementById("Doctorid").value;
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "/getPatientList?doctorValue=" + value, true);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var patientList = JSON.parse(this.responseText);
					console.log(patientList)
					// Update the dropdown list on your page with the patient list
					var dropdown = document.getElementById("patientDropdown");
					dropdown.innerHTML = "<option hidden=hidden>Select Patient</option>";
					for (var i = 0; i < patientList.length; i++) {
						var patient = patientList[i];
						var option = document.createElement("option");
						option.value = patient.patientId;
						option.text = patient.patientName;
						dropdown.add(option);
					}
				}
			};
			xhr.send();
		}

		//Basis on Doctor Id Fetch Patient List and Data 
		function getPatientData() {
			//var pId = document.getElementById("patientDropdown").value;
			var pName = document.getElementById("patientDropdown").options[document
					.getElementById("patientDropdown").selectedIndex].text;
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "/getPatientList?pName=" + pName, true);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var patientData = JSON.parse(this.responseText);

					for (var i = 0; i < patientData.length; i++) {
						var patient = patientData[i];
						var patientPhone = document
								.querySelector('#patientPhone');
						var dateOfAppointment = document
								.querySelector('#dateOfAppointment');
						patientPhone.innerText = patient.phone;

						var datetime = patient.date; // example datetime value
						var date = new Date(datetime); // create a Date object from the datetime string

						//It show Date&Time
						/* var dateStr = date.toLocaleDateString(); // extract the date string in local format
						var timeStr = date.toLocaleTimeString(); // extract the time string in local format
						var dateStr = dateStr + ' ' + timeStr; */

						//It show Date				
						var datetime = patient.date;
						var date = new Date(datetime);
						var options = {
							day : '2-digit',
							month : '2-digit',
							year : 'numeric'
						};
						var dateStr = date.toLocaleDateString('en-GB', options); // extract the date string in the desired format

						var dateOfAppointment = document
								.getElementById("dateOfAppointment");
						dateOfAppointment.innerText = dateStr; // update the relevant HTML element
					}
				}
			};
			xhr.send();
		}

		//Basis on Disease Id Fetch Medicine
		function getDisease() {
			var diseaseId = document.getElementById("DiseaseId").value;
			var xhr = new XMLHttpRequest();
			xhr.open("GET", "/getMedicineList?diseaseId=" + diseaseId, true);
			xhr.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					var medicineList = JSON.parse(this.responseText);
					// Update the dropdown list on your page with the patient list
					var dropdown = document.getElementById("medicineId");
					dropdown.innerHTML = "<option hidden=hidden>Select Patient</option>";
					for (var i = 0; i < medicineList.length; i++) {
						var patient = medicineList[i];
						var option = document.createElement("option");
						option.value = patient.medicineId;
						option.text = patient.medicineName;

						dropdown.add(option);
					}
				}
			};
			xhr.send();
		}
	</script>



</body>
</html>