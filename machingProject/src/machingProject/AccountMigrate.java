package machingProject;
import java.sql.*;
import machingProject.DBConnection;

public class AccountMigrate {
	static Connection con =null;
	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String password = "0501";

		
	public boolean login(String id,String pw) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			sql = "select id from account where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			flag=rs.next();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		return flag;
	}
	public boolean signup(accountBean bean) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			sql = "insert account(id,pwd,email,auth)"+ "values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "so");
			pstmt.setString(2, bean.getpw());
			pstmt.setString(3, bean.getemail());
			pstmt.setString(4, bean.getAuth());
			if(pstmt.executeUpdate()==1) flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		return flag;
	}
	public boolean showAccount(String id,String pw) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		if(id.equals("root")) {
			try {
				sql = "select * from account";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				flag=rs.next();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
			}
		}
		return flag;
	}
}
