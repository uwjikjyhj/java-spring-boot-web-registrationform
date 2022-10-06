<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<f:form method="post" modelAttribute="student">
		Enter Name: <f:input path="name" /><br />
		Enter Age: <f:input path="age" /><br />
		Enter Mobile Number: <f:input path="mobileNo" /><br />
		Enter Address: <f:input path="address" /><br />
		<input type="submit" value="Submit" />
		<input type="reset" value="Reset" />		
	</f:form>
</body>
</html>