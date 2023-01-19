package myServlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;



/*
 * Christian Znidarsic
 * hikeQuoteGenerator Class
 * 
 * The hikeQuoteGenerator class extends HttpServlet. It receives HTTP 
 * requests from the client and uses the AccessDatabase class to update 
 * the QuoteRequest bean accordingly. It then passes control to main.jsp 
 * to send an HTTP response to the client.
 */

/**
 * Servlet implementation class hikeQuoteGenerator
 */
@WebServlet("/hikeQuoteGenerator")
public class hikeQuoteGenerator extends HttpServlet {
	public static final String QUOTEREQUEST = "quoteRequest";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ServletContext servletContext = getServletContext();
		QuoteRequest quoteRequest = (QuoteRequest) session.getAttribute(QUOTEREQUEST);
		if (quoteRequest == null) {
			quoteRequest = new QuoteRequest();
			
			session.setAttribute(QUOTEREQUEST, quoteRequest);
		}
		else {
			// initialize the input variables
			String inputDate = request.getParameter("Date");
			
			if (inputDate != null) {
				if (!inputDate.matches("^\\d\\d\\d\\d\\-\\d\\d\\-\\d\\d$")) {
					quoteRequest.setOutputMessage("The date is formatted incorrectly. Proper format is: \"YYYY-MM-DD\"");
        		}
				else if (Integer.parseInt(inputDate.substring(0, 4)) > 2100) {
					quoteRequest.setOutputMessage("The year is out of valid range.");
				}
				else if (Integer.parseInt(inputDate.substring(5, 7)) > 12) {
					quoteRequest.setOutputMessage("The month is out of valid range.");
				}
				else if (Integer.parseInt(inputDate.substring(8, 10)) > 31) {
					quoteRequest.setOutputMessage("The day is out of valid range.");
				}
        		else {
        			// update values in QuoteRequest object
        			quoteRequest.setDate(inputDate);
        			quoteRequest.setOutputMessage("VALID");
        	    	ArrayList<Reservation> resList = new ArrayList<Reservation>(AccessDatabase.accessDatabase(inputDate));
        	    	quoteRequest.setResList(resList);
        		}
			}
			else {
				quoteRequest.setOutputMessage("Inputs are missing. Missing inputs: \"Date\"");
			}
			quoteRequest.setFirstAccess(false);
			
		}
		RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/main.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
