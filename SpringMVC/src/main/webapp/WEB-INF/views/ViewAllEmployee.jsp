 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" !="anonymous"></script>
	<link href="<c:url value="/resources/style.css" />" rel="stylesheet" >
</head>
<body>
<center><br>
<h1>EMPLOYEE MANAGEMENT SYSTEM</h1><br>
<h4>ALL EMPLOYEES DETAILS</h4>
<h4 style="color:red">${msg}</h4><br>
<a href="addemployee"><button class="btn btn-secondary">Add Employee</button></a><br>
                                                                                                                                                                                                                                                                 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
<table>
<tr><th>EMPLOYEE ID</th><th>NAME</th><th>EMAIL ID</th><th>CONTACT NO</th><th>SALARY</th><th>GENDER</th><th>ACTION</th></tr>
<c:forEach var="e" items="${employeeRecord}">
<tr>
	<td>${e.getEmpId()}</td>
	<td>${e.getEmpName()}</td>
	<td>${e.getEmpMail()}</td>
	<td>${e.getEmpContact()}</td>
	<td>${e.getEmpSal()}</td>
	<td>${e.getEmpGender()}</td>
	<td>	
			<a href="update?id=${e.getEmpId()}"><button class="btn btn-info">UPDATE</button></a>
			<a href="delete?id=${e.getEmpId()}"><button class="btn btn-danger">DELETE</button></a>
	</td>
</tr>
</c:forEach>
</table><br>
<!-- 
<form action="search" method="post">
<input type="text" name="empName"><button class="btn btn-secondary">Search By Name</button> -->
<form action="search" method="post">
  <!-- <select name="empName">
    <c:forEach items="${employeeRecord}" var="e">
      	<option value="${e.empName}">${e.empName}</option>
    </c:forEach>
  </select> -->
  
  <input type="text" name="empName" >
  <input type="submit" value="Submit"/>
</form>

</center>
</body>
</html>

<!-- <td><a href="update?id=${e.getId()}">update</a></td>
	<td><a href="delete?id=${e.getId()}">delete</a></td>   -->	