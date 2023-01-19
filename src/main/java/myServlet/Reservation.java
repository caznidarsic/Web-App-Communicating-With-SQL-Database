package myServlet;

public class Reservation {
	private String idreservation;
	private String reservation_First;
	private String reservation_Last;
	private String StartDay;
	private String NumberOfDays;
	private String guide_First;
	private String guide_Last;
	private String location;
	
	public Reservation(String _idreservation, String _reservation_First, String _reservation_Last, 
						String _StartDay, String _NumberOfDays, String _guide_First, 
						String _guide_Last, String _location) {
		idreservation = _idreservation;
		reservation_First = _reservation_First;
		reservation_Last = _reservation_Last;
		StartDay = _StartDay;
		NumberOfDays = _NumberOfDays;
		guide_First = _guide_First;
		guide_Last = _guide_Last;
		location = _location;
	}
	
	public String getIdreservation() {
		return idreservation;
	}
	public void setIdreservation(String idreservation) {
		this.idreservation = idreservation;
	}
	public String getReservation_First() {
		return reservation_First;
	}
	public void setReservation_First(String reservation_First) {
		this.reservation_First = reservation_First;
	}
	public String getReservation_Last() {
		return reservation_Last;
	}
	public void setReservation_Last(String reservation_Last) {
		this.reservation_Last = reservation_Last;
	}
	public String getStartDay() {
		return StartDay;
	}
	public void setStartDay(String startDay) {
		StartDay = startDay;
	}
	public String getNumberOfDays() {
		return NumberOfDays;
	}
	public void setNumberOfDays(String numberOfDays) {
		NumberOfDays = numberOfDays;
	}
	public String getGuide_First() {
		return guide_First;
	}
	public void setGuide_First(String guide_First) {
		this.guide_First = guide_First;
	}
	public String getGuide_Last() {
		return guide_Last;
	}
	public void setGuide_Last(String guide_Last) {
		this.guide_Last = guide_Last;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
