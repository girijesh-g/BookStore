package test;
import java.io.*;
import javax.servlet.*;
//import javax.servlet.GenericServlet;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
@SuppressWarnings("serial")
public class DisServlet extends GenericServlet {
	public RegBean rb;
	public ServletContext sct; 
	@Override
	public void init() throws ServletException{
		sct=getServletContext();
		rb= (RegBean) sct. getAttribute("beanRef");
		}
	@Override
	public void service (ServletRequest req, ServletResponse res) throws ServletException, IOException{
		PrintWriter pw= res.getWriter();
		res.setContentType("text/html");
		pw.println("--- Reg Detalis <br>");
		pw.println("<br>UserName:"+rb.getuName());
		pw.println("<br> password:"+rb.getpWord());
		pw.println("<br>fristName:"+rb.getfName());
		pw.println("<br>lastName:"+rb.getlName());
		pw.println("<br>phNo:"+rb.getPhNo());
		pw.println("<br>milId:"+rb.getmId());
		
	pw.println("<br>");
	pw.println("<form action='final' method='post'>");
	pw.println("<input type='submit' value='register'>");
	pw.println("</form>");
		
		
	}
	

}
