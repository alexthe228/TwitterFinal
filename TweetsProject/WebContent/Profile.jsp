<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Tweets</title>
</head>
<body bgcolor="#333333">

<h1 style="font-family:arial;color:white;font-size:48px;">Twitter clone: </h1>
<hr style = "color:white;font-size:48px;">
<br>
<center>

<p style="font-family:arial;color:white;">Username : <%=request.getAttribute("User") %></p>
<p style="font-family:arial;color:white;">Email : <%=request.getAttribute("Email") %></p>
<br>
<p style="font-family:arial;color:white;">Change details</p>

<br>
<form action="Profile" method=post>
<p style="color:white">password : <input name="password" rcols="50" maxlength="120"></input> </p>
<p style="color:white">email : <input name="email" rcols="50" maxlength="120"></input> </p>
<br>
<input type="submit" value="Submit">
</form>

</center>
</body>
</html>