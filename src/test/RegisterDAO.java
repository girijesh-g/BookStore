package test;
import java .sql.*;

public class RegisterDAO {
	public int k;
	public int register(RegBean rb) {
		try {
			Connection con = DBConnection. getConn();
		PreparedStatement ps = con.prepareStatement("insert into userReg20 values(?,?,?,?,?,?,?)");
		ps.setString(1, rb.getuName());
		ps.setString(2,rb.getpWord());
		ps.setString(3,rb.getfName());
		ps.setString(4,rb.getlName());
		ps.setString(5,(String) rb.getAddr());
		ps.setLong(6,rb.getPhNo());
		ps.setString(7,rb.getmId());
		k= ps .executeUpdate();
			}
				 catch (Exception e) {e.printStackTrace();}
			 return k;
		
}
}
