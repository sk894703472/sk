package edu.ec.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_ec","root","123321");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		catch(ClassNotFoundException el){
			el.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		JdbcUtils jdbc = new JdbcUtils();
		Connection conn = jdbc.getConn();
		System.out.print(conn);
	}
}

