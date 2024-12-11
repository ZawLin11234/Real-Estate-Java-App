package application.Entity;

public class Profile {

	private String name = "null";
	private String description = "null";
	private String status = "null";
	
	public Profile() {
		
	}
	
	public Profile(String name, String description, String status) {
		
		this.name = name;
		this.description = description;
		this.status = status;
		
	}
	
	//Get values
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getStatus() {
		return status;
	}
	
	//Set values
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}