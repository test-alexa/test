<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" href="temp.css">

</head>
<body>
    <c:forEach var="error" items="${form.formErrors}">
		<p class="error"> ${error} </p>
    </c:forEach>
    
<!--<%//request.setAttribute("page name", "home"); %>-->

	<jsp:include page="EllensBlog1.jsp"/>
	<p>
		<c:forEach var="a" items="${posts}" varStatus="i"> 
		<td style="dont-size: x-large"/>
		<form action="deletePost.do" method="POST">
		<input type="hidden" name="postId" value="${a.postId }"/>
		<input type="submit" value="X">
		</form>
		${a.postText}
	<p>
		<c:forEach var="comment" items="${comments[i.index] }">
		<form method="POST" action="deleteComment.do">
			    <p>${comment.commentTime}</p>
			<input type="hidden" name="CommentId" value="${comment.commentId }"/>
			<input type="submit" value="X"/>
	 	 </form>
	 	<br> ${comment.commentText}<br/>
	 	</c:forEach></p>	
	</c:forEach></p>	
	
	<form action="addPost.do" method="POST">
	<input type="text" name="content"/>
	<input type="submit" value="Post"/>
	</form>
	
</body>
</html>
