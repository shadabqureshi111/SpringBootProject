<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Silver Jewellery</title>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.debug.js"></script>
</head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}
</style>
<body>
	<h1 class="text-primary text-center my-4">Silver Jewellery Price
		Calculator</h1>
	<div class="container col-sm-12 p-5 mt-4">

		<form action="/save" method="post" enctype="multipart/form-data"
			class="form-group " onsubmit="return fileValidation()">

			<fieldset>
				<div class="row">
					<div class="col-sm-5">
						<label class="text-primary">Upload Price Slab Excel File</label> <input
							type="file" name="jwExc" id="jwExc" class="form-control" accept=".xlsx, .xls" required>
					</div>
				</div>
				<div class="row">
					<label class="text-primary">Today's Silver Rate (per 10gm)</label>
					<div class="col-sm-2">
						<input type="text" name="rate" id="rate" class="form-control">
					</div>
				</div>
				<div class="col-sm-6" style="margin: -10px 0px 0px 120px;">

					<input type="submit" class="btn btn-success mt-4" value="Import"
						class="form-control">
				</div>
			</fieldset>
		</form>
		<div class="container">
			<h3 class="text-danger">Price Details</h3>
			<table class="table">
				<thead>
					<tr>
						<th>S.No#</th>
						<th>Product Id</th>
						<th>Type</th>
						<th>Current Date</th>
						<th>Weight</th>
						<th>Rate per Gram</th>
						<th>Making charges After Dis</th>
						<th>Gross Amount</th>
						<th>Gst Amount</th>
						<th>Net Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="priceSlab" items="${priceSlabs}" varStatus="status">

						<tr>
							<td>${status.index + 1}</td>
							<%-- <td>${user.product_id.product_id }</td>
							<td>${user.product_id.product_type }</td>
							<td>${user.date}</td>
							<td>${user.product_id.weight}</td>
							<td>${user.current_rate_per_gram}</td>
							<td>${user.making_charge_after_dis}</td>
							<td>${user.gross_amount}</td>
							<td>${user.gst_amount}</td>
							<td>${user.net_amount}</td> --%>
							<td>${priceSlab.productDtl.productId}</td>
							<td>${priceSlab.productDtl.productType}</td>
							<td>${priceSlab.currentDate}</td>
							<td>${priceSlab.productDtl.weight}</td>
							<td>${priceSlab.currentRatePerGram}</td>
							<td>${priceSlab.makingChargeAfterDiscount}</td>
							<td>${priceSlab.grossAmount}</td>
							<td>${priceSlab.netPrice}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<!-- <button class="btn btn-primary" onclick="generatePDF()">Export
				As Pdf</button> -->
		</div>
	</div>
</body>
<script type="text/javascript">

const silverRateField = document.getElementById('silver-rate');
silverRateField.addEventListener('input', () => {
  if (silverRateField.checkValidity()) {
    
    silverRateField.classList.remove('is-invalid');
  } else {
    silverRateField.classList.add('is-invalid');
    
  }
});
</script>
</html>