

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
 * Servlet implementation class for Servlet: ServletChangePassword
 *
 */
 public class ServletChangePassword extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ServletChangePassword() {
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
		kout.println("<html><head><title>Change Password In Progress</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		
		HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st;
		String tuserid="",toldone="",tverify="",tnewone="",tconfirm="",query1="";

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
				
				toldone=request.getParameter("oldone");
				tnewone=request.getParameter("newone");
				tconfirm=request.getParameter("confirm");
				
				ResultSet rs=st.executeQuery("select * from login where userid='"+tuserid+"'");
				while(rs.next())
				{
				tverify=rs.getString("password");
				}
				
				if(toldone.compareTo(tverify)==0 && tnewone.compareTo(tconfirm)==0)
				{
					query1="update login set password='"+tnewone+"' where userid='"+tuserid+"'";
					st=kac.createStatement();
					st.executeUpdate(query1);
					st.close();
					kout.println("<br><br><h2><center>Ok Your Password Has Been Changed");
				}
				else
				kout.println("<br><br><h2><center>Sorry Your Password Is Not Changed");
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
