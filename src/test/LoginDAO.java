package test;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

@SuppressWarnings("unused")
public class LoginDAO {
	public boolean z;
	public boolean validate(String uName, String pWord, String submit,ServletContext sct){
		try {
			Connection con= DBConnection.getConn();
			if (uName.equals("userLogin")) {
				PreparedStatement ps= con.prepareStatement("select* from UserReg20 where uname=?and pword=?)");
				ps.setString(1,uName);
				ps.setString(2,pWord);
				ResultSet rs= ps.executeQuery();
				if(rs.next()) {
					z= true;
					sct.setAttribute("fName", rs.getString(3));
					}
			}
			else {
				PreparedStatement ps= con.prepareStatement("select* from Admin20 where uname=? and pword=?");
				ps.setString(1,uName);
				ps.setString(2,pWord);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					z= true ;
							sct.setAttribute("fName", rs.getString(3));
						}
				}
			}
		catch (Exception e) {e.printStackTrace();}
		return z;
	
	}
	
}
