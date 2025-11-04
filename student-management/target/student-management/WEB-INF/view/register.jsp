<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <link rel="styleSheet" type="text/css" href="/student-management/resources/css/styleSheet.css">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to Regoster form</h1>

<form:form  action="process-registeration" method="post" modelAttribute="dto">
  
  <form:hidden path="id"/>
  
 Name :  <form:input  path="name"/><br><br>
 Mobile :  <form:input    path="mobile" /><br><br>
 Country :  <form:input    path="country" /><br><br>
 
 <input type="submit" value="Sign Up"/> 

</form:form>

</body>
</html>