<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="temp.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="EllensBlog1.jsp"/>

<div class="main">
	<form action="Register" method="POST">
  Email: <input type="text" name="emailAddress"><br>
  First name: <input type="text" name="firstName"><br>
  Last name: <input type="text" name="lastName"><br>  
  Password: <input type="password" name="password"><br>
  	<input type="submit" value="Register">
</div>

</body>
</html>