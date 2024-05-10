package se.gritacademy.search.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


import se.gritacademy.search.adapter.QueryAdapter;

import se.gritacademy.search.model.DBConnection;

public class QueryController {
	

	DBConnection connection = new DBConnection();
	ArrayList<String> primaryQuery = new ArrayList<String>();
	ArrayList<String> secondaryQuery = new ArrayList<String>();
	ArrayList<String> finalProduct = new ArrayList<String>();
	
	
	
	public void firstSearch(String query,String primSelect, String Secselect) {
		
		try {
			
			Connection con = connection.initDatabase();
			
			if(con != null) {
				System.out.println("Connection Established");
			} else {
				System.out.println("No Connection");
			}
			
			//Primary Search using BOOLEAN MODE & Wildcard search operator
			PreparedStatement firstPhraseQuery = con.prepareStatement(primSelect.replaceAll("\\?", query + "*"));
			
			//Secondary Search using (NATURAL LANGUAGE default) WITH QUERY EXPANSION for doing a secondary search for words similar to Primary.
			PreparedStatement secondPhraseQuery = con.prepareStatement(Secselect.replaceAll("\\?", query));
			
			ResultSet rsOne = firstPhraseQuery.executeQuery();
			ResultSet rsTwo = secondPhraseQuery.executeQuery();
			parseResult(rsOne,rsTwo);
			
			
			rsOne.close();
			rsTwo.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	public void parseResult(ResultSet rsOne, ResultSet rsTwo) {
		
		
		try {
		
		ResultSetMetaData meta = rsOne.getMetaData();
		int columns = meta.getColumnCount();

		if(!rsOne.next()) {
				System.out.println("No Data");
			} else {
				do {
					for (int i = 1; i <= columns;i++) {
						primaryQuery.add(rsOne.getString(i));
						}
				}while (rsOne.next());
			}
		
		if(!rsTwo.next()) {
			System.out.println("No Data");
		} else {
			do {
				for (int i = 1; i <= columns;i++) {
					secondaryQuery.add(rsTwo.getString(i));
					}
			}while (rsTwo.next());
		}
			
			
			finalProduct.addAll(primaryQuery);
			finalProduct.addAll(secondaryQuery);
			
			QueryAdapter.createSearchResult(finalProduct);

			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rsOne.close();
				rsTwo.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	

}
