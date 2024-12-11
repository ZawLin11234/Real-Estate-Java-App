package application.Entity;


public class Property {
	private int propertyId = 0;
	private String location = "null";
	private int room = 0;
	private String propertyType = "null";
	private String condition = "null";
	private double price = 0;
	private String agent = "null";
	private String seller = "null";
	private String status = "null";
	
	public Property() {
		
	}
	
	public Property(int propertyId,String location, int room, String propertyType, String condition, double price, String agent, String seller, String status) {
		
		this.propertyId = propertyId;
		this.location = location;
		this.room = room;
		this.propertyType = propertyType;
		this.condition = condition;
		this.price = price;
		this.agent = agent;
		this.seller = seller;
		this.status = status;
		
		
	}
	
	//Get values
	
	public String getLocation() {
		return location;
	}
	
	public int getPropertyId() {
		return propertyId;
	}

	public int getRoom() {
		return room;
	}
	
	public String getPropertyType() {
		return propertyType;
	}
	
	public String getCondition() {
		return condition;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getAgent() {
		return agent;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public String getStatus() {
		return status;
	}
	
	//Set values
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
