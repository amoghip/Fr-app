<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h2>login here</h2>
${error}
<form action="verifyLogin" method="post">
emailID<input type="text" name="emailId">
password<input type="password" name="password">
 <input type="submit" name="login">

</form>
</body>
</html>