

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
 * Servlet implementation class for Servlet: AllRegisteredDelete
 *
 */
 public class AllRegisteredDelete extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AllRegisteredDelete() {
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
		Statement st;
		String tfno="",tstream="",tsurname="",tsname="",tfname="",tgender="",tcategory="",tmob1="",tmob2="",tland="",thscobtain="",thscout="",thscper="",thsceng="",tsscobtain="",tsscout="",tsscper="",tbyuser="",tedate="";
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			
			if(kac!=null)
			{
			try
			{
				//String tfno="",tstream="",tsurname="",tsname="",tfname="",tgender="",tcategory="",tmob1="",tmob2="",tland="",thscobtain="",thscout="",thscper="",thsceng="",tsscobtain="",tsscout="",tsscper="",tbyuser="",tedate="";
				st=kac.createStatement();
				ResultSet rs=st.executeQuery("select * from StudentsDetails order by Form_No");
				
				kout.println("<br><br><br><br><br><br><br>");
				kout.println("<form action='/Registration/AllRegisteredDeleteHelp'>");
				kout.println("<table align='left' width='100%' border=1 bordercolor='black' cellspacing='0' cellpadding='0' style='border-collapse: collapse'>");
				kout.println("<tr bgcolor='pink'><td><input type='submit' value='Delete'><td>Form No.<td>Stream<td>Surname<td>Student Name");
				kout.println("<td>Father Name<td>Gender<td>Category<td>Mobile");
				kout.println("<td>LandLine<td>HSC Obtain<td>HSC Out<td>HSC Per");
				kout.println("<td>HSC Eng<td>SSC Obtain<td>SSC Out<td>SSC Per");
				kout.println("<td>Entered By");//<td>OnDate");
				int c=0;
				while(rs.next())
				{
					c=c+1;
					tfno=rs.getString("Form_No");
					kout.println("<tr><td><input type='checkbox' name='"+"k"+c+"' value='"+tfno+"'>");
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
					
					kout.println("<td>"+tfno);
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
				kout.println("<tr><td><input type='hidden' name='total' value='"+c+"'>");
				kout.println("</form>");
				rs.close();
				st.close();
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
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			kout.close();
		}
}
}
  	    
