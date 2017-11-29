<%@page import="hw4.databean.*" %>
<%@page import="hw4.dao.UserDAO" %>
<%@page import="hw4.formbean.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="hw4.databean.User" %>


	<div class="title">Ellen's Blog</div>
	<div class="navbar">
	<%
	User user = (User) session.getAttribute("user");
	
	if(user != null){
		String emailAddress = user.getEmail();
		
%>		
		<form action="Home" method="GET">
			<input type="submit" name="user-page" value="<%=emailAddress %>" />
		</form>
		<form action="Logout" method="POST">
			<input type="submit" name="button" value="Logout" />
		</form>
		
<%	
	} else {
%>	

		<form action="Login" method="GET">
			<input type="submit" name="button" value="Login" />
		</form>
		<form action="Register" method="GET">
			<input type="submit" name="button" value="Register" />
		</form>

<% 	
	}
%>
<br><br>
<% 
	User[] users = (User[]) request.getAttribute("users");
	if(users != null) {
		
		for (int i = 0; i < users.length; i++) {

			String email = users[i].getEmail();
			String firstName = users[i].getFirstName();
			String lastName = users[i].getLastName();
%>
<div><a href ="Visitor?email=<%=email%> style="font-size:20px"><%= (firstName + " " + lastName) %></a></div>	
<%	
		}
		
	} else { 
%>
<!-- <div>Error loading name list</div>	 -->
<%	} %>


<br />
<div><a href="visitor.jsp?name=Hilary%20Clinton" style="font-size:20px">Hilary Clinton</a></div>
<div><a href="visitor.jsp?name=Bernie%20Sanders" style="font-size:20px">Bernie Sanders</a></div>
<div><a href="visitor.jsp?name=Ted%20Cruz" style="font-size:20px">Ted Cruz</a></div>
<div><a href="visitor.jsp?name=Donald%20Trump" style="font-size:20px">Donald Trump</a></div>
</div>
