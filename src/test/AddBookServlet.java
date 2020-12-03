package test;
import java.io.*;
import javax.servlet.*;

@SuppressWarnings("serial")
public class AddBookServlet extends GenericServlet{
	public ServletContext sct;
	public BookBean bb;
	public void init()throws ServletException{
		sct = this.getServletContext();
		bb= new BookBean();
	}
	public void service(ServletRequest req, ServletResponse res)  throws ServletException,IOException{
		PrintWriter pw= res.getWriter();
		res.setContentType("html/text");
		String bCode= req.getParameter("bCode");
		String bName= req.getParameter("bName");
		String bAuthor= req.getParameter("bAuthor");
		float bPrice = Float.parseFloat(req.getParameter("bPrice"));
		int bQty= Integer.parseInt(req.getParameter("bQty"));
		String fName=(String) sct.getAttribute("fName");
		bb.setbCode(bCode);
		bb.setbCode(bName);
		bb.setbPrice(bPrice);
		bb.setbQty(bQty);
		pw.println("welcome ADMIN:"+fName+"<br>");
		RequestDispatcher rd= req.getRequestDispatcher("Link1.html");
		rd.include(req,res);
AddBookDAO abd = new AddBookDAO();
int z = abd.addBook(bb);
if(z>0) {
	pw.println("<br>----- Book Added Successfuly-----");
}
	}
}
