package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfigDAO {
	
	private String url;
	private String username;
	private String password;
	
	private DbConfigDAO(String url, String username, String password) {
		
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DbConfigDAO getInstance() {
		DbConfigDAO instance=null;
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username="root";
			String password="";
			//connexion a bd:
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance=new DbConfigDAO(url, username, password);
		return instance;
	}
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
