package test;
import java.io.*;
import javax.servlet.*;
public class FinalRegServlet extends GenericServlet {
	public ServletContext sct;
	public RegBean rb;
	public void init()throws ServletException{
		sct= this.getServletContext();
		rb= (RegBean)sct.getAttribute("beanref");
	}
	public void service(ServletRequest req, ServletResponse res)  throws ServletException,IOException{
		PrintWriter pw= res.getWriter();
		res.setContentType("html/text");
		RegisterDAO rd= new RegisterDAO();
		int k= rd.register(rb);
		if(k>0)
		{
			pw.println("User Registered Successfully<br>");
			RequestDispatcher rds= req.getRequestDispatcher("Ulogin.html");
			rds.include(req, res);
		}
	}
}