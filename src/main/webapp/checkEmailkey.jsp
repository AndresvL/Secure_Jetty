<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>EmailKey</title>
</head>
<body>
	<form name="CheckEmail" action="checkEmail" method="post"
		accept-charset="utf-8">
		<center>
			<label style="color: white"> <%
 	Object msgs = request.getAttribute("msgs");
 	if (msgs != null) {
 		out.println(msgs);
 		out.println();
 	}
 %>
			</label></center> <center><label for="secretkey">Key</label> <input class="rounded"
				type="text" name="key" placeholder="Secret key" required> <input
				type="submit" value="Submit key">
		</center>
	</form>
</body>