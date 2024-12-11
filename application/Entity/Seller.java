package application.Entity;

public class Seller extends Useraccount{

	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(String username, String password, String name, String email, String phone_number) {
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setPhone_number(phone_number);
		this.setLicense_number(null);
		this.setStatus("Active");
		this.setProfile("Seller");
		this.setAgency_name(null);
	}

}
