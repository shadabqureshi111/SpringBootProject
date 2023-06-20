<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PatientReciept</title>
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
    width: 80%;
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
    height: 59px;
    display: flex;
}


</style>
</head>
<body>

	<div class="card" *ngIf="isDataFetched">
		<div class="card-header">
			<h5>Patient Report Detail</h5>
			<div class="indicatorslist">

				<button title="With eSign" class="btn btn-danger btn-sm mr-2"
					type="button" (click)="downloadAsPDF('E-Signed')">
					<i _ngcontent-fpq-c6="" class="fa fa-download"></i>
				</button>
				<button type="button" class="btn btn-primary btn-sm"
					(click)="printReceipt()">
					<i class="fa fa-print"></i>
				</button>
			</div>
		</div>
		<div class="card-body">
			<div id="ackReceiptBodyContent">
				<table class="reciept">
					<tr>
						<td class="px-2 py-3">
							<!-- header -->
							<table class="reciept-header">
								<tr>
									<!-- <strong>{{ackData.ackId}} -->
									<td class="reciept-no">Patient Id : </strong></td>
								</tr>
							</table> <!-- header end--> <!-- family imgs -->
							<!-- <table>
								<tr>
									<td>
										<div class="receipt-imgs" *ngFor="let row of listOfPhotos">
											<img class="memberProfileImage"
												src="./assets/img/no-user-images.png" alt="Person image">
										</div>
									</td>
									<td class="receipt-barcode text-right"><img
										class="barCodeAckReceipt" src="" alt="Rajasthan Jan Aadhaar">
										src="./assets/img/barcode2.jpg"</td>
								</tr>
							</table> --> <!-- family imgs end--> <!-- hof details -->
							<table style="width: 123%; margin: 35px 0px 76px 0px; ">
								<tr>
									<td>Patient Name : </td>
									<td width="200"><strong></strong></td>
									<td>Aadhar No : </td>
									<td width="200"><strong></strong></td>
									<td>Age :</td>
									<td width="200" colspan="3"><strong></strong></td>
									
								</tr>
								
								<tr>
									<td>Mobile Number :</td>
									<td><strong></strong></td>
									<td>E-mail : </td>
									<td><strong></strong></td>
									<td>Telephone Number : </td>
									<td><strong></strong></td>
									
								</tr>
								<tr>
									<td>Gender : </td>
									<td><strong></strong></td>
									<td>Address : </td>
									<td><strong></strong></td>
									<td>Father Name : </td>
									<td><strong></strong></td>
									
								</tr>
								<tr>
									<td>Spouse Name : </td>
									<td><strong></strong></td>
								</tr>
								
								
								<!-- <tr>
									<td>{{'Family Bank Name' | translate}}</td>
									<td><strong>{{ackData.bankName}}</strong></td>
									<td>{{'Family Account No.' | translate}}</td>
									<td><strong>{{ackData.accountNumber}}</strong></td>
									<td>{{'Family bank branch name' | translate}}</td>
									<td><strong>{{ackData.branchCode}}</strong></td>
									<td>{{'Duration of Stay on the Current Address (Year)' |
										translate}}</td>
									<td><strong>{{ackData.timeOfCurrentResidency}}</strong></td>
								</tr> -->
							</table> <!-- hof details end --> <!-- family details -->
							<!-- <table class="family-table" *ngIf="hasOtherMembers">
								<thead>
									<tr>
										<th class="text-center" width="30">{{'S.No.' |
											translate}}</th>
										<th>{{'Aadhaar No' | translate}}</th>
										<th>{{'Relationship with HoF' | translate}}</th>
										<th>{{'Name' | translate}}</th>
										<th>{{'Mother Name' | translate}}</th>
										<th>{{'Father Name' | translate}}</th>
										<th>{{'Spouse Name' | translate}}</th>
										<th>{{'Gender' | translate}}</th>
										<th>{{'DOB' | translate}}/{{'Age' | translate}}</th>
										<th>{{'Marital Status' | translate}}</th>
										<th>{{'Education Level' | translate}}</th>
										<th>{{'Occupation' | translate}}</th>
										<th>{{'Resident Category' | translate}}</th>
										<th>{{'Annual Income' | translate}}</th>
									</tr>
								</thead>
								<tbody>
									<tr *ngFor="let member of memberList; let i=index;">
										<td>{{i+1}}</td>
										<td>{{member.AadhaarMasked}}</td>
										<td>{{member.Relation}}</td>
										<td>{{member.Name}}</td>
										<td>{{member.Mother}}</td>
										<td>{{member.Father}}</td>
										<td>{{member.Spouse}}</td>
										<td>{{member.Gender}}</td>
										<td>{{member.DOB | date:'dd-MM-yyyy'}}/{{member.AGE}}</td>
										<td>{{member.MaritalStatus}}</td>
										<td>{{member.Education}}</td>
										<td>{{member.Occupation}}</td>
										<td>{{member.Residency}}</td>
										<td>{{member.RealIncome}}</td>
									</tr>
								</tbody>
							</table> --> <!-- family details end --> <!-- family documents identity -->
							
						<!-- 	<table>
								<tr>
									<td>{{'Ration Card Type' | translate}}</td>
									<td width="150"><strong>{{ackData.typeOfRationCard}}</strong></td>
									<td>{{'Ration Card Number' | translate}}</td>
									<td width="150"><strong>{{ackData.rationCardNumber}}</strong></td>
									<td>{{'Electricity Bill Number' | translate}}</td>
									<td width="150"><strong>{{ackData.electiConnNumber}}</strong></td>
									<td>{{'Name of Gas Agency' | translate}}</td>
									<td width="150"><strong>{{ackData.gasAgency}}</strong></td>
									
								</tr>
								<tr>
									<td>{{'Water Consumption Bill No' | translate}}</td>
									<td><strong>{{ackData.waterBill}}</strong></td>
									<td>{{'BPL/State BPL No' | translate}}</td>
									<td><strong>{{ackData.bpl}}</strong></td>
									
								</tr>
							</table> --> <!-- family documents identity end --> <!-- personal documents identity -->
							<p>
								<strong>Patient Disease</strong>
							</p>
							<!-- <table class="family-table">
								<thead>
									<tr>
										<th class="text-center" width="30">{{'S.No.' |
											translate}}</th>
										<th>{{'Name' | translate}}</th>
										<th>{{'Voter ID No' | translate}}</th>
										<th>{{'Pan Card Number' | translate}}</th>
										<th>{{'Driving Licence No' | translate}}</th>
										<th>{{'Passport Number' | translate}}</th>
										<th>{{'Employment Registration Number' | translate}}</th>
										<th>एन पी आर संख्या</th>
										<th>{{'Government Id' | translate}}</th>
										<th>{{'Mnrega Card No' | translate}}</th>
										<th>{{'PPO No' | translate}}</th>
										<th>{{'Mobile Number' | translate}}</th>
									</tr>
								</thead>
								<tbody>
									<tr *ngFor="let info of personalInfo; let j=index;">
										<td class="text-center">{{j+1}}</td>
										<td>{{info.Name}}</td>
										<td>{{info.VoterId}}</td>
										<td>{{info.PanNo}}</td>
										<td>{{info.DL}}</td>
										<td>{{info.Passport}}</td>
										<td>--</td>
										<td>--</td>
										<td>{{info.govtId}}</td>
										<td>{{info.MNAREGANO}}</td>
										<td>{{info.PPO}}</td>
										<td>{{info.Mobile}}</td>
									</tr>
								</tbody>
							</table> --> <!-- personal documents identity end -->
							<table style="margin: 25px 0px 25px 0px;width: 84%;">
								<tbody>
									<tr>
										<td><span>Patient Name : <strong> </strong></span>
										</td>
										<td class="text-center"><span>Disease : <strong><strong></strong></td>
										<td class="text-right"><span>Doctor Name : <strong><strong></strong></td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<div class="text-center">
				<button type="button" class="btn btn-danger hide-on-print"
					(click)="closeAckReceipt()">Close</button>
			</div>
		</div>
	</div>

</body>
</html>