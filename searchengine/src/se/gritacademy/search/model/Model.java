package se.gritacademy.search.model;

public class Model {
	
	final private String primaryQuery = "SELECT *,null,null,null,null,null,null,null,null,null,null,null,null,null FROM bearbase WHERE MATCH (names,Creator,Origin,Notes) AGAINST ( '+?' IN BOOLEAN MODE) "
											+ "UNION ALL "
											+ "SELECT *,null,null,null,null,null,null,null,null,null,null,null,null " +
											"FROM ikea_names "
											+ "WHERE MATCH (name,description,Column_3,Column_4,Column_5) AGAINST ( '+?' IN BOOLEAN MODE) "
											+ "UNION ALL "
											+ "SELECT * FROM masterscplist " + 
											"WHERE MATCH (SCP,Title,rating,Classification,Type,Related_GOI_s,Location_Notes,Author,Leaked_info,Humanoid_or_Structure,Animal_Computer_or_Extradimensional," +
											"Autonomous_or_Cognitohazard,Artifact_Location_or_Sentient,Summary,Gender,Ethnicity_Origins) AGAINST ( '+?' IN BOOLEAN MODE)";
	
	final private String secQuery = "SELECT *,null,null,null,null,null,null,null,null,null,null,null,null,null FROM bearbase WHERE MATCH (names,Creator,Origin,Notes) AGAINST ( '?' WITH QUERY EXPANSION) "
											+ "UNION ALL "
											+ "SELECT *,null,null,null,null,null,null,null,null,null,null,null,null " +
											"FROM ikea_names "
											+ "WHERE MATCH (name,description,Column_3,Column_4,Column_5) AGAINST ( '?' WITH QUERY EXPANSION) "
											+ "UNION ALL "
											+ "SELECT * FROM masterscplist " + 
											"WHERE MATCH (SCP,Title,rating,Classification,Type,Related_GOI_s,Location_Notes,Author,Leaked_info,Humanoid_or_Structure,Animal_Computer_or_Extradimensional," +
											"Autonomous_or_Cognitohazard,Artifact_Location_or_Sentient,Summary,Gender,Ethnicity_Origins) AGAINST ( '?' WITH QUERY EXPANSION)";
	

	public String getprimaryQuery() {
		return primaryQuery;
	}


	public String getSecquery() {
		return secQuery;
	}


}
