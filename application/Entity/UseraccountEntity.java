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


public class UseraccountEntity {
	
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username2 = "root";
	private String password2 = "zaw123";
	
 public boolean checkLogin (String username, String password, String profile) {
     
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
             String query = "SELECT username FROM Accounts WHERE username = '" + username + "' AND password = '" + password + "' AND profile = '" + profile + "' AND status = 'active';";
             
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
 
 public boolean checkUsername (String username) {
    
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
             String query = "SELECT username FROM Accounts WHERE username = '" + username + "';";
             
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
 
 public boolean createAccount (String username, String password, String name, 
			String email, String phone_number, String agency_name, 
			String license_number, String profile, String status) {
	 
	 boolean result = checkUsername (username);
	 
	 if (result == false) {
		 
		 int rowsAffected = 0;
		 
		 try {
	         Connection connection = DriverManager.getConnection(url, username2, password2);
	         
	         // Use this connection to execute queries
	         // connection.createStatement()...
	         Statement statement = null;

	         try {
	             statement = connection.createStatement();

	             String insert = "INSERT INTO Accounts (username, password, name, email, phone_number, agency_name, license_number, profile, status) VALUES ('" 
	             + username + "', '" + password + "', '" + name + "', '" + email + "', '" 
	             + phone_number + "', '" + agency_name + "', '" + license_number + "', '" + profile + "', '" + status + "');";
	             
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
 
 public boolean updateAccount (String username, String password, String name, 
			String email, String phone_number, String agency_name, 
			String license_number, String profile, String status) {
	 
	 int rowsAffected = 0;
	 
	 try {
		 Connection connection = DriverManager.getConnection(url, username2, password2);
		 
		 try {
			// Define the SQL UPDATE statement with placeholders
			String sql = "UPDATE Accounts SET password = ?, name = ?, email = ?, phone_number = ?, agency_name = ?, license_number = ?, status = ? WHERE username = ? AND profile = ?;";
			
			// Create a PreparedStatement with the SQL statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			// Set new password and username for the update operation
			preparedStatement.setString(1, password);         
            preparedStatement.setString(2, name);             
            preparedStatement.setString(3, email);            
            preparedStatement.setString(4, phone_number);     
            preparedStatement.setString(5, agency_name);      
            preparedStatement.setString(6, license_number);
            preparedStatement.setString(7, status);
            preparedStatement.setString(8, username);     
            preparedStatement.setString(9, profile);      
			
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
 
 public Useraccount getUser (String username) {
	 
	 Useraccount a = new Useraccount();
	 
	 try {
		 Connection connection = DriverManager.getConnection(url, username2, password2);
		 
		 try {
			// Define the SQL SELECT statement with placeholders
			    String sql = "SELECT * FROM Accounts WHERE username = ?";

			    // Create a PreparedStatement with the SQL statement
			    PreparedStatement preparedStatement = connection.prepareStatement(sql);

			    // Set the value for the parameter in the PreparedStatement
			    String targetUsername = username;
			    preparedStatement.setString(1, targetUsername);  // Specify the username to retrieve

			    // Execute the PreparedStatement to perform the SELECT operation
			    ResultSet resultSet = preparedStatement.executeQuery();

			    // Process the ResultSet to retrieve account details
			    if (resultSet.next()) {
			    	
			    	a.setUsername(resultSet.getString("username"));
			    	a.setPassword(resultSet.getString("password"));
			    	a.setName(resultSet.getString("name"));
			        a.setEmail(resultSet.getString("email"));
			        a.setPhone_number(resultSet.getString("phone_number"));
			        a.setAgency_name(resultSet.getString("agency_name"));
			        a.setLicense_number(resultSet.getString("license_number"));
			        a.setProfile(resultSet.getString("profile"));
			        a.setStatus(resultSet.getString("status"));
			    	
			    } else {
			        System.out.println("Account with username " + targetUsername + " not found.");
			        
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
 
public ObservableList<Useraccount> getUsers () {
	 
	ObservableList<Useraccount> a =FXCollections.observableArrayList();
	 
	 try {
		 Connection connection = DriverManager.getConnection(url, username2, password2);
		 
		 try {
			// Define the SQL SELECT statement with placeholders
			    String sql = "SELECT * FROM Accounts;";

			    // Create a PreparedStatement with the SQL statement
			    PreparedStatement preparedStatement = connection.prepareStatement(sql);

			    // Set the value for the parameter in the PreparedStatement
			      // Specify the username to retrieve

			    // Execute the PreparedStatement to perform the SELECT operation
			    ResultSet resultSet = preparedStatement.executeQuery();

			    // Process the ResultSet to retrieve account details
			    while (resultSet.next()) {
			    	
			    	a.add(new Useraccount (resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("phone_number"),resultSet.getString("agency_name"),resultSet.getString("license_number"),resultSet.getString("profile"),resultSet.getString("status")));
			    	
			        
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


public ObservableList<Useraccount> getAgents () {
	 
	ObservableList<Useraccount> a =FXCollections.observableArrayList();
	 
	 try {
		 Connection connection = DriverManager.getConnection(url, username2, password2);
		 
		 try {
			// Define the SQL SELECT statement with placeholders
			    String sql = "SELECT * FROM Accounts WHERE profile = 'Agent';";

			    // Create a PreparedStatement with the SQL statement
			    PreparedStatement preparedStatement = connection.prepareStatement(sql);

			    // Set the value for the parameter in the PreparedStatement
			      // Specify the username to retrieve

			    // Execute the PreparedStatement to perform the SELECT operation
			    ResultSet resultSet = preparedStatement.executeQuery();

			    // Process the ResultSet to retrieve account details
			    while (resultSet.next()) {
			    	
			    	a.add(new Useraccount (resultSet.getString("username"),resultSet.getString("password"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("phone_number"),resultSet.getString("agency_name"),resultSet.getString("license_number"),resultSet.getString("profile"),resultSet.getString("status")));
			    	
			        
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