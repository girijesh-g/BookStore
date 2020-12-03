package test;
import java.sql.*;
@SuppressWarnings("unused")
public class AddBookDAO {
	public int z;
	public int addBook(BookBean bb) {
		try {
			Connection con = DBConnection.getConn();
			PreparedStatement ps = con.prepareStatement("insert into Book20 values(?,?,?,?,?,?,?)");
			ps.setString(1, bb.getbCode());
			ps.setString(2,bb.getbName());
			ps.setString(3,bb.getbAuthor());
			ps.setFloat(4,bb.getbPrice());
			ps.setInt(5, bb.getbQty());
		
			z= ps .executeUpdate();
				}
					 catch (Exception e) {e.printStackTrace();}
				 return z;
			
	}
		
	}


