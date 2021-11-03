<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link rel="stylesheet" type="text/css" href="css/report.css">
<h1 align="center">Edit Student Details</h1>

<form:form modelAttribute="stu" align="center">
<table border="1" align="center">
	<tr>
		<td>Student Id: </td>
		<td><form:input path="id" readonly="true"/></td>
	</tr>
	<tr>
		<td>Student Name: </td>
		<td><form:input path="name" /> <form:errors path="name" cssStyle="color: red;" /></td>
	</tr>
	<tr>
		<td>Department: </td>
		<td><form:input path="dept" /> <form:errors path="dept" cssStyle="color: red;" /></td>
	</tr>
	<tr>
			<td>Gender :</td>
			<td>
				<form:radiobutton path="gender" value="Male"/> Male
				<form:radiobutton path="gender" value="Female"/> Female
			</td>
		</tr>
</table>
<br/>
<input type="submit" value="Submit"/>&nbsp;&nbsp;&nbsp;
<input type="reset" value="Reset" />
</form:form>

<p align="center">
<a href="./">Home</a></p>
<jsp:include page="logout.jsp"></jsp:include>
