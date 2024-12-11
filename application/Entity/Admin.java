package application.Entity;

public class Admin extends Useraccount {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String name, String email) {
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setPhone_number(null);
		this.setLicense_number(null);
		this.setStatus("Active");
		this.setProfile("Admin");
		this.setAgency_name(null);
	}

}
