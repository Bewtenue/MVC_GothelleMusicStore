<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form:form action="loginURL" method="post" commandName="loginForm" >
		<table>
			<tr>
				<td>User Name:</td>
				<td><form:input path="usernameUser"></form:input></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input type="password" path="passwordUser"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>