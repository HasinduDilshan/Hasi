<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="Stylesheet" href="jquery.datetimepicker.min.css">

<script src="jquery.js"></script>
<script src="jquery.datetimepicker.full.js"></script>

<script>
	function validateForm() {

		var a = document.forms["CreateBill"]["Bno"].value;
		if (a == "") {
			alert("Bill No cannot be Empty!!");
			return false;
		}

		var b = document.forms["CreateBill"]["date"].value;
		if (b == "") {
			alert("date cannot be Empty!!");
			return false;
		}

		var c = document.forms["CreateBill"]["HCid"].value;
		if (c == "") {
			alert("Hospital Chargers cannot be Empty!!");
			return false;
		}

		var d = document.forms["CreateBill"]["DCid"].value;
		if (d == "") {
			alert("Doctor Chargers cannot be Empty!!");
			return false;
		}
		var e = document.forms["CreateBill"]["TBid"].value;
		if (e == "") {
			alert("Total Bill cannot be Empty!!");
			return false;
		}

	}
</script>

<style>
h1 {
	text-align: left;
	text-transform: uppercase;
	color: #4CAF50;
}
</style>

<title>Bills</title>
</head>
<body>

	<header class="templatemo-site-header">
	<h1>HOSPITAL MANAGEMENT SYSTEM</h1>
	</header>

	<h2>Create Bills</h2>
	<br>

	<!--add form-->

	<div class="addform">
		<form name="CreateBill" onsubmit="return validateForm()"
			class="form-horizontal" action="./BillServlet" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2">Bill No :</label>
				<div class="col-sm-10">
					<input type="number" name="Bno" class="form-control" id="Bno"
						required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Billing Date
					:</label>
				<div class="col-sm-10">
					<input type="date" name="date" class="form-control" id="date"
						required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2">Hospital
					Chargers :</label>
				<div class="col-sm-10">
					<input type="double" name="HCid" class="form-control" id="HCid"
						required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Doctor
					Chargers :</label>
				<div class="col-sm-10">
					<input type="double" name="DCid" class="form-control" id="DCid"
						required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Other
					Chargers :</label>
				<div class="col-sm-10">
					<input type="double" name="OCid" class="form-control" id="OCid"
					required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Total Bill :</label>
				<div class="col-sm-10">
					<input type="double" name="TBid" class="form-control" id="TBid"
					 required readonly="readonly">
				</div>
			</div>
			
			<div>
				<input type="submit" value="Calculate" onclick="sumValue()">
				<input type="submit" value="Submit">

			</div>


		</form>
		<script type="text/javascript">
			function sumValue() {
				var num1, num2, num3, res;
				num1 = Number(document.CreateBill.HCid.value);
				num2 = Number(document.CreateBill.DCid.value);
				num3 = Number(document.CreateBill.OCid.value);

				res = num1 + num2 + num3;
				document.CreateBill.balance.value = res;
			}
		</script>
	</div>


</body>


</html>