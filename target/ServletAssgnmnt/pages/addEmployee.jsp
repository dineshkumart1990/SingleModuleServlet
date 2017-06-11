<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<form action="/ServletAssgnmnt/addEmployee.do" method="post">
		<h3>Enter Employee Information</h3>
		<table class = "table">
		<tr>
		<td>Employee Number : </td>
		<td> <input type="text" name="empId"> </td>
		</tr>
		<tr>
		<td>Employee First Name: </td> 
		<td><input type="text" name="fName"> </td>
		</tr>
		<tr>
	    <td>Employee Last Name: </td>
	    <td> <input type="text" name="lName"> </td>
		</tr>
		<tr>
		<td>Gender [M/F] : </td>
		<td> <input type="text" name="gender"> </td>
		</tr>
		<tr>
		<td>Employee Date of Birth [dd-MM-yyyy] : </td>
		<td> <input type="text" name="dob"> </td>
		</tr>
		<tr>
		<td>Employee Hire Date [dd-MM-yyyy] : </td>
		<td> <input type="text" name="doj"> </td>
		</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
	<br><br><br>
	${requestScope.message}
</body>
</html>