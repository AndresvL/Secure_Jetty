<%@page import="nl.hu.v2iac1.auth.GoogleAuthHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>VerySecret</title>
</head>
<body>
	<div class="center">
		<%
			final GoogleAuthHelper helper = new GoogleAuthHelper();
			if (request.getParameter("code") == null || request.getParameter("state") == null) {
				out.println("<a href=\"" + helper.buildLoginUrl() + "\"><img src=\"https://developers.google.com/+/images/branding/sign-in-buttons/White-signin_Medium_base_44dp.png\"></a>");		
				session.setAttribute("state", helper.getStateToken());
			}
		%>
	</div>
	<br />
</body>
</html>