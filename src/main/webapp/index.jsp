<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html lang="ru">
<head>
	<meta charset="UTF-8">
	<title>Калькулятор - объём конуса</title>
</head>
<body>
	<h1>Калькулятор = объем конуса</h1>
	<h2><em>Разработано DreamTeam</em></h2>
	<form action="${pageContext.request.contextPath}/JavaCalc" method="post">
		<label for="radius">Радиус: </label>
		<br>
		<input type="text" naame="radius" id="radius" value="${radius}">
		<br>
		<label for="height">Высота: </label>
		<br>
		<input type="text" naame="height" id="height" value="${height}">
		<br>
		<input type="submit" naame="sign" value="Calculate">
	</form>
</body>
</html>
