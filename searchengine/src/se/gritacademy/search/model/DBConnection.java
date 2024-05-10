package se.gritacademy.search.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection initDatabase() {
		
		// Create a connection to db and gets credentials from model
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = DatabaseModel.getDburl();
		String timezone = "?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
		String dbName = DatabaseModel.getDbname();
		String dbUsername = DatabaseModel.getUname();
		String dbPassword = DatabaseModel.getPword();
		Connection connection = null;
		
		
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbURL + dbName + timezone, dbUsername, dbPassword);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

}
