

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: MyRegisteredReport
 *
 */
 public class MyRegisteredReport extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public MyRegisteredReport() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter kout=response.getWriter();
		kout.println("<html><head><title>View All Registered</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		HttpSession my=request.getSession(false);
		Connection kac=null;
		String tuserid="",tfno="",tstream="",tsurname="",tsname="";
		String tfname="",tgender="",tcategory="",tmob1="";
		String tmob2="",tland="",thscobtain="",thscout="";
		String thscper="",thsceng="",tsscobtain="",tsscout="";
		String tsscper="",tbyuser="",tedate="";
		Statement st;
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				st=kac.createStatement();
				tuserid=my.getAttribute("uid").toString();
				ResultSet rs=st.executeQuery("select * from StudentsDetails where Faculty='"+tuserid+"'");
				kout.println("<br><br><br><br><br><br><br>");
					
				kout.println("<table align='left' width='100%' border=1 bordercolor='black' cellspacing='0' cellpadding='0' style='border-collapse: collapse'>");
				kout.println("<tr bgcolor='pink'><td>Form No.<td>Stream<td>Surname<td>Student Name");
				kout.println("<td>Father Name<td>Gender<td>Category<td>Mobile");
				kout.println("<td>LandLine<td>HSC Obtain<td>HSC Out<td>HSC Per");
				kout.println("<td>HSC Eng<td>SSC Obtain<td>SSC Out<td>SSC Per");
				kout.println("<td>Entered By");//<td>OnDate");
				while(rs.next())
				{
					tfno=rs.getString("Form_No");
					tstream=rs.getString("Stream");
					tsurname=rs.getString("Surname");
					tsname=rs.getString("Stud_Name");
					tfname=rs.getString("Fathers_Name");
					tgender=rs.getString("Gender");
					tcategory=rs.getString("Category");
					tmob1=rs.getString("Mob1");
					tmob2=rs.getString("Mob2");
					tland=rs.getString("LandLine");
					thscobtain=rs.getString("HSC_Obt");
					thscout=rs.getString("HSC_Outof");
				
					thscper=rs.getString("HSC_Per");
					int len=thscper.length();
					if(len>5)
					thscper=thscper.substring(0,5);
					else
					thscper=thscper.substring(0,len);
					
					thsceng=rs.getString("HSC_Eng");
					tsscobtain=rs.getString("SSC_Obt");
					tsscout=rs.getString("SSC_Outof");
					tsscper=rs.getString("SSC_Per");
					len=tsscper.length();
					if(len>5)
					tsscper=tsscper.substring(0,5);
					else
					tsscper=tsscper.substring(0,len);
					
					tbyuser=rs.getString("Faculty");
					tedate=rs.getString("Ent_Date");
					
					kout.println("<tr><td>"+tfno);
					kout.println("<td>"+tstream);
					kout.println("<td>"+tsurname);
					kout.println("<td>"+tsname);
					kout.println("<td>"+tfname);
					kout.println("<td>"+tgender);
					kout.println("<td>"+tcategory);
					kout.println("<td>"+tmob1);
					//kout.println("<td>"+tmob2);//not needed
					kout.println("<td>"+tland);
					kout.println("<td>"+thscobtain);
					kout.println("<td>"+thscout);
					kout.println("<td>"+thscper);
					kout.println("<td>"+thsceng);
					kout.println("<td>"+tsscobtain);
					kout.println("<td>"+tsscout);
					kout.println("<td>"+tsscper);
					kout.println("<td>"+tbyuser);
							
				}
				rs.close();
				st.close();
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
			kac.close();
			}
			}
			else
			kout.println("<br><br><h2><center>Sorry Connection Is Not Active Now");
			//kout.println("<html><body background='whole.jpg'>");
			//kout.println("</body></html>");

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