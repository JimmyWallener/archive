package easterEgg;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class getChuckNorris {
		//this is the string that gets returned to the starting page
		String gotChuck ="";
	public String setChuck(){
	    try {
	    String sURL = "https://api.chucknorris.io/jokes/random";
	    URL url = new URL(sURL);
	    HttpURLConnection request = (HttpURLConnection) url.openConnection();
	    request.connect();
	    // Converts to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    //Convert the input stream to a json element
	    JsonElement chuck = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
	    JsonObject chuckNorris = chuck.getAsJsonObject(); //May be an array, may be an object. 
	    String chuckSays = chuckNorris.get("value").toString();
	    gotChuck = "<div class=\"chuck\"><img src=\"https://assets.chucknorris.host/img/avatar/chuck-norris.png\""  + "\" alt=\"Chuck Norris\"> "+chuckSays+"</div>";
	    }catch(Exception e) {
	    	System.out.print("Massive System failure..." + e); //Well you never know when you might need one
	    }
	    //System.out.print(gotChuck);  just a checker, did I really get it right
	    return gotChuck;
	}
	
}