<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE EMPLOYEE</title>
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
		<div class="container">
			<br>
			<h1>UPDATE EMPLOYEE DETAILS</h1>
			<br>
			<form action="updatenext" method="post">
				<h4 style="color: red">${msg}</h4>
				<br>
				<c:forEach var="employeeList" items="${employeeList}">
					<c:set var="e" value="${employeeList}"></c:set>
					<table>
						<tr>
							<td><label>EMPLOYEE ID</label></td>
							<td><input type="text" name="empId" value="${e.getEmpId()}" disabled></td>
						</tr>
						<tr>
							<td><label>EMPLOYEE MAIL ID</label></td>
							<td><input type="text" name="empMail"
								value="${e.getEmpMail()}" required></td>
						</tr>
						<tr>
							<td><label>EMPLOYEE NAME</label></td>
							<td><input type="text" name="empName"
								value="${e.getEmpName()}" required></td>
						</tr>
						<tr>
							<td><label>EMPLOYEE PASSWORD</label></td>
							<td><input type="password" name="password" required></td>

						</tr>
						<tr>
							<td><label>EMPLOYEE CONTACT NO.</label></td>
							<td><input type="text" name="empContact"
								value="${e.getEmpContact()}" required></td>
						</tr>
						<tr>
							<td><label>EMPLOYEE SALARY</label></td>
							<td><input type="text" name="empSal"
								value="${e.getEmpSal()}" required></td>
						</tr>
						<tr>
							<td><label>EMPLOYEE GENDER</label></td>
							<td><input type="radio" name="empGender" value="male" ${e.getEmpGender()=='male'?'checked':''} required>Male 
							<input type="radio" name="empGender" value="female" ${e.getEmpGender()=='female'?'checked':''} required>Female
							</td>
						</tr>
					</table>
					<br>
				</c:forEach>
				<input class="btn btn-success" type="submit" value="UPDATE">
			</form>
			<br>
			<div>
				<a href="home"><button class="btn btn-primary">HOME</button></a>
			</div>
	</center>
</body>
</html>

<!-- 
 -->