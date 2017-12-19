<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


	<div class="title">Ellen's Blog</div>
	<div class="navbar">
	<c:choose>
	<c:when test="${!(empty user)}">
	<li><a href="homepage.do">Home</a></li>
	<li><a href="logout.do">Logout</a></li>
	</c:when>
	<c:otherwise>
	<li><a href="login.do">Login</a></li>
	<li><a href="register.do">Register</a></li>
	</c:otherwise>
	
	</c:choose>
	<br>
	<c:forEach var="users" items="${users}">
	<div><a href ="visitorpage.do?email=${users.emailAddress}">${users.firstName} ${users.lastName}</a></div>
	</c:forEach>
	
	
	<div class="container-fluid">
	
	</div>
		
<!-- 	<form action="homepage.do" method="GET">
			<input type="submit" name="user-page" value="" />
		</form>
		<form action="logout.do" method="GET">
			<input type="submit" name="button" value="Logout" />
		</form>
		
 -->	
<br />

</div>
