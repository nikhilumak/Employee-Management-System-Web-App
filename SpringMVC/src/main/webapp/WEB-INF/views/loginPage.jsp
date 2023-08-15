<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN FORM</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <div class="container"><br>
        <h1>EMPLOYEE LOGIN FORM</h1><br>
        <h4 style="color:red">${msg}</h4><br>
        <form action="empLogin" method="post">
            <div class="form-group">
                <label>ENTER EMPLOYEE EMAIL ID</label>
                <input type="text" name="empMail" class="form-control" required>
            </div><br>
            <div class="form-group">
                <label>ENTER EMPLOYEE PASSWORD</label>
                <input type="password" name="password" class="form-control" required>
            </div><br>
            <div>
                <input class="btn btn-success" type="submit" value="SUBMIT">
            </div>
        </form><br>
        <a href="home"><button class="btn btn-primary">HOME</button></a>
    </div>
</center>
</body>
</html>