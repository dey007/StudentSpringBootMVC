<%-- <form method="post" action="logout" align="center">
	<button type="submit" name="submit_param" value="submit_value" class="link-button">logout</button>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form> --%>
<link rel="stylesheet" type="text/css" href="css/report.css">
<p style="text-align: center;">
<a onclick="document.forms['logoutForm'].submit()"
	class="myClickableThingy"><u>Logout</u></a>

<form id="logoutForm" method="POST" action="logout">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>