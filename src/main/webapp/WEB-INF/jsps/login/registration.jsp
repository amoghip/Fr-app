<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration page</title>
</head>
<body>
<h2>create new registration</h2>
<form action="saveReg" method="post">
<pre>

	firstName<input type="text" name="firstName" >
	lastName<input type="text" name="lastName" >
	email<input type="text" name="email" >
	password<input type="password" name="password" >
 	<input type="submit" value="save" >

</pre>
</form>
</body>
</html>