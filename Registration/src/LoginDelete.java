

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
 * Servlet implementation class for Servlet: LoginDelete
 *
 */
 public class LoginDelete extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public LoginDelete() {
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
		kout.println("<html><head><title>All Logins</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		HttpSession my=request.getSession(false);
		Connection kac=null;
		String tuserid="",tdesg="",tprior="",tlocked="",query1="";
		Statement st;
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				//Statement st;
				//String tuserid="",tdesg="",tprior="",tlocked="",query1="";
				st=kac.createStatement();
				ResultSet rs=st.executeQuery("select * from login order by userid");
				
				kout.println("<br><br><br><br><br><br><br>");
				kout.println("<form action='/Registration/LoginDeleteHelp'>");
				kout.println("<table align='left' width='100%' border=1 bordercolor='black' cellspacing='0' cellpadding='0' style='border-collapse: collapse'>");
				kout.println("<tr bgcolor='pink'><td><input type='submit' value='Delete'><td>Sr No<td>User Name<td>Designation<td>Priority<td>Locked");
				int total=0;
				while(rs.next())
				{
					total=total+1;
					tuserid=rs.getString("userid");
					kout.println("<tr><td><input type='checkbox' name='"+"k"+total+"' value='"+tuserid+"'>");
					
					tdesg=rs.getString("desg");
					tprior=rs.getString("priority");
					tlocked=rs.getString("locked");
	
					kout.println("<td>"+total);
					kout.println("<td>"+tuserid);
					kout.println("<td>"+tdesg);
					kout.println("<td>"+tprior);
					kout.println("<td>"+tlocked);
				}
				kout.println("<tr><td><input type='hidden' name='total' value='"+total+"'>");
				kout.println("</form>");
				
				kout.println("</table>");
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
			kout.println("Sorry Connection Is Not Active Now");
			kout.println("<html><body bgcolor='white'>");
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