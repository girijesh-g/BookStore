package test;
import java .io.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends GenericServlet {

public void service (ServletRequest req, ServletResponse res) throws ServletException, IOException{
		
		String submit = req.getParameter("s1");
		if (submit.equals("Admin")) {
			RequestDispatcher rd= req.getRequestDispatcher("Alogin.html");
			rd.forward(req,res);
		}
		else {
			RequestDispatcher
			rd= req.getRequestDispatcher("Ulogin.html");
			rd.forward(req,res);

}
}
}