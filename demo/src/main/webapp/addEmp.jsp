<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  <script type="text/javascript">
function validateForm(){
	var id=document.forms["myform"]["eid"].value;
	var name=document.forms["myform"]["name"].value;
	var desig=document.forms["myform"]["desig"].value;	
	var deptNo=document.forms["myform"]["deptNo"].value;
	var email=document.forms["myform"]["email"].value;
	var salary=document.forms["myform"]["salary"].value;
	
	var regex="/[A-Za-z]*/";
	var regex1="/[0-9]*/";
	
	if(name.isAlpha()){
		alert("Enter correct name");
	}
	
}
</script>-->
	<h1>Add Employee Page</h1>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<table>
	<form:form name="myform" method="post" action="/addEmp" modelAttribute="emp" onsubmit="return validateForm()">
		<tr>
			<td><form:label path="eid">Enter Employee's ID</form:label></td>
			<td><form:input  path="eid" required="required"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="name">Enter Employee's Name</form:label></td>
			<td><form:input path="name"  required="required"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="desig">Enter Employee's Designation</form:label></td>
			<td><form:input path="desig"  required="required"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="deptNo">Enter Employee's Department No</form:label></td>
			<td><form:input  path="deptNo"  required="required"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="email">Enter Employee's Email</form:label></td>
			<td><form:input  type="email" path="email" required="required"></form:input></td>
		</tr>
		<tr>
			<td><form:label path="salary">Enter Employee's Salary</form:label></td>
			<td><form:input path="salary" required="required"></form:input></td>
		</tr>
		<tr>
			<td><input type=submit value="Add Employee" ></td>
			<td><input type=reset value="Reset"></td>
		</tr>
		</table> 
	</form:form>
	Click <a href="home">Home</a>To Go Back 
	
</body>
</html>