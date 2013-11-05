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
<table align="right"><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>
<table align='left' border=0 bgcolor='pink'>
<tr><td>
<table align='left' border=0 bgcolor='pink' width='40%' height=80%>
<tr><td>
<table align='left' border=0 bgcolor='pink'>
<tr><td align='left'>Generally There Are Two Entities,One Is Admin With Priority As 1st
<tr><td align='left'>Additional Rights For Admin Or 1st Priority Person Are:
<tr><td align='left'>1)Create New User Login
<tr><td align='left'>2)Delete User Login
<tr><td align='left'>3)Lock User Login
<tr><td align='left'>4)UnLock User Login
<tr><td align='left'>5)View User Login
<tr><td align='left'>6)Delete Entry Made By Another User
</table>
</table>

<table align='left' border=0 bgcolor='pink' width='40%'>
<tr><td>
<table align='left' border=0 bgcolor='pink'>
<tr><td align='left'>Another One Is User With Priority As 2nd
<tr><td align='left'>Rights For User With Priority As 2:
<tr><td align='left'>1)View All Entry
<tr><td align='left'>2)View Entry Entered By Him/Her
<tr><td align='left'>3)Make Entry
<tr><td align='left'>4)Delete Entry Entered By Him/Her
<tr><td align='left'>5)Update Entry (scope)
<tr><td align='left'>6)Generate Latest Merit List
<tr><td align='left'>7)Manage Personal A/C Settings Such As Channge Password & Etc
</table>
</table>
<tr><td><table align='center' border=0><tr><td><img src='developer.jpg'></img></td></tr><tr><td>Chawda.Ketan.A<tr><td>9979251022</td></tr></table>

</table>
</body>
</html>
<%}else{%>
<h1><center>Sorry Page Exists But You Are Unauthorized User For
This Page Thanks Best Luck Next Time
<br><br><br><a href="/Registration/SignIn.jsp">Login Again</a><br><br><br>
<%}}%>
