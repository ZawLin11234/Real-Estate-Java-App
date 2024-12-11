package application.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class buyListEntity {

	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username2 = "root";
	private String password2 = "zaw123";
	
	public ArrayList <Integer> getBuyList (String username, String profile) {
		 
		ArrayList<Integer> a = new ArrayList<>();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT id FROM buyList WHERE username = '" + username + "' AND profile = '" + profile + "';";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				      // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    while (resultSet.next()) {
				    	
				    	a.add(resultSet.getInt("id"));
				    	
				        
				    } 
				    
				
			 } catch (SQLException e) {
		         e.printStackTrace();
		     } 
	         
		 } catch (SQLException e) {
	         System.out.println("Connection failed!");
	         e.printStackTrace();
		 }
		 return a;
	 }
	
	public boolean saveProperty (String username, String profile, int id) {
		 
		int rowsAffected = 0;
	 
		 try {
		     Connection connection = DriverManager.getConnection(url, username2, password2);
		     
		     // Use this connection to execute queries
		 // connection.createStatement()...
		 Statement statement = null;
		
		 try {
		     statement = connection.createStatement();
		
		     String insert = "INSERT INTO buyList (username, profile, id) VALUES ('" + username + "', '" + profile + "', '" + id + "');";
		     
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
	public boolean deleteProperty (String username, String profile, int id) {
		 
		int rowsAffected = 0;
	 
		 try {
		     Connection connection = DriverManager.getConnection(url, username2, password2);
		     
		     // Use this connection to execute queries
		 // connection.createStatement()...
		 Statement statement = null;
		
		 try {
		     statement = connection.createStatement();
		
		     String delete = "DELETE FROM buyList WHERE username = '" + username + "' AND profile = '" + profile + "' AND id = '" + id + "';";
		     
		     rowsAffected = statement.executeUpdate(delete); 
		     
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
