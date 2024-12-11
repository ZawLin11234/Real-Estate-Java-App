package application.Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class Useraccount {
	
	private String username = "null";
	private String password = "null";
	private String name = "null";
	private String email = "null";
	private String phone_number = "null";
	private String agency_name = "null";
	private String license_number = "null";
	private String profile = "null";
	private String status = "null";
	
	public Useraccount() {
		
	}
	
	public Useraccount(String username, String password, String name, 
			String email, String phone_number, String agency_name, 
			String license_number, String profile, String status) {
		
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.agency_name = agency_name;
		this.license_number = license_number;
		this.profile = profile;
		this.status = status;
		
	}
	
	//Get values
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	
	public String getAgency_name() {
		return agency_name;
	}
	
	public String getLicense_number() {
		return license_number;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public String getStatus() {
		return status;
	}
	
	//Set values
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	
	public void setLicense_number(String license_number) {
		this.license_number = license_number;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
