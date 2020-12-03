package test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.*;
public class ViewBookServlet1 extends GenericServlet{
	public Connection con;
	public void init() throws ServletException{
		con= DBConnection. getConn();
		}
	public void service(ServletRequest req, ServletResponse res)  throws ServletException,IOException{
		PrintWriter pw= res.getWriter();
		res.setContentType("html/text");
		ServletContext sct = this.getServletContext();
		String fName=(String) sct.getAttribute("fName");
		pw.println("welcome user:"+fName+"<br>");
		 RequestDispatcher rd= req.getRequestDispatcher("Link1.html");
		 rd.include(req, res);
		 try {
			 PreparedStatement ps = con.prepareStatement("Select* from Book20");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				pw.println("<br>"+rs.getString(1)+"&nbsp&nbsp"+rs.getString(2)+"&nbsp&nbsp"+ rs.getString(3)+"&nbsp&nbsp"+rs.getFloat(4)+"&nbsp&nbsp"+rs.getInt(5));
			}
		 }
		 catch (Exception e ) {e.printStackTrace();}
}
}


