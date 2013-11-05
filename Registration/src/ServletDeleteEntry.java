

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

/**
 * Servlet implementation class for Servlet: ServletDeleteEntry
 *
 */
 public class ServletDeleteEntry extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ServletDeleteEntry() {
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
		kout.println("<html><head><title>Login Deletion In Progress</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		
		HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st;
		String tuserid="",tprior="",tform_no="",query="",query1="";
		
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
				tuserid=my.getAttribute("uid").toString();
				tprior=my.getAttribute("uprior").toString();
				
				tform_no=request.getParameter("form_no");
				
				int count=0;
				if(tprior.compareToIgnoreCase("1")==0)
				query="select * from StudentsDetails where Form_No='"+tform_no+"'";
				else	
				query="select * from StudentsDetails where Form_No='"+tform_no+"' and Faculty='"+tuserid+"'";
				
				ResultSet rs=st.executeQuery(query);
				while(rs.next())
				{
					count=count+1;
				}
				rs.close();
				if(count!=0)
				{
					query1="delete * from StudentsDetails where Form_No='"+tform_no+"'";
					st=kac.createStatement();
					st.executeUpdate(query1);
					query1="delete * from meritlist where Form_No='"+tform_no+"'";
					st=kac.createStatement();
					st.executeUpdate(query1);
					st.close();
					kout.println("<br><br><h2><center>Ok Entry Deleted");
				}
				else
					kout.println("<br><br><h2><center>Sorry This Form No. Does Not Exists Or You Are UnAuthorized To Delete It");
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