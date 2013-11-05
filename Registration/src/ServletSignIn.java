

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
 * Servlet implementation class for Servlet: ServletSignIn
 *
 */
 public class ServletSignIn extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ServletSignIn() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter kout=response.getWriter();
		kout.println("<html><head><title>Sign-In In Progress</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/SignIn.jsp'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		//HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st;
		String myuser="",mypass="",t1="",t2="",t3="";

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				st=kac.createStatement();
		
				myuser=request.getParameter("userid");
				mypass=request.getParameter("password");
							
				ResultSet rs=st.executeQuery("select * from login where userid='"+myuser+"' and password='"+mypass+"' and locked='no'");
				int c=1;
				while(rs.next())
				{
					c=c+1;
					t1=rs.getString("userid");
					t2=rs.getString("password");
					t3=rs.getString("priority");
				}
				rs.close();
				if(c!=1 && t1.compareTo(myuser)==0 && t2.compareTo(mypass)==0)
				{
				HttpSession my=request.getSession(true);
				my.setAttribute("uid",t1);
				my.setAttribute("uprior",t3);
				my.setAttribute("status","true");
				response.sendRedirect("/Registration/Reports.jsp");
				st.close();
				}
				else
					kout.println("<br><br><h2><center>Sorry In-Valid Username Or Password Or Admin Might Locked It<br><br><br><a href='SignIn.jsp'> Login Again</a>");
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