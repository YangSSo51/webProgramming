package machingProject;

import java.sql.*;

public class DBConnection {
	static Connection con =null;
	String url="jdbc:mysql://localhost:3306/test";
	String user="root";
	String password = "0501";
	
	private static DBConnection instance = null;
	
	public static DBConnection getInstance() {
		if(instance ==null) {
			synchronized(DBConnection.class){
				if(instance ==null) {
					instance = new DBConnection();
				}
			}
		}
		return instance;
	}

	public synchronized Connection getConnection() throws Exception{
		Class c = Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,password);
		return con;
	}
	
	
}
