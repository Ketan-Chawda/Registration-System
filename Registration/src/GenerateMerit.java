

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
 * Servlet implementation class for Servlet: GenerateMerit
 *
 */
 public class GenerateMerit extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GenerateMerit() {
		super();
	}   	
	int total=0;
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter kout=response.getWriter();
		kout.println("<html><head><title>Input Process</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/SignIn.jsp'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		//HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st,st1;
		String tfno="",tsurname="",tsname="",tfname="",thscper="",tsscper="",tcategory="",thsceng="",tstream="",query1="";
		String twhole="",tcourse="";
		String tbba="",tmba="",tbca="",tmsc_it="",tmsc_bio="",tmsc_micro="",tbcom_ca="",tbcom_crt="",tbcom_guj="",tbcom_eng="";
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				st=kac.createStatement();
				st.executeUpdate("delete * from meritlist");
				st1=kac.createStatement();
				ResultSet rs=st1.executeQuery("select * from StudentsDetails order by HSC_Per+SSC_Per+HSC_Eng desc");
				
				while(rs.next())
				{
					
				total=total+1;
				tfno=rs.getString("Form_No");
				tcourse=rs.getString("Course");
				tsurname=rs.getString("Surname");
				tsname=rs.getString("Stud_Name");
				tfname=rs.getString("Fathers_Name");
				thscper=rs.getString("HSC_Per");
				tsscper=rs.getString("SSC_Per");
				tcategory=rs.getString("Category");
					
					
				thsceng=rs.getString("HSC_Eng");
				tstream=rs.getString("Stream");
				
				if(thsceng.compareToIgnoreCase("N/A")==0)
				{
					tbba="N/E";
					tmba="N/E";
					tbca="N/E";
					tmsc_it="N/E";
					tmsc_bio="N/E";
					tmsc_micro="N/E";
				}
			if(tstream.compareToIgnoreCase("sci bio")==0 || tstream.compareToIgnoreCase("sci cmb")==0)
			{
				tbcom_ca="N/E";
				tbcom_crt="N/E";
				tbcom_guj="N/E";
				tbcom_eng="N/E";
			}
			if(tstream.compareToIgnoreCase("sci maths")==0)
			{
				tmsc_bio="N/E";
				tmsc_micro="N/E";
				tbcom_ca="N/E";
				tbcom_crt="N/E";
				tbcom_guj="N/E";
				tbcom_eng="N/E";
			}
			
			if(tstream.compareToIgnoreCase("arts")==0)
			{
				tbca="N/E";
				tmsc_it="N/E";
				tmsc_bio="N/E";
				tmsc_micro="N/E";
				tbcom_ca="N/E";
				tbcom_crt="N/E";
				tbcom_guj="N/E";
				tbcom_eng="N/E";
			}
			if(tstream.compareToIgnoreCase("commerce")==0 || tstream.compareToIgnoreCase("vocational")==0)
			{
				tmsc_bio="N/E";
				tmsc_micro="N/E";
			}
				twhole=tsurname+" "+tsname+" "+tfname;
				
				query1="insert into meritlist(Merit_No,Form_No,Course,Stud_Name,HSC_Per,Stream,Category,SSC_Per,HSC_Eng,BBA,MBA,BCA,MSc_IT,MSc_Bio,MSc_Micro,BCom_CA,BCom_Ch_Ac,BCom_Guj,BCom_Eng) values('"+total+"','"+tfno+"','"+tcourse+"','"+twhole+"','"+thscper+"','"+tstream+"','"+tcategory+"','"+tsscper+"','"+thsceng+"','"+tbba+"','"+tmba+"','"+tbca+"','"+tmsc_it+"','"+tmsc_bio+"','"+tmsc_micro+"','"+tbcom_ca+"','"+tbcom_crt+"','"+tbcom_guj+"','"+tbcom_eng+"')";
				st=kac.createStatement();
				st.executeUpdate(query1);
			}
				rs.close();
				//st1.close();
				//st.close();
				
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
			total=0;
			response.sendRedirect("/Registration/Reports.jsp");
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