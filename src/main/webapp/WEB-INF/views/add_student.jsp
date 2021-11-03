<%@ page isELIgnored="false"  %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>

<link rel="stylesheet" type="text/css" href="css/report.css">
<script type="text/javascript" src="js/formValidation.js"></script>
<script type="text/javascript">

function displayStates(){
    frm.action="states";
    frm.submit();
}
</script>
<h1 align="center">Add Student</h1>

<form:form name="frm" modelAttribute="stu" align="center" onsubmit="return formValidation(this)">
	<table border="1" align="center" >
		<tr>
			<td>Enter student name :</td>
			<td> <form:input path="name"/> <form:errors path="name" cssStyle="color: red;"/> <span id="name_error" style="color: red"/></td>
		</tr>
		<tr>
			<td>Enter department name :</td>
			<td> <form:input path="dept"/> <form:errors path="dept" cssStyle="color: red;"/> <span id="dept_error" style="color: red"/> </td>
		</tr>
		<tr>
			<td>Date of Birth :</td>
			<td>
				<form:input path="date" type="date" />
			</td>
		</tr>
		<tr>
			<td>Country :</td>
			<td>
				<form:select path="country" onchange="displayStates()">
					<form:options items="${countryInfo}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<td>State :</td>
			<td>
				<form:select path="state">
					<form:options items="${stateInfo}" />
				</form:select>
			</td>
		</tr>
		<tr>
			<form:hidden path="vflag"/>
		</tr>
		<tr>
			<td>Languages :</td>
			<td>
				<form:select path="languages" multiple="true">
					<form:options items="${langInfo}"/>
				</form:select>
			</td>
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
	<input type="submit" formaction="add_student" value="Submit"/>&nbsp;&nbsp;&nbsp;
<%-- 	<sec:csrfInput/> --%>
	<input type="reset" value="Reset" />
	<%-- <input type="hidden" id = "vflag" name="vflag" value="${vflag}" /> --%>
	
</form:form>
<p align="center"><a href="./">Home</a></p>
<jsp:include page="logout.jsp"></jsp:include>

