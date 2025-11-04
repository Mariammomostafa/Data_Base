<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="styleSheet" type="text/css"
	href="/student-management/resources/css/styleSheet.css">
</head>

<body class="myFonts">

	<h1 align="center">Student List</h1><hr>
	
	<a href="/student-management/">Home Page</a>
	
	<div align="center" class="container">

		<table border="1" style="width: 50% , height: 50%">
			<thead>
				<tr>
					<td>Id</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
					<td>operations</td>
				</tr>
			</thead>
			<c:forEach var="item" items="${studs}">

				<tr>
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.mobile}</td>
					<td>${item.country}</td>

					<td><a href="/student-management/update?userId=${item.id}">update</a>
						<a href="/student-management/delete?userId=${item.id}"
						onclick="if(!(confirm('Are you sure that you want to delete this user ?'))) return false">delete</a>
					</td>
				</tr>

				<br>
				<br>
			</c:forEach>

		</table>

	</div>

</body>
</html>