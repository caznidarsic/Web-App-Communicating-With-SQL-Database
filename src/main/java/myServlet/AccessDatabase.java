package myServlet;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccessDatabase {
	private final static String url="jdbc:mysql://web6.jhuep.com:3306/";
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private final static String user = "johncolter";
	private final static String pass = "LetMeIn";
	private final static String db="class";
    private final static String options="?useSSL=false";
    
    public static ArrayList<Reservation> accessDatabase(String startDate) {
    	ArrayList<Reservation> resultList = new ArrayList<Reservation>();
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch (ClassNotFoundException e) {
    		
    	}
    	
    	 try (
    			 Connection conn = DriverManager.getConnection(url + db + options, user, pass);
    			 Statement statement = conn.createStatement()) {
    		 String query = "SELECT reservation.idreservation, reservation.First as reservation_First, reservation.Last as reservation_Last, reservation.StartDay, reservation.NumberOfDays, "
    		 		+ "guides.First as guide_First, guides.Last as guide_Last, "
    		 		+ "locations.location "
    		 		+ "FROM reservation "
    		 		+ "JOIN guides "
    		 		+ "ON reservation.guide=guides.idguides "
    		 		+ "JOIN locations "
    		 		+ "ON reservation.location=locations.idlocations "
    		 		+ "WHERE StartDay >= '" + startDate + "' "
    		 		+ "ORDER BY StartDay";
             ResultSet resultSet = statement.executeQuery(query);
             
             while (resultSet.next()) {
            	 resultList.add(new Reservation(resultSet.getString("idreservation"), resultSet.getString("reservation_First"), resultSet.getString("reservation_Last"), resultSet.getString("StartDay"), resultSet.getString("NumberOfDays"), resultSet.getString("guide_First"), resultSet.getString("guide_Last"), resultSet.getString("location")));
             }

             resultSet.close();

    	 } catch (SQLException e) {
			e.printStackTrace();
    	 }
    	 
    	 return resultList;
    	 
    }
}