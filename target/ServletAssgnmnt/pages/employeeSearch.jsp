<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Search for an employee with Employee number :</h2><br>
<form action="/ServletAssgnmnt/employeeOperations.do?action=search" method="get">
		Employee Number: &nbsp; <input type="text" name="empId"> <br><br>
		<input type="submit" value="Submit">
	</form>
	<br>
	<br>
	<table class = "table">
	<tr>
	<th>Employee number</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Gender</th>
	<th>DOB</th>
	<th>DOJ</th>
	</tr>
	<tr>
	
        <td>${requestScope.employee.number}</td>
		<td>${requestScope.employee.fname}</td>
		<td>${requestScope.employee.lname}</td>
		<td>${requestScope.employee.gender}</td>
		<td>${requestScope.employee.dob}</td>
		<td>${requestScope.employee.doj}</td>
		</tr>
		<tr><form action="/ServletAssgnmnt/employeeOperations.do?action=delete" method="get"><input type="submit" value="Submit"></form></tr>
	</table>
</body>
</html>