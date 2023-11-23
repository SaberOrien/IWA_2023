<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>Solve Equation</title>
</head>
<body>
<h1>${message}</h1>
<h2>Equation</h2>
<form:form method="post" action="solveEquation.html" modelAttribute="equation">
    <form:label path="firstCoefficient">First Coefficient:</form:label>
    <form:input path="firstCoefficient" />
    <br>
    <form:label path="secondCoefficient">Second Coefficient</form:label>
    <form:input path="secondCoefficient" />
    <br>
    <form:label path="thirdCoefficient">Third Coefficient</form:label>
    <form:input path="thirdCoefficient" />
    <br>
    <input type="submit" value="Solve Equation"/>
</form:form>
</body>
</html>