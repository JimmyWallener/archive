package API;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class getStations
 */
@WebServlet("/getStations")
public class getStations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getStations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Your trips").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
		
		String search = "http://www.labs.skanetrafiken.se/v2.2/resultspage.asp?cmdaction=next&selPointFr=|" + from +"|0&selPointTo=|" + to + "|0";
		 out.print("<!DOCTYPE html>\r\n" + 
	        		"<html>\r\n" + 
	        		"<head>\r\n" + 
	        		"<meta charset=\"UTF-8\">\r\n" + 
	        		"<link rel=\"stylesheet\" href=\"Style.css\" type=\"text/css\">\r\n" + 
			   	    "<link rel=\"stylesheet\"href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">" +

	        		"<title>Travel</title>\r\n" + 
	        		"</head>\r\n" + 
	        		"<body>");
	        out.print("<div class='header'>\r\n" + 
	        		"		<h1>Transportation Schedule</h1>\r\n" + 
	        		"		<h3>Home of Sustainable Travel | Start your journey now‎.</h3>\r\n" + 
	        		"	</div>\r\n" + 
	        		"	<div class=\"topnav\">\r\n" + 
	        		"		<a href=\"#\">Home</a> <a href=\"#\">Plan a journey</a> <a href=\"#\">Status\r\n" + 
	        		"			updates</a> <a href=\"#\">Maps</a>\r\n" + 
	        		"	</div>\r\n");
		try {
			//Gets info from skanestrafiken
			//System.out.println(search);
			Document doc = getTravelplan.loadTestDocument(search);
	       
			
			NodeList nodeList = doc.getElementsByTagName("Journey");
			//Error handling it user does not enter a correct station from list
			if (nodeList.getLength() == 0){
		    	out.println("<br>");
		    	out.println("<p class='center'>Something went wrong, please try again and make sure that your selection is correct</p>");
		    	out.println("<br>	<br>	<br>	<br>	<br>	<br> 	<br>	<br>	<br>	<br>	<br>	<br>"
		    			+ "	 <br>	<br>	<br>	<br>	<br>");
		    } 
			for (int temp = 0; temp < nodeList.getLength(); temp++) {
			    org.w3c.dom.Node node = nodeList.item(temp);
			    out.println("<div class='main'>");
			    out.println("\nSuggestion: " + (temp +1));
			    
			    // print selected journeys on page
			    if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
			        Element element = (Element) node;
			        String DepDateTime = element.getElementsByTagName("DepDateTime").item(0).getTextContent();
			        String ArrDateTime = element.getElementsByTagName("ArrDateTime").item(0).getTextContent();
			        String NewDepPoint = element.getElementsByTagName("NewDepPoint").item(0).getTextContent();
			        String LineTypeName = element.getElementsByTagName("LineTypeName").item(0).getTextContent();
			        String Towards = element.getElementsByTagName("Towards").item(0).getTextContent();
			       
			        out.println("<br>");
			        out.println("\nDepartue Time " + DepDateTime.substring(11, 16));
			        out.println("<br>");
			        out.println("\nArrival Time: " + ArrDateTime.substring(11, 16));
			        out.println("<br>");
			        out.println("\nPlatform: " + NewDepPoint);
			        out.println("<br>");
			        out.println("\nWith: " + LineTypeName);
			        out.println("<br>");
			        out.println("\nTowards: " + Towards);
			        out.println("<br>");
			        out.println("<br>");
			        out.println("</div>");
			        
			    } 
			}
		}catch(Exception exception)
	    {
	        exception.printStackTrace();    
	    }
		// Calls start page for a new search(or joke)
		out.println("<br>"
				+ "  <br>"
				+ "</div>"
				+ "<div>");
		
		out.print("<input type=\"button\" class=\"myButton\" value=\"Search again\" onclick=\"window.location='index.jsp'\">");
		out.println("	<div class=\"footer\">\r\n" + 
        		"		<p>Follow Us</p> \r\n" + 
		"<a href=\"#\" class=\"fa fa-facebook\"></a>"+
		"<a href=\"#\" class=\"fa fa-twitter\"></a>"+
		"<a href=\"#\" class=\"fa fa-google\"></a>"+
		"<a href=\"#\" class=\"fa fa-linkedin\"></a>"+
		"<a href=\"#\" class=\"fa fa-youtube\"></a>"+
		"<a href=\"#\" class=\"fa fa-instagram\"></a>"+
		
        		"	</div>"
        		+ "</body>\r\n" + 
        		"</html>");
		out.close();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

} 

