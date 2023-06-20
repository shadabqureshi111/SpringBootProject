/**
 * 
 */
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
		}
		 else if (age<12) {
				ageerr.innerHTML = "Age Should Be Minimum 12 ";
				return false;
			}
		 else if (male==false && female==false) {
				gerr.innerHTML = "Select Gender ";
				return false;
			}
		 else if(address==""||address==null||address.length<3)
			 {
			 	adderr.innerHTML="Enter Address"
				return false;
			 }
		 else if(city==""||address==null||city.length<3)
		 {
		 	cityerr.innerHTML="Enter Address"
			return false;
		 }
		 else if(state==""||state==null||state.length<3)
		 {
		 	stateerr.innerHTML="Enter Address"
			return false;
		 }
		 else if(pincode.length<6||pincode.length>6)
		 {
		 	pinerr.innerHTML="Enter PinCode"
			return false;
		 }
		 else if(disease=="Select Disease")
		 {
			 diseaseerr.innerHTML="Select Disease"
			return false;
		 }
		 else if(prescription<3)
		 {
			 preserr.innerHTML="Enter Atleast 3 Character"
			return false;
		 }
		return true;
	}
	
	
	
	
	
	
/*const addBtn=document.querySelector(".add");
const input=document.querySelector(".inp-group");

function addInput()
	{
		const name=document.createElement("input");
		name.type="text";
		name.placeholder="Enter Doctor Name";
		
		const prescription=document.createElement("input");
		prescription.type="text";
		prescription.placeholder="Prescription Detail";
	
		const btn=document.createElement("a");
		btn.className="delete";
		btn.innerHTML="&times";		
		
		const flex=document.createElement("div")
		flex.className="flex";
		
		input.appendChild(flex);
		flex.appendChild(name);
		flex.appendChild(email);
		flex.appendChild(btn);
	}
	
	addBtn.addEventListener("click",addInput);*/