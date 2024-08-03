<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Product List :</h2>
	<table border="3">
		<thead>
			<tr>
				<th>Serial No</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="obj" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${obj.name}</td>
					<td>${obj.price}</td>
					<td>${obj.quantity}</td>

				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>