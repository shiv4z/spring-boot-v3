<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="save" method="POST" modelAttribute="student">
		<div style="color : green">${msg}</div>
		<table>
			<form:label path="name">Name :</form:label>
			<form:input path="name" />
			<br />
			<form:label path="email">Eamil :</form:label>
			<form:input path="email" />
			<br />
			<form:label path="gender">Gender :</form:label>
			<form:radiobutton path="gender" value="M" label="Male" />
			<form:radiobutton path="gender" value="F" label="Fe-male" />
			<br />
			<form:label path="course">Courses :</form:label>
			<form:select path="course">
				<form:option value="">Select</form:option>
				<form:options items="${courses}"/>
			</form:select>
			<br />
			<form:label path="timings">Timing :</form:label>
			<form:checkboxes items="${timings}" path="timings"/>

		</table>
		<input type="submit" value="Save">
	</form:form>

</body>
</html>