<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="book">
			<label>Book Id:</label>
			<input type="text" name="bookId" />
			<input type="submit" value="Search" />
	</form>
	<hr />

	<h3>Book Details::</h3>
	Book Id: ${book.bookId}
	<br /> Book Name: ${book.bookName}
	<br /> Book Double: ${book.bookPrice}
	<br />

</body>
</html>