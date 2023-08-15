
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>
	<center>
		<h1>EMPLOYEE DETAILS</h1>
		<h4 style="color: red">${msg}</h4>
		<br>
		<table>
			<tr>
				<th>EMPLOYEE ID</th>
				<th>NAME</th>
				<th>EMAIL ID</th>
				<th>CONTACT NO</th>
				<th>SALARY</th>
				<th>GENDER</th>
				<th>ACTION</th>
			</tr>
			<c:forEach var="e" items="${employeeRecord}">
				<tr>
					<td>${e.getEmpId()}</td>
					<td>${e.getEmpName()}</td>
					<td>${e.empMail}</td>
					<td>${e.getEmpContact()}</td>
					<td>${e.getEmpSal()}</td>
					<td>${e.getEmpGender()}</td>
					<td><a href="update?id=${e.getEmpId()}"><button class="btn btn-info">UPDATE</button></a> 
						<a href="delete?id=${e.getEmpId()}"><button class="btn btn-danger">DELETE</button></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="home"><button class="btn btn-primary">HOME</button></a>
	</center>
</body>
</html>