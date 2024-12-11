package application.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileEntity {
	
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username2 = "root";
	private String password2 = "zaw123";
	
	public boolean checkProfile (String name) {
	    
	     int count = 0;

	     try {
	         Connection connection = DriverManager.getConnection(url, username2, password2);
	         
	         // Use this connection to execute queries
	         // connection.createStatement()...
	         Statement statement = null;
	         ResultSet resultSet = null;
	         
	         try {
	             statement = connection.createStatement();

	             // SQL query to select all data from the DOCTOR table
	             String query = "SELECT name FROM Profiles WHERE name = '" + name + "';";
	             
	             resultSet = statement.executeQuery(query);

	             // Process each row in the result set
	             
	             while (resultSet.next()) {

	                 // Process the retrieved data (you can print it or perform other operations)
	             
	                 count++;
	             }       
	         } catch (SQLException e) {
	             e.printStackTrace();
	         } finally {
	             // Close the result set and statement in the finally block
	             if (resultSet != null) {
	                 try {
	                     resultSet.close();
	                 } catch (SQLException e) {
	                     e.printStackTrace();
	                 }
	             }
	             if (statement != null) {
	                 try {
	                     statement.close();
	                 } catch (SQLException e) {
	                     e.printStackTrace();
	                 }
	             }
	         }
	         connection.close(); // Remember to close the connection
	     } catch (SQLException e) {
	         System.out.println("Connection failed!");
	         e.printStackTrace();
	     }
	     if (count==0) {
	    	 return false;
	     } else {
	    	 return true;
	     }
	 }
	 
	 public boolean createProfile (String name, String description, String status) {
		 
		 boolean result = checkProfile (name);
		 
		 if (result == false) {
			 
			 int rowsAffected = 0;
			 
			 try {
		         Connection connection = DriverManager.getConnection(url, username2, password2);
		         
		         // Use this connection to execute queries
		         // connection.createStatement()...
		         Statement statement = null;

		         try {
		             statement = connection.createStatement();

		             String insert = "INSERT INTO Profiles (name, description, status) VALUES ('" 
		             + name + "', '" + description + "', '" + status + "');";
		             
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
		 } else {
			 return false;
		 }
	 }
	 
	 public boolean updateProfile (String name, String description, String status) {
		 
		 int rowsAffected = 0;
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL UPDATE statement with placeholders
				String sql = "UPDATE Profiles SET description = ? , status = ? WHERE name = ? ;";
				
				// Create a PreparedStatement with the SQL statement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				// Set new password and username for the update operation
				preparedStatement.setString(1, description);         
	            preparedStatement.setString(2, status);    
	            preparedStatement.setString(3, name);
	            
				
				// Execute the PreparedStatement to perform the update
				rowsAffected = preparedStatement.executeUpdate();
				
				
			 } catch (SQLException e) {
		         e.printStackTrace();
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
	 
	 public Profile getProfile (String name) {
		 
		 Profile a = new Profile();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT * FROM Profiles WHERE name = ?";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				    
				    preparedStatement.setString(1, name);  // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    if (resultSet.next()) {
				    	
				    	
				    	a.setName(resultSet.getString("name"));
				    	a.setDescription(resultSet.getString("description"));
				    	a.setStatus(resultSet.getString("status"));
				    	
				    
				    	
				    } else {
				        System.out.println("Account with username " + name + " not found.");
				        
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
	 
	public ObservableList <Profile> getProfiles () {
		 
		 ObservableList <Profile> a = FXCollections.observableArrayList();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT * FROM Profiles;";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				      // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    while (resultSet.next()) {
				    	
				    	a.add(new Profile (resultSet.getString("name"),resultSet.getString("description"),resultSet.getString("status")));
				    	
				        
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
}
