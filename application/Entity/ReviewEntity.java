package application.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewEntity {
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username3 = "root";
	private String password2 = "zaw123";
	
	public boolean createReview (int star, String review, String username1, String profile1, String username2, String profile2) {
	 
	 int rowsAffected = 0;
	 
	 try {
         Connection connection = DriverManager.getConnection(url, username3, password2);
         
         // Use this connection to execute queries
         // connection.createStatement()...
         Statement statement = null;

         try {
             statement = connection.createStatement();

             String insert = "INSERT INTO review (star, review, username1, profile1, username2, profile2) VALUES ('" 
             + star + "', '" + review + "', '" + username1 + "', '" + profile1 + "', '" 
             + username2 + "', '" + profile2 + "');";
             
             rowsAffected = statement.executeUpdate(insert); 
             
		 } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
             // Close the statement in the finally block
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         }
	 } catch (SQLException e) {
     System.out.println("Connection failed!");
     e.printStackTrace();
	 }
	 
	 if (rowsAffected > 0) {
         return true;
     } else {
         return false;
     }
 }
	
}
