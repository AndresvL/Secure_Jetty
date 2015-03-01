<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Secret</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form name="login" action="checkLogin" method="post"
		accept-charset="utf-8">
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%>
		<div><center><span style="color:white"><label for="username">Username</label></span>
		<input class="rounded" type="text" name="username" placeholder="username" required></center>
			</br>
		<center><span style="color:white"><label for="password">Password</label></span>
		<input class="rounded" type="password" name="password" placeholder="password" required></center> 
			</br>
		<input type="submit" value="Log in" style="float: right;"></div>
	</form>
</body>
</html>