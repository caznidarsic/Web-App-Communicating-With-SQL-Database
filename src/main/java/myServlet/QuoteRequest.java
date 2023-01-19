package myServlet;
import java.util.ArrayList;

public class QuoteRequest {
	private String date = null;

	private String outputMessage="";
	private boolean firstAccess = true;
	private ArrayList<Reservation> resList;
	
	
	public ArrayList<Reservation> getResList() {
		return resList;
	}
	public void setResList(ArrayList<Reservation> input) {
		 resList = new ArrayList<Reservation>(input);
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String input) {
		date = input;
	}
	
	public String getOutputMessage() {
		return outputMessage;
	}
	public void setOutputMessage(String input) {
		outputMessage = input;
	}
	
	public boolean isFirstAccess() {
		return firstAccess;
	}
	public void setFirstAccess(boolean input) {
		firstAccess = input;
	}
	
}
