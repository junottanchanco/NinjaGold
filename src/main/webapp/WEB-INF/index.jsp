<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body style="font-family: arial;">
	<h1>Ninja Gold</h1>
	<p>Your Gold: <%= session.getAttribute("gold") %></p><br>
	<form action="/" method="post">
		<fieldset style="width: 200px;">
			<legend><b>Farm</b></legend>
			<p>Earns 10-20 Gold Coins</p>
			<input type="hidden" name="location" value="farm">
			<input type="submit" value="Find Gold">
		</fieldset>
	</form>
	<form action="/" method="post">
		<fieldset style="width: 200px;">
			<legend><b>Cave</b></legend>
			<p>Earns 5-10 Gold Coins</p>
			<input type="hidden" name="location" value="cave">
			<input type="submit" value="Find Gold">
		</fieldset>
	</form>
	<form action="/" method="post">
		<fieldset style="width: 200px;">
			<legend><b>House</b></legend>
			<p>Earns 2-5 Gold Coins</p>
			<input type="hidden" name="location" value="house">
			<input type="submit" value="Find Gold">
		</fieldset>
	</form>
	<form action="/" method="post">
		<fieldset style="width: 200px;">
			<legend><b>Casino</b></legend>
			<p>Earns/Takes 0-50 Gold Coins</p>
			<input type="hidden" name="location" value="casino">
			<input type="submit" value="Find Gold">
		</fieldset>
	</form><br>
	<h1>Activities:</h1>
	<fieldset style="width: 700px; height: 150px; border: solid;">
		<c:out value="${activities}"/>
	</fieldset>
</body>
</html>