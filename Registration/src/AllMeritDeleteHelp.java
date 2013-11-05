

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: AllMeritDeleteHelp
 *
 */
 public class AllMeritDeleteHelp extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AllMeritDeleteHelp() {
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
		Connection mycon=null;
		Statement st;

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			mycon=DriverManager.getConnection("jdbc:odbc:myone");
			if(mycon!=null)
			{
			try
			{	
				String v1,v2;
				int total=Integer.parseInt(request.getParameter("total"));
				
				for(int k=1;k<=total;k++)
				{
				v1="k"+k;
				v2=request.getParameter(v1);
				kout.println("<br>checkbox-"+v1+"<br> value="+v2);
				st=mycon.createStatement();
				st.executeUpdate("delete * from meritlist where Form_No='"+v2+"'");
				}
				}
			catch(Exception e)
			{
				System.out.println(e);
			}
			finally
			{
				mycon.close();
				response.sendRedirect("/Registration/AllMeritDelete");
			}
			}
			else
				kout.println("");
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