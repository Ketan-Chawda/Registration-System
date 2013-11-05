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
<script type="text/javascript">
function hsc(myform1)
{
var v1=parseInt(myform1.hscobtain.value);
var v2=parseInt(myform1.hscout.value);
myform1.hscper.value=(v1*100)/v2;
}
function ssc(myform1)
{
var v1=parseInt(myform1.sscobtain.value);
var v2=parseInt(myform1.sscout.value);
myform1.sscper.value=(v1*100)/v2;
}

</script>
<body background='whole.jpg'>
<blockquote>
<table align="right"><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>
<form action="/Registration/ServletMakeEntry" method="post">
<b><table border="0">
<tr><td>
Form No:
<td><input type="text" name="fno" size="6">

<td>
Course:
<td>

<select name="course">
<option selected="selected">ALL
</option>
<option>BBA
</option>
<option>5 yrs MBA
</option>
<option>BCA
</option>
<option>5 yrs MSc IT
</option>
<option>5 yrs MSc Bio
</option>
<option>5 yrs MSc Micro
</option>
<option>BCOM CA
</option>
<option>BCOM CH A/C
</option>
<option>BCOM Guj
</option>
<option>BCOM Eng
</option>

</select>

<tr><td>
Stream:
<td>

<select name="stream">
<option>Commerce
</option>
<option>Sci Maths
</option>
<option>Sci Bio
</option>
<option>Sci Cmb
</option>
<option>Arts
</option>
<option>Vocational
</option>
</select>

<tr><td>
Surname:
<td><input type="text" name="surname">

<tr><td>
Student's Name:
<td><input type="text" name="sname">

<tr><td>
Father's Name:
<td><input type="text" name="fname">

<tr><td>
Category:
<td>

<select name="category">
<option>OPEN
</option>
<option>SC
</option>
<option>ST
</option>
<option>SEBC
</option>
<option>PH
</option>
</select>

<tr><td>
BirthDate:

<td>
<select name="bday">
<option>01</option><option>02</option><option>03</option><option>04</option><option>05</option><option>06</option>
<option>07</option><option>08</option><option>09</option><option>10</option>
<option>11</option><option>12</option><option>13</option><option>14</option><option>15</option><option>16</option>
<option>17</option><option>18</option><option>19</option><option>20</option>
<option>21</option><option>22</option><option>23</option><option>24</option><option>25</option><option>26</option>
<option>27</option><option>28</option><option>29</option><option>30</option>
<option>31</option>
</select>

<select name="bmonth">
<option>January</option><option>February</option><option>March</option><option>April</option><option>May</option><option>June

</option>
<option>July</option><option>August</option><option>September</option><option>October</option><option>November</option><option>December</option>
</select>

<input type="text" size=4 name="byear">

<tr><td>
Gender:

<td>
<input type="radio" name="gender" value="m">
Male
<input type="radio" name="gender" value="f">
Female

<tr><td>
MobileNo:
<td><input type="text" name="mob1" maxlength="12" size=12>

<input type="text" name="mob2" maxlength="12" size=12>

<tr><td>
LandLine:
<td><input type="text" name="land" maxlength="12" size=12>

<tr><td>
Address:<td><textarea rows="3" cols="30" name="addr" ></textarea>

<tr><td><td>
<center><u><i>HSC Details</i></u></center>

<tr><td>
Obtained:
<td><input type="text" name="hscobtain" size=4>

<td>
Out Of:
<td><input type="text" name="hscout" size=4 onblur="hsc(this.form)">

<td>English:
<td><input type="text" name="hsceng" size=3>

<tr><td>
Passing Year
<td>
<select name="hscpass">
<option>2001
</option>
<option>2002
</option>
<option>2003
</option>
<option>2004
</option>
<option>2005
</option>
<option>2006
</option>
<option>2007
</option>
<option>2008
</option>
<option>2009
</option>
<option>2010
</option>
<option>2011
</option>

</select>


<td>
Percentage
<td><input type="text" name="hscper" readonly="readonly" size=10>

<td>Board:
<td><input type="text" name="hscboard">



<tr><td><td>
<center><u><i>SSC Details</i></u></center>

<tr><td>
Obtained:<td><input type="text" name="sscobtain" size=4>
<td>
Out Of:<td><input type="text" name="sscout" size=4 onblur="ssc(this.form)">


<tr><td>
Passing Year
<td>
<select name="sscpass">
<option>2001
</option>
<option>2002
</option>
<option>2003
</option>
<option>2004
</option>
<option>2005
</option>
<option>2006
</option>
<option>2007
</option>
<option>2008
</option>
<option>2009
</option>
<option>2010
</option>
<option>2011
</option>
</select>

<td>
Percentage
<td><input type="text" name="sscper" readonly="readonly" size=10>

<td>Board:
<td><input type="text" name="sscboard">


<tr><td><br>
<tr><td>
<td><input type="submit" value="Make Entry">
<td><input type="reset" value="Reset All">
</table>
</form>
</body>
</html>
<%}else{%>
<h1><center>Sorry Page Exists But You Are Unauthorized User For
This Page Thanks Best Luck Next Time
<br><br><br><a href="/Registration/SignIn.jsp">Login Again</a><br><br><br>
<%}}%>
