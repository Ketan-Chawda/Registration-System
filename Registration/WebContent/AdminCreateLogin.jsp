<%int status=0;try{HttpSession my=request.getSession(false);
if(my!=null)
{String str=my.getAttribute("status").toString(),str1=my.getAttribute("uprior").toString();
if(str.compareToIgnoreCase("true")==0 && str1.compareToIgnoreCase("1")==0)
status=12;}}
catch(Exception e)
{System.out.println(e+"session is expired ok");}
finally{%>
<%if(status==12){%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="AdminHeader.jsp" %>
<table align="right"><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table><form action="/Registration/ServletAdminCreateLogin" method="post">
<br><br><br><br><br><br>

<center>
<table border=2 height="45%" bordercolor="blue" bgcolor="pink">
<tr><td>User Name:
<td><input type="text" name="userid">

<tr><td>
<tr><td>Default Password:<td><input type="text" name="password">

<tr><td>
<tr><td>Designation:<td><input type="text" name="desg">

<tr><td>
<tr><td>Default Priority:<td><select name="prior">
<option>1
</option>
<option>2
</option>

<tr><td><input type="reset" value="Reset" ><td><input type="submit" value="Create Login " >
</table>
</form>

</body>
</html>
<%}else{%>
<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>
<br><br><br>
<h1><center>Sorry Page Exists But It Is For Admin Only
<br><br><br><a href="/Registration/SignIn.jsp">Login Again</a><br><br><br>
<%}}%>
