

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mybest.Styles;

/**
 * Servlet implementation class for Servlet: ServletMakeEntry
 *
 */
 public class ServletMakeEntry extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ServletMakeEntry() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter kout=response.getWriter();
		kout.println("<html><head><title>Input Process</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		
		HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st;
		String tcourse="",tby="",tbyuser="",tfno="",tstream="",tcategory="",tsurname="",tsname="",tfname="",tgender="",tmob1="",tmob2="",tland="",thscobtain="",thscout="",thscper="",thsceng="",tsscobtain,tsscout,tsscper,tedate=new Date().toGMTString().toString(),tbday="",tbmonth="",tbyear="",tbdate="",taddr="",thscboard="",tsscboard="",thscpass="",tsscpass="",query1="";

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				kout.println("<br><br><br><br><br><br><br>");
				
				st=kac.createStatement();
				tbyuser=my.getAttribute("uid").toString();
				int d=new Date().getDate(),m=new Date().getMonth()+1,y=new Date().getYear()+1900;
				tedate=y+"/"+m+"/"+d;
				
				tfno=request.getParameter("fno");
				ResultSet rs=st.executeQuery("select * from StudentsDetails where Form_No='"+tfno+"'");
				int count=0;
				while(rs.next())
				{
				tby=rs.getString("byuser");
				count=count+1;
				}
				rs.close();
				if(count==0)
				{
				st=kac.createStatement();

				tstream=request.getParameter("stream");
				tstream=Styles.ccase(tstream);
				tcourse=request.getParameter("course");
				
				tcategory=request.getParameter("category");
				
				tsurname=request.getParameter("surname");
				tsurname=Styles.ccase(tsurname);
				tsname=request.getParameter("sname");
				tsname=Styles.ccase(tsname);
				tfname=request.getParameter("fname");
				tfname=Styles.ccase(tfname);
				tgender=request.getParameter("gender");
				tgender=Styles.ccase(tgender);
				tmob1=request.getParameter("mob1");
				tmob2=request.getParameter("mob2");
			
				taddr=request.getParameter("addr");
				taddr=Styles.ccase(taddr);
				thscboard=request.getParameter("hscboard");
				thscboard=Styles.ccase(thscboard);
				tsscboard=request.getParameter("sscboard");
				tsscboard=Styles.ccase(tsscboard);
				thscpass=request.getParameter("hscpass");
				tsscpass=request.getParameter("sscpass");
				
				tbday=request.getParameter("bday");
				tbmonth=request.getParameter("bmonth");
				tbyear=request.getParameter("byear");
				
				tbdate=tbday+"/"+tbmonth+"/"+tbyear;
				
				
				if(tmob2==null)
				tmob2="N/A";
				
				tland=request.getParameter("land");
				thscobtain=request.getParameter("hscobtain");
				thscout=request.getParameter("hscout");
				thscper=request.getParameter("hscper");
				thsceng=request.getParameter("hsceng");
				if(thsceng==null)
				thsceng="N/A";
				tsscobtain=request.getParameter("sscobtain");
				tsscout=request.getParameter("sscout");
				tsscper=request.getParameter("sscper");
				
				query1="insert into StudentsDetails(Form_No,Course,Stream,Surname,Stud_Name,Fathers_Name,Gender,Category,Mob1,Mob2,LandLine,HSC_Obt,HSC_Outof,HSC_Per,HSC_Eng,SSC_Obt,SSC_Outof,SSC_Per,Faculty,Ent_Date,Birthdate,Address,HSCExamBoard,HSCPassingYear,SSCExamBoard,SSCPassingYear) values('"+tfno+"','"+tcourse+"','"+tstream+"','"+tsurname+"','"+tsname+"','"+tfname+"','"+tgender+"','"+tcategory+"','"+tmob1+"','"+tmob2+"','"+tland+"','"+thscobtain+"','"+thscout+"','"+thscper+"','"+thsceng+"','"+tsscobtain+"','"+tsscout+"','"+tsscper+"','"+tbyuser+"','"+tedate+"','"+tbdate+"','"+taddr+"','"+thscboard+"','"+thscpass+"','"+tsscboard+"','"+tsscpass+"')";
				st.executeUpdate(query1);
				kout.println("<br><center><h1>Ok Inserted Into Student Details<br>");
				st.close();
				}
				else
				kout.println("<br><center><h1>Sorry Already Inputted By User Named="+tby);
			}
			catch(Exception k)
			{
				System.err.println(k);
			}
			finally
			{
				kac.close();
			}
			}
			else
			kout.println("<br><br><h2><center>Sorry Connection Is Not Active Now");
			kout.println("<html><body background='whole.jpg'>");
			kout.println("</body></html>");
		}
		catch(Exception k)
		{
			System.err.println(k);
		}
		finally
		{
			kout.close();
		}
}
}