<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
	<p>Registered Successfully!!!</p>
	<p>Your details are</p>
	<p>Name: <%= request.getParameter("name") %></p>
	<p>Name: <%= request.getParameter("age") %></p>
	<p>Name: <%= request.getParameter("mobile") %></p>
	<p>Name: <%= request.getParameter("addr") %></p>
</body>
</html>