<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>delete Employee Page</h1>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<table>
	<form:form method="post" action="/deleteEmployee" modelAttribute="emp">
		<tr>
			<td><form:label path="eid">Enter Employee's ID</form:label></td>
			<td><form:input  path="eid"></form:input></td>
		</tr>
		<td><input type=submit value="delete Employee"></td>
			<td><input type=reset value="Reset"></td>
		</tr>
		</table> 
	</form:form>
	Click <a href="home">Home</a>To Go Back 
	
</body>
</html>