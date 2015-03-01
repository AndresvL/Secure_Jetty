<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<form name="checkemail" action="checkemail" method="post" accept-charset="utf-8">
		 <label for="secretkey">Key</label>
		 <input type="text" name="key" placeholder="Secret key" required>
		 <input type="hidden" name="key" value=<%=request.getParameter("key")%>>
		 <input type="submit" value="Submit key">
	</form>
</body>