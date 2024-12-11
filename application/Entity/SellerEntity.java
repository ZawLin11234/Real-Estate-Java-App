package application.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SellerEntity {
	
	private String url = "jdbc:mysql://localhost:3306/AccountInfo";
	private String username2 = "root";
	private String password2 = "zaw123";

	public int shortlistCount (int id) {
	     
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
	             String query = "SELECT * FROM buyList WHERE id = '" + id + "';";
	             
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
	     return count;
	 }
	
	public int checkCount (int id) {
	     
		 int count = 0;
		 int count2 = 0;
	     
	     try {
	         Connection connection = DriverManager.getConnection(url, username2, password2);
	         
	         // Use this connection to execute queries
	         // connection.createStatement()...
	         Statement statement = null;
	         ResultSet resultSet = null;

	         try {
	             statement = connection.createStatement();

	             // SQL query to select all data from the DOCTOR table
	             String query = "SELECT count FROM viewCount WHERE id = '" + id + "';";
	             
	             resultSet = statement.executeQuery(query);

	             // Process each row in the result set
	             
	             while (resultSet.next()) {
	                
	                 // Process the retrieved data (you can print it or perform other operations)
	            	 count2 = resultSet.getInt("count");
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
	    	 return -1;
	     } else {
	    	 return count2;
	     }
	 }
	
	public boolean createCount (int id, int count) {
		 
		 int rowsAffected = 0;
		 
		 try {
	         Connection connection = DriverManager.getConnection(url, username2, password2);
	         
	         // Use this connection to execute queries
	         // connection.createStatement()...
	         Statement statement = null;

	         try {
	             statement = connection.createStatement();

	             String insert = "INSERT INTO viewCount (id, count) VALUES ('" 
	             + id + "', '" + count + "');";
	             
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
	
	public boolean updateCount (int id, int count) {
		 
		 int rowsAffected = 0;
		 
		 try {
			 Connection connection = DriverManager.getConnection(url, username2, password2);
			 
			 try {
				// Define the SQL UPDATE statement with placeholders
				String sql = "UPDATE viewCount SET count = ? WHERE id = ? ;";
				
				// Create a PreparedStatement with the SQL statement
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				// Set new password and username for the update operation
				preparedStatement.setInt(1, count);         
	            preparedStatement.setInt(2, id);    
	            
	            
				
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
	
	public void addCount (int id) {
		int count = checkCount(id);
		if (count==-1) {
			createCount(id, 1);
		} else {
			updateCount(id, count+1);
		}
	}
	
	
}
