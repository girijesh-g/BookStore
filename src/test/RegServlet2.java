package test;
import java.io.*;
import javax.servlet.*;

@SuppressWarnings("serial")
public  class RegServlet2 extends GenericServlet{
public RegBean rb;
public ServletContext sct;

@Override
public void init() throws ServletException {
	sct= this.getServletContext();
	rb= (RegBean)sct.getAttribute("beanRef");
}
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
	PrintWriter pw= res.getWriter();
	res.setContentType("text/html");
	String addr= req.getParameter("addr");
	long phNo = Long.parseLong(req.getParameter("phNo"));
	String mId = req.getParameter("mid");
	rb.setAddr(addr);
	rb.setmId(mId);
	rb.setPhNo(phNo);
	pw.println("your registration detalis are valid");
	pw.println("<a href= 'dis'>CLICK</a>");
	pw.println("to view registration detalis");
	
}

}

