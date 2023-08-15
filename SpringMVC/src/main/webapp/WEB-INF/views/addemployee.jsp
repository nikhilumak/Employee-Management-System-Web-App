<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD EMPLOYEE</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style>
th, td {
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 30px;
	padding-right: 40px;
}
</style>
</head>
<body>
	<center>
			<h1>ADD NEW EMPLOYEE DETAILS</h1>
			<br>
			<h4 style="color: red">${msg}</h4>
			<br>
			<form action="insertData" method="post">
				<table>
					<tr>
						<td><label>EMPLOYEE NAME</label></td>
						<td><input type="text" name="empName"
							value="${e.getEmpName()}" placeholder="Ex. Joe Root" required></td>
					</tr>
					<tr>
						<td><label>EMPLOYEE MAIL ID</label></td>
						<td><input type="text" name="empMail"
							value="${e.getEmpMail()}" placeholder="Ex. joeroot@gmail.com" required></td>
					</tr>
					<tr>
						<td><label>EMPLOYEE PASSWORD</label></td>
						<td><input type="password" name="password" placeholder="Ex. BlueBird@21" required></td>

					</tr>
					<tr>
						<td><label>EMPLOYEE CONTACT NO.</label></td>
						<td><input type="text" name="empContact"
							value="${e.getEmpContact()}" placeholder="Ex. 9087654321" required></td>
					</tr>
					<tr>
						<td><label>EMPLOYEE SALARY</label></td>
						<td><input type="text" name="empSal" placeholder="Ex. 100000" value="${e.getEmpSal()}"
							required></td>
					</tr>
					<tr>
						<td><label>EMPLOYEE GENDER</label></td>
						<td><input type="radio" name="empGender" value="male"${e.getEmpGender()=='male'?'checked':''} required>Male 
							<input type="radio" name="empGender" value="female"${e.getEmpGender()=='female'?'checked':''} required>Female
						</td>
					</tr>
				</table>
				<br> <input class="btn btn-success" type="submit" value="SUBMIT">
			</form>
			<br>
			<div>
				<a href="home"><button class="btn btn-primary">HOME</button></a>
			</div>
	</center>
</body>
</html>