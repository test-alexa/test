<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Visitor</title>
<link rel="stylesheet" href="temp.css">
</head>
<body>
<jsp:include page="EllensBlog1.jsp"/>
	<div class = "main">
	<h2>visitor page</h2>
<%
	String pageName = request.getParameter("name");
	if ("Hilary Clinton".equals(pageName)) {
%>	

 	<table>
			<tr><td colspan="2">I'm running for President 2016.<hr/></td></tr>
			<tr><td colspan="2"><hr/></td></tr>
			<tr>
				<td><input type="submit" value="X"/>I'm running for President 2016.</td>
				<td>---By Hilary Clinton, Sep,12 2015</td>
			</tr>
 			<tr>
				<td>I'm with her.</td>
				<td>---By Bernie Sanders, Sep,12 2016</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>What was wrong?</td>
				<td>---By Hilary Clinton, Nov,12 2016</td>
			</tr>
			<tr>
				<td>Lock her up!</td>
				<td>---By Donald Trump, May,10 2016</td>
			</tr>
			<tr>
				<td>She's with Wall Street.</td>
				<td>---By Bernie Sanders, Dec,10 2015</td>
			</tr>
 			<tr>
				<td>Benghazi, Benghazi, Benghazi.</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>


<%		
	} else if ("Bernie Sanders".equals(pageName)){
		
		%>		
 	<table>
			<tr><td colspan="2">Everyone should have free college.<hr/></td></tr>
			<tr><td colspan="2"><hr/></td></tr>
			<tr>
				<td>Not possible.</td>
				<td>---By Hilary Clinton, Sep,12 2015</td>
			</tr>
 			<tr>
				<td><input type="submit" value="X"/>Feel the Bern.</td>
				<td>---By Bernie Sanders, Sep,12 2016</td>
			</tr>
			
			<tr>
				<td>Lock her up!</td>
				<td>---By Donald Trump, May,10 2016</td>
			</tr>

 			<tr>
				<td>Socialism!</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>
		

<% 

	} else if ("Donald Trump".equals(pageName)){
	
%>		
 	<table>
			<tr><td colspan="2">Build the Wall.<hr/></td></tr>
			<tr><td colspan="2"><hr/></td></tr>
			<tr>
				<td>LMAO.</td>
				<td>---By Hilary Clinton, Sep,12 2015</td>
			</tr>
 			<tr>
				<td>LMAO.</td>
				<td>---By Bernie Sanders, Sep,12 2016</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>Covfefe.</td>
				<td>---By Donald Trump, May,10 2016</td>
			</tr>

 			<tr>
				<td>My dad is not Mexican.</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>
		

<% 
	} else if ("Ted Cruz".equals(pageName)){
%>
<table>
			<tr><td colspan="2">Love your gun.<hr/></td></tr>
			<tr><td colspan="2"><hr/></td></tr>
			<tr>
				<td>Background checks!</td>
				<td>---By Hilary Clinton, Sep,12 2015</td>
			</tr>
 			<tr>
				<td>Ban the gun.</td>
				<td>---By Bernie Sanders, Sep,12 2016</td>
			</tr>
			<tr>
				<td>I don't have small hands.</td>
				<td>---By Donald Trump, May,10 2016</td>
			</tr>
 			<tr>
				<td><input type="submit" value="X"/>That's right.</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>
		
<%
	}
%>

</div>
</body>
</html>