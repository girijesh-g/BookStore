package test;
import java.io.*;
import javax.servlet.*;

@SuppressWarnings("serial")
public class AdminLoginServlet extends GenericServlet {
	public ServletContext sct;
	public void init()throws ServletException{
		sct = this.getServletContext();
	}
	public void service(ServletRequest req, ServletResponse res)  throws ServletException,IOException{
		PrintWriter pw= res.getWriter();
		res.setContentType("html/text");
		String uName= req.getParameter("uName");
		String pWord= req.getParameter("pWord");
		String submit = req.getParameter("s1");
		LoginDAO ld = new LoginDAO();
		boolean k = ld.validate(uName,pWord,submit, sct);
		if(k) {
			String fName = (String) sct.getAttribute("fName");
			pw.println("welcome user:"+fName+"<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Link1.html");
			rd.include(req, res);
		}
		else {
			pw.println("invalid user name or password<br>");
			RequestDispatcher rd= req.getRequestDispatcher("Alogin.html");
			rd.include(req, res);
		}
	}
}
