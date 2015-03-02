<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="style.css">

</head>
<body background ="http://fc05.deviantart.net/fs10/i/2006/106/6/a/blue_matrix_by_bboisupafly.jpg">
	<span style="color: white"><h2>Secrets!</h2> 		
	<center>
		<label style="color: white"> <%
 	Object msgs = request.getAttribute("msgs");
 	if (msgs != null) {
 		out.println(msgs);
 		out.println();
 	}
 %>
		</label>
		</center></span>
	<ul>
		<li><span style="color: white">Deze <a href="/Secure_Jetty/rest/public/">link</a>
				mag publiek zijn.<span></span></li>
		<li><span style="color: white">Deze <a
				href="/Secure_Jetty//loginSecret.jsp">link</a> moet met een username/password
				beveiligd worden. (+3 pt)
		</span></li>
		<li><span style="color: white">Deze <a
				href="/Secure_Jetty//loginVerySecret.jsp">link</a> moet via een externe identity
				provider beveiligd worden. (+3 pt)
		</span></li>
		<li><span style="color: white">Deze <a
				href="/Secure_Jetty/loginTopsecret.jsp">link</a> moet met two-factor authenticatie
				beveiligd worden. (+3 pt)
		</span></li>
	</ul>
</body>
</html>
