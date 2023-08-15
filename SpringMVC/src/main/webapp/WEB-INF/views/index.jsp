<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
		h1 {
			font-size: 48px;
			text-align: center;
			margin-top: 50px;
		}
		button {
			padding: 10px 20px;
			font-size: 18px;
			background-color: #4CAF50;
			color: white;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			margin: 20px;
		}
		button:hover {
			background-color: #3e8e41;
		}
	</style>
</head>
<body>
<h1>Rabbit and Tortoise Technology Solutions</h1>
<h1>Employee Management System</h1>
 <h4 style="color:green">${msg}</h4><br>
<div style="text-align: center">
   <a href="addemployee"><button>Add Employee</button></a>
   <a href="viewall"><button>Show All Employees</button></a>
   <a href="loginPage"><button>Show Employee</button></a>
</div>
</body>
</html>