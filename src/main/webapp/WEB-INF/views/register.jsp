<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 align="center"><u>Form Registration</u></h1>
<form:form modelAttribute="reg" onsubmit="registration()">
<table border="1" align="center">
	<tr>
		<td>UserName:</td>
		<td><form:input path="username"/></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><form:input path="password" type="password"/></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><form:input path="email"/></td>
	</tr>
	<tr>
		<td>Role:</td>
		<td>
			<input type="checkbox" name="role" value="admin">ADMIN
			<input type="checkbox" name="role" value="teacher">TEACHER
		</td>
	</tr>
</table>
<p align="center">
<input type="submit" value="register" />
</p>
<p align="center"><a href="login">Click Here</a> to login</p>

</form:form>