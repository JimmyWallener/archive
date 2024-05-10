package se.gritacademy.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.gritacademy.search.Controller.QueryController;
import se.gritacademy.search.adapter.QueryAdapter;
import se.gritacademy.search.model.Model;
import se.gritacademy.search.utils.CharUtil;







/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] resultQuery;
    /**
     * Default constructor. 
     */
    public ControllerServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String phrase = request.getParameter("search");
		QueryController qC = new QueryController();
		Model model = new Model();
		
		// Initiating search query
		qC.firstSearch(CharUtil.destructureString(phrase), model.getprimaryQuery(), model.getSecquery());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
		
		// Output in HTML with forEach Loop on String Array.
		
		try {
			
			
			out.print("<div style=\"margin:0 100px;margin-right: 100px\">");
			out.print("<ol>");
			for(String e : QueryAdapter.getFixed()) {
				out.print("<li> " + e + "</><br>");
			}
			out.print("</ol>");
			out.print("</div>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		}
		


}
