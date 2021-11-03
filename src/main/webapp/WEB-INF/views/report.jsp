<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" type="text/css" href="css/report.css">

<script type="text/javascript">
    window.onload = fadeout;

    function fadeout() {
	var fade = document.getElementById("result");

	var intervalID = setInterval(function() {

	    if (!fade.style.opacity) {
		fade.style.opacity = 1;
	    }

	    if (fade.style.opacity > 0) {
		fade.style.opacity -= 0.1;
	    }

	    else {
		clearInterval(intervalID);
	    }

	}, 200);
    }
</script>
<h1 align="center">Welcome to Student Portal</h1>
<br />

<c:choose>
	<c:when test="${!empty stdList}">
		<table border="1" align="center">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Dept</th>
				<th>Country</th>
				<th>DOB</th>
				<th>Language</th>
				<th>Gender</th>
				<th>Opeations</th>
			</tr>
			<c:forEach items="${stdList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.dept}</td>
					<td>${item.country}</td>
					<td>${item.date}</td>
					<td><c:forEach items="${item.languages}" var="lang">
			 		${lang}
			 		</c:forEach></td>
					<td>${item.gender}</td>
					<td><a href="./edit_student?stdId=${item.id}">Edit</a>&nbsp; <a
						href="./delete_student?stdId=${item.id}"
						onclick="confirm('Do you want to delete')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h2 align="center" style="color: red;">No Student Records Found</h2>
	</c:otherwise>
</c:choose>

<h2 align="center" style="color: green;" id="result">${result}</h2>

<a href="add_student"><p align="center">Add Student</p></a>
<jsp:include page="logout.jsp"></jsp:include>