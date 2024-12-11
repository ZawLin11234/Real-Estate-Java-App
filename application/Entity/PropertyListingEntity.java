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

public class PropertyListingEntity {
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username2 = "root";
	private String password2 = "zaw123";
	
	
	public ObservableList<Property> getAllPropertyListings () {
		 
		ObservableList<Property> a =FXCollections.observableArrayList();
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL SELECT statement with placeholders
				    String sql = "SELECT * FROM propertyListings;";

				    // Create a PreparedStatement with the SQL statement
				    PreparedStatement preparedStatement = connection.prepareStatement(sql);

				    // Set the value for the parameter in the PreparedStatement
				      // Specify the username to retrieve

				    // Execute the PreparedStatement to perform the SELECT operation
				    ResultSet resultSet = preparedStatement.executeQuery();

				    // Process the ResultSet to retrieve account details
				    while (resultSet.next()) {
				    	
				    	a.add(new Property(resultSet.getInt("id"),resultSet.getString("location"),resultSet.getInt("room"),resultSet.getString("propertyType"),resultSet.getString("propertyCondition"),resultSet.getDouble("price"),resultSet.getString("username1"),resultSet.getString("username2"),resultSet.getString("status")));
				    	
				        
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
