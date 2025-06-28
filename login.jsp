<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style >
body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #f0f2f5;
        height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    form {
        background: white;
        padding: 30px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        width: 300px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }

</style>
<title>Login Page</title>
</head>
<body>
<form action="LoginForm" method="post">
 <label>Email    :</label>
 <input type="email" name="email1" placeholder="Enter email"/>
 <br><br>
 <label>Password :</label>
 <input type="password" name="pass1" placeholder="Enter password"/>
 <br><br>
 <input type="submit" value="Login"/>
</form>
</body>
</html>