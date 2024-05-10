package se.gritacademy.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;




public class DBHandler {

	public void addToDatabase() throws SQLException, ClassNotFoundException{
			
		
		/*
		 * Calls initiation of database from external source.
		 * Use PreparedStatement for more secure connection as counter for sql injection
		 * Add data from model and updates database, then closes connection.
		 * 
		 * */
		
		try {
			Connection con = DBConnection.initDatabase();
			
			if (con != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}
			
			PreparedStatement customer = con.prepareStatement(DatabaseModel.getCustomer());
			PreparedStatement additional = con.prepareStatement(DatabaseModel.getAdditional());
			
		
			
			customer.setString(1, Model.getName());
			customer.setString(2, Model.getSurname());
			
			additional.setString(1, Model.getAddress());
			additional.setString(2, Model.getZipcode());
			additional.setString(3, Model.getCity());
			additional.setString(4, Model.getCountry());
			
			customer.executeUpdate();
			additional.executeUpdate();
			
			customer.close();
			additional.close();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(),e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	

}
