package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
	private static final String mySqlUrl = "jdbc:mysql://localhost:3306/shopping?user=root&password=123456"; 
	private static Connection conn = null;
	static {
		try {
			new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//单例模式，返回数据库的连接对象
	public static Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(mySqlUrl);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		return conn;
	}
	
	//测试数据库的连接
	public static void main(String[] args) {
		Connection connection = DBHelper.getConnection();
		if(connection != null) {
			System.out.println("数据库已连接");
		} else {
			System.out.println("连接数据库失败");
		}
	}
}
