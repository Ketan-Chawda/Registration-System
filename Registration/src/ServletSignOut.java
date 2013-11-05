

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: ServletSignOut
 *
 */
 public class ServletSignOut extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ServletSignOut() {
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
		kout.println("<html><head><title>Signout Process</title></head>");
		
		Connection mycon=null;
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			mycon=DriverManager.getConnection("jdbc:odbc:myone");
			if(mycon!=null)
			{
		try
		{
			HttpSession last=request.getSession(false);
			last.invalidate();
			last=null;
			response.sendRedirect("/Registration/SignIn.jsp");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			mycon.close();
		}
		}
		else
			kout.println("<br><br><h2><center>Sorry Connection Is Not Active Now");
			response.sendRedirect("/Registration/SignIn.jsp");
			kout.println("<html><body background='whole.jpg'>");
			kout.println("</body></html>");
		}
		catch(Exception e)
		{
			System.err.println(e);	
		}
		finally
		{
			kout.close();
		}
}	    
}