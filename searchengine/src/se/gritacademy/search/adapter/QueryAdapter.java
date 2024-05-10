package se.gritacademy.search.adapter;


import java.util.List;
import java.util.Objects;

public class QueryAdapter {
	

	private static String[] fixed;
	static String newLine = "";
	
	public static void createSearchResult(List<String> list) {
		
		
		list.removeIf(Objects::isNull);
		
		
				
				
		for (String e : list) {
			newLine += e + " ";
		}
		newLine.replace("\\", "\\\\")
		          .replace("\t", "\\t")
		          .replace("\b", "\\b")
		          .replace("\n", "\\n")
		          .replace("\r", "\\r")
		          .replace("\f", "\\f")
		          .replace("\'", "\\'")
		          .replace("\"", "\\\"");
		
		setFixed(newLine.split("\\~"));
		}

	public static String[] getFixed() {
		return fixed;
	}

	public static void setFixed(String[] fixed) {
		QueryAdapter.fixed = fixed;
	}

}
