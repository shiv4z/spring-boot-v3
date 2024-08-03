<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Product Details :</h2>
	<font color="green">${msg}</font>
	<hr>
	<form:form action="/save" method="POST" modelAttribute="product" autocomplete="off">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><form:input path="quantity" /></td>
			</tr>
			<tr><td><input type="submit" value="Save"/></td></tr>
			<tr><td><a href="/view">View Products</a></td></tr>
		</table>
          
          
	</form:form>

</body>
</html>