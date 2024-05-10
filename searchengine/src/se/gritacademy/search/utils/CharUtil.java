package se.gritacademy.search.utils;


public class CharUtil {
	
	 /*
	 * Purpose is to strip searchfield from non characters and split whitespace
	 * in order to create a length list of words.
	 * The words will be used as values in search and the lenght to create dynamic values to prepareStatement
	 * 
	 * */
	static String sentence;
	
	public static String destructureString(String string) {
		
		sentence = string;
		sentence.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(sentence);
		return sentence;
		
	}
	
}
