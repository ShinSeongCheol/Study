<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello User Application</title>
</head>
<body>
	<form action="checkboxSubmit.jsp" method="POST">
		Select the fruits you like to eat:<br /> 
		<input type="checkbox"name="fruit" value="Banana" />Banana<br />
		<input type="checkbox"name="fruit" value="Apple" />Apple<br />
		<input type="checkbox"name="fruit" value="Orange" />Orange<br />
		<input type="checkbox"name="fruit" value="Guava" />Guava<br />
		<input type="checkbox"name="fruit" value="Kiwi" />Kiwi<br />
		<input type="submit" value="submit" />
	</form>
</body>
</html>