<html>
<body>
<h2>Secrets!</h2>
	<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%>
<ul>
    <li>Deze <a href="rest/public/">link</a> mag publiek zijn.</li>
    <li>Deze <a href="loginSecret.jsp">link</a> moet met een username/password beveiligd worden. (+3 pt)</li>
    <li>Deze <a href="loginVerySecret.jsp">link</a> moet via een externe identity provider beveiligd worden. (+3 pt)</li>
    <li>Deze <a href="loginTopsecret.jsp">link</a> moet met two-factor authenticatie beveiligd worden. (+3 pt)</li>
</ul>
</body>
</html>
