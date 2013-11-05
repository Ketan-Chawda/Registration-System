

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import mybest.*;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: AllMeritReport
 *
 */
 public class AllMeritReport extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AllMeritReport() {
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
		kout.println("<html><head><title>View Merit</title></head>");
		kout.println("<table align='right'><tr><td bgcolor='yellow'><h2><a href='javascript:history.go(-1)'>Go Back</a><tr><td bgcolor='white'><h2><a href='/Registration/ServletSignOut'>Log-Out</a><tr><td bgcolor='orange'><h2><a href='javascript:history.go(1)'>Go Next</a><tr><td bgcolor='pink'><h2><a href='javascript:history.go(0)'>Refresh Page</a></table>");
		HttpSession my=request.getSession(false);
		Connection kac=null;
		Statement st;
		String tmno="",tfno="",tsname="",thscper="",tstream="",tsscper="",thsceng="",tcategory="",tbba="",tmba="",tbca="",tmsc_it="",tmsc_bio="",tmsc_micro="",tbcom_ca="",tbcom_crt="",tbcom_guj="",tbcom_eng="",query1="";
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			kac=DriverManager.getConnection("jdbc:odbc:myone");
			if(kac!=null)
			{
			try
			{
				//String tmno="",tfno="",tsname="",thscper="",tstream="",tsscper="",thsceng="",tcategory="",tbba="",tmba="",tbca="",tmsc_it="",tmsc_bio="",tmsc_micro="",tbcom_ca="",tbcom_crt="",tbcom_guj="",tbcom_eng="",query1="";
				st=kac.createStatement();
				ResultSet rs=st.executeQuery("select * from meritlist order by Merit_No");
			
				kout.println("<br><br><br><br><br><br><br>");
				//kout.println("<table align='left' width='100%' border=1>");
				kout.println("<table align='left' width='100%' border=1 bordercolor='black' cellspacing='0' cellpadding='0' style='border-collapse: collapse'><h2>");
				kout.println("<tr bgcolor='pink'><td>Merit No.<td>Form No.<td>Student Name");
				kout.println("<td>HSC Per<td>Stream<td>Category<td>SSC Per");
				kout.println("<td>HSC Eng<td>BBA<td>5 yrs int MBA");
				kout.println("<td>BCA<td>5 yrs int M.SC IT<td>5 yrs int MSC. Bio<td>5 yrs int MSC Micro");
				kout.println("<td>B.Com Comp. Appli.<td>B.Com Cha. C/A<td>B.Com Guj.<td>B.Com Eng.");
				while(rs.next())
				{
					tmno=rs.getString("Merit_No");
					tfno=rs.getString("Form_No");
					tsname=rs.getString("Stud_Name");
					thscper=rs.getString("HSC_Per");
					int len=thscper.length();
					if(len>5)
					thscper=thscper.substring(0,5);
					else
					thscper=thscper.substring(0,len);
						
					
					tstream=rs.getString("Stream");
					tcategory=rs.getString("category");
					tsscper=rs.getString("SSC_Per");
					len=tsscper.length();
					if(len>5)
					tsscper=tsscper.substring(0,5);
					else
					tsscper=tsscper.substring(0,len);
					
					thsceng=rs.getString("HSC_Eng");
					tbba=rs.getString("BBA");
					tmba=rs.getString("MBA");
					tbca=rs.getString("BCA");
					tmsc_it=rs.getString("MSc_IT");
					tmsc_bio=rs.getString("MSc_Bio");
					tmsc_micro=rs.getString("MSc_Micro");
					tbcom_ca=rs.getString("BCom_Ca");
					tbcom_crt=rs.getString("BCom_Ch_Ac");
					tbcom_guj=rs.getString("BCom_Guj");
					tbcom_eng=rs.getString("BCom_Eng");
					
					/*tmno=Styles.ccase(tmno);
					tfno=Styles.ccase(tfno);
					tsname=Styles.ccase(tsname);
					thscper=Styles.ccase(thscper);
					
					tstream=Styles.ccase(tstream);
					//tcategory=rs.getString("category"); not needed
					tsscper=Styles.ccase(tsscper);
					thsceng=Styles.ccase(thsceng);
					tbba=Styles.ccase(tbba);
					tmba=Styles.ccase(tmba);
					tbca=Styles.ccase(tbca);
					tmsc_it=Styles.ccase(tmsc_it);
					tmsc_bio=Styles.ccase(tmsc_bio);
					tmsc_micro=Styles.ccase(tmsc_micro);
					tbcom_ca=Styles.ccase(tbcom_ca);
					tbcom_crt=Styles.ccase(tbcom_crt);
					tbcom_guj=Styles.ccase(tbcom_guj);
					tbcom_eng=Styles.ccase(tbcom_eng);*/
					

					if(tbba.compareToIgnoreCase("")==0)
					tbba="Yes";
					if(tmba.compareToIgnoreCase("")==0)
					tmba="Yes";
					if(tbca.compareToIgnoreCase("")==0)
					tbca="Yes";
					if(tmsc_it.compareToIgnoreCase("")==0)
					tmsc_it="Yes";
					
					if(tmsc_bio.compareToIgnoreCase("")==0)
					tmsc_bio="Yes";
					if(tmsc_micro.compareToIgnoreCase("")==0)
					tmsc_micro="Yes";
					if(tbcom_ca.compareToIgnoreCase("")==0)
					tbcom_ca="Yes";
					if(tbcom_crt.compareToIgnoreCase("")==0)
					tbcom_crt="Yes";
					if(tbcom_guj.compareToIgnoreCase("")==0)
					tbcom_guj="Yes";
					if(tbcom_eng.compareToIgnoreCase("")==0)
					tbcom_eng="Yes";
							
					
					kout.println("<tr><td>"+tmno);
					kout.println("<td>"+tfno);
					kout.println("<td>"+tsname);
					kout.println("<td>"+thscper);
					kout.println("<td>"+tstream);
					kout.println("<td>"+tcategory);
					kout.println("<td>"+tsscper);
					kout.println("<td>"+thsceng);
					kout.println("<td>"+tbba);
					kout.println("<td>"+tmba);
					kout.println("<td>"+tbca);
					kout.println("<td>"+tmsc_it);
					kout.println("<td>"+tmsc_bio);
					kout.println("<td>"+tmsc_micro);
					kout.println("<td>"+tbcom_ca);
					kout.println("<td>"+tbcom_crt);
					kout.println("<td>"+tbcom_guj);
					kout.println("<td>"+tbcom_eng);
							
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