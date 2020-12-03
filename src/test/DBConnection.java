package test;
import java.sql.*;
public class DBConnection {
	private static Connection conn;
	private DBConnection () {}
	static {
try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
}// end of try
catch(Exception e){e.printStackTrace();}
}// end of block
	public static Connection getConn() {
		return conn;
	}
	
}