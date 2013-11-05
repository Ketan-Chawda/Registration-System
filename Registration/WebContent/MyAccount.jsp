<%int status=0;try{HttpSession my=request.getSession(false);
if(my!=null)
{String str=my.getAttribute("status").toString(),str1=my.getAttribute("uprior").toString();
if(str.compareToIgnoreCase("true")==0)
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
<h2>
<center>
<table align="left">
<tr><td bgcolor='silver' align='left'><a href="/Registration/ChangePassword.jsp">Change Password</a>
<tr><td bgcolor='silver' align='left'><a href="/Registration/ServletViewPassword">View password</a>
</table></center>

</body>
</html>
<%}else{%>
<h1><center>Sorry Page Exists But You Are Unauthorized User For
This Page Thanks Best Luck Next Time
<br><br><br><a href="/Registration/SignIn.jsp">Login Again</a><br><br><br>
<%}}%>
