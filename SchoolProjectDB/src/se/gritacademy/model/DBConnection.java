package se.gritacademy.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	protected static Connection initDatabase() throws SQLException, ClassNotFoundException {
		
		// Create a connection to db and gets credentials from model
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = DatabaseModel.getDburl();
		String timezone = "?useLegacyDatetimeCode=false&serverTimezone=Europe/Stockholm";
		String dbName = DatabaseModel.getDbname();
		String dbUsername = DatabaseModel.getUname();
		String dbPassword = DatabaseModel.getPword();
		
		
		
		Class.forName(dbDriver);
		Connection connection = DriverManager.getConnection(dbURL + dbName + timezone, dbUsername, dbPassword);
		return connection;
	}

}
