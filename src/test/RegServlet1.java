package test;
import java.io.*;
import javax.servlet.*;
@SuppressWarnings("serial")
public class RegServlet1  extends GenericServlet{
	public RegBean rb;
	public ServletContext sct;
	public void init() throws ServletException{
		rb= new RegBean();
		sct= this.getServletContext();
		
	}

	public void service(ServletRequest req, ServletResponse res)  throws ServletException,IOException{
	String uname= req.getParameter("uname");
	String pword= req.getParameter("pword");
	String fname= req.getParameter("fname");
	String lname= req.getParameter("lname");
	rb.setuName(uname);
	rb.setpWord(pword);
	rb.setfName(fname);
	rb.setlName(lname);
	sct.setAttribute("beanRef",rb);
	RequestDispatcher rd= req.getRequestDispatcher("Register2.html");
	rd.forward(req, res);
	
}
}