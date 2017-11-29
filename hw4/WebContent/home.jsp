<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link rel="stylesheet" href="temp.css">
</head>
<body>

<%request.setAttribute("page name", "home"); %>

	<jsp:include page="EllensBlog1.jsp"/>
	<h2>Hilary Clinton's Home Page</h2>
 	<table>
			<tr><td colspan="2"><input type="submit" value="X"/>I'm running for President 2016.<hr/></td></tr>
			<tr><td colspan="2">---By Hilary Clinton, Sep,12 2015<hr/></td></tr>

 			<tr>
				<td><input type="submit" value="X"/>I'm with her.</td>
				<td>---By Bernie Sanders, Sep,12 2016</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>What was wrong?</td>
				<td>---By Hilary Clinton, Nov,12 2016</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>Lock her up!</td>
				<td>---By Donald Trump, May,10 2016</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>She's with Wall Street.</td>
				<td>---By Bernie Sanders, Dec,10 2015</td>
			</tr>
 			<tr>
				<td><input type="submit" value="X"/>Benghazi, Benghazi, Benghazi.</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>
 	<div class="a"></div>
 	<table>
			<tr><td colspan="2">I will not give up.<hr/></td></tr>
			<tr><td colspan="2">---By Hilary Clinton, Sep,12 2017<hr/></td></tr>

 			<tr>
				<td><input type="submit" value="X"/>I'm with her.</td>
				<td>---By Bernie Sanders, Sep,12 2017</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>What's next?</td>
				<td>---By Hilary Clinton, Nov,12 2017</td>
			</tr>
			<tr>
				<td><input type="submit" value="X"/>I won!</td>
				<td>---By Donald Trump, Nov,10 2016</td>
			</tr>

 			<tr>
				<td><input type="submit" value="X"/>Benghazi, Benghazi, Benghazi.</td>
				<td>---By Ted Cruz, Dec,9 2015</td>
			</tr>
 	</table>
</body>
</html>