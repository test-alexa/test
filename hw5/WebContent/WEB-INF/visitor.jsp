<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visitor</title>
<link rel="stylesheet" href="temp.css">

</head>
<body>
<jsp:include page="EllensBlog1.jsp"/>
	
	<h2>visitor page</h2>
<%-- <h1><c:set var="item" value="${sessionScope.user.name}">${item}'s Home page</c:set></h1>  --%>

<p>

<c:forEach var="a" items="${posts}" varStatus="i">
  <td style="font-size: x-large">
  ${a.postText} 
  
	<c:forEach var="comment" items="${comments[i.index]}" >
	
	<c:if test="${sessionScope.user.emailAddress == comment.emailAddress}">
	<form action="deleteComment.do" method="POST">
	<input type="hidden" name="CommentId" value="${comment.commentId }" />  
	<input type="submit" value="X"/>
	</form>
	</c:if> 
	${comment.commentText}<br/>
	</c:forEach>
  	
  	<form action="addComment.do" method="POST">
  	<input type="text" name="content" />
  	<input type="hidden" name="postId" value="${a.postId }"/>
  	<input type="hidden" name="email" value="${a.emailAddress }"/>
<!--  <input type="hideen" name="emailAddress" value="${comment.emailAddress }" /> -->  	
  	<input type="submit" value="Comment"/>
  	</form>

</c:forEach>

</p>

</body>
</html>