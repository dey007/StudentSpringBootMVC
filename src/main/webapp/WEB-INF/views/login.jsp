<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<h1 align="center">Login Page</h1>
<p align="center" style="color: red">
	If you are not a user, <a href="register">click here</a> to register
</p>
<c:url value="/login" var="loginUrl" />
<form action="${loginUrl }" method="post">
	<table border="1" align="center">
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<%-- <sec:csrfInput /> --%>
	</table>
	<p align="center">
		<input type="submit" value="login" /><br>
	<div align="center">${resultMsg}</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<div style="text-align:center;color: red">
		<c:if test="${param.error != null }">
			Invalid Username/Password
		</c:if>
	</div>
</html>