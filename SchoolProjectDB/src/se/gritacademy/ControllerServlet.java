package se.gritacademy;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.gritacademy.model.DBHandler;
import se.gritacademy.model.Model;




/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControllerServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Data successfully added to Database");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		
		
		Model.setName(request.getParameter("name").strip());
		Model.setSurname(request.getParameter("surname").strip());
		Model.setAddress(request.getParameter("address").strip());
		Model.setZipcode(request.getParameter("zipcode").strip());
		Model.setCity(request.getParameter("city").strip());
		Model.setCountry(request.getParameter("country").strip());
		
		DBHandler handler = new DBHandler();
		try {
			handler.addToDatabase();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
