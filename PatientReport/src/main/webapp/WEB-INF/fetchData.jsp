<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Latest compiled and minified CSS -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
	.indicatorslist {
    flex: 0 0 80%;
    position: relative;
    display: flex;
    justify-content: flex-end;
}
  .card {
    width: 100%;
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: 0.25rem;
    margin: auto;
}
.card-header:first-child {
    border-radius: calc(0.25rem - 1px) calc(0.25rem - 1px) 0 0;
    height: 60px;
    display: flex;
}
	.btn-warning {
    color: #212529;
    background-color: #ffc107;
    border-color: #ffc107;
    height: 42px;
    width: 80px;
    font-size: 18px;
    text-align: center;
    margin-top: 0px;
}
.dataTables_wrapper {
    margin-top: 31px;
}
	</style>
</head>
<body>
<div class="card">
		<div class="card-header">
			<h5 style="margin: 6px;">Patient Report Detail</h5>
			<div class="indicatorslist">

				<a class="btn btn-warning" href="http://localhost:8080/form/registration">Back</a>
			</div>
		</div>
</div>
<!-- <h2 class="text-primary text-center">Patient Detail</h2> -->
<table class="table table-striped" id="studentData">
			<thead>
				<th scope="col">SrNo.</th>
				<th scope="col">PatientName</th>
				<th scope="col">FatherName</th>
				<th scope="col">Gender</th>
				<th scope="col">Age</th>
				<th scope="col">Date</th>
				<th scope="col">Disease</th>
				<th scope="col">DoctorName</th>
				<th scope="col">Prescription</th>
				<th scope="col">Action</th>
				<th scope="col">View Detail</th>
			</thead>
			
			<tbody>
			<c:forEach items="${patientDetails}" var="user" varStatus="count">
				<%-- <tr>
					<td>${count.index+1}</td>
					<td>${user.fk_patient_id.firstName}${'' user.fk_patient_id.lastName}</td>
					<td>${user.fk_patient_id.fk_patient_id.fatherName}</td>
					<td>${user.fk_patient_id.fk_patient_id.gender}</td>
					<td>${user.fk_patient_id.fk_patient_id.age}</td>
					 <td>${user. date_of_visit}</td>
					<td>${user.fk_disease_id.diseaseName}</td>
				    <td>${user.fk_disease_id.doctor_name}</td>
				    <td>${user.prescription_detail}</td>
				 	<td><a href="./deleteDetail?id=${user.prescription_id}">Delete</a> </td>
					<td> <a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="16" 
					height="16" fill="red" class="bi bi-filetype-pdf" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                     d="M14 4.5V14a2 2 0 0 1-2 2h-1v-1h1a1 1 0 0 0 1-1V4.5h-2A1.5 1.5 0 0 1 9.5 3V1H4a1 1 0 0 0-1 1v9H2V2a2 2 0 0 1 2-2h5.5L14 4.5ZM1.6 11.85H0v3.999h.791v-1.342h.803c.287 0 .531-.057.732-.173.203-.117.358-.275.463-.474a1.42 1.42 0 0 0 .161-.677c0-.25-.053-.476-.158-.677a1.176 1.176 0 0 0-.46-.477c-.2-.12-.443-.179-.732-.179Zm.545 1.333a.795.795 0 0 1-.085.38.574.574 0 0 1-.238.241.794.794 0 0 1-.375.082H.788V12.48h.66c.218 0 .389.06.512.181.123.122.185.296.185.522Zm1.217-1.333v3.999h1.46c.401 0 .734-.08.998-.237a1.45 1.45 0 0 0 .595-.689c.13-.3.196-.662.196-1.084 0-.42-.065-.778-.196-1.075a1.426 1.426 0 0 0-.589-.68c-.264-.156-.599-.234-1.005-.234H3.362Zm.791.645h.563c.248 0 .45.05.609.152a.89.89 0 0 1 .354.454c.079.201.118.452.118.753a2.3 2.3 0 0 1-.068.592 1.14 1.14 0 0 1-.196.422.8.8 0 0 1-.334.252 1.298 1.298 0 0 1-.483.082h-.563v-2.707Zm3.743 1.763v1.591h-.79V11.85h2.548v.653H7.896v1.117h1.606v.638H7.896Z"/>
					</svg></a></td>
					<a href="/updateData?number=${user.number}" >Update</a>
	</tr> --%>
	</c:forEach>
	</tbody>
	</table>
	
	
	<script type="text/javascript">
	$(document).ready(function () {
		  $('#studentData').DataTable();
		 // $('.dataTables_length').addClass('bs-select');
		});
	</script>
	
	
</body>
</html>