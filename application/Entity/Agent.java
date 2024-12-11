package application.Entity;

public class Agent extends Useraccount{

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(String username, String password, String name, String email, String phone_number, String agency_name,
			String license_number) {
		this.setUsername(username);
		this.setEmail(email);
		this.setPassword(password);
		this.setName(name);
		this.setPhone_number(phone_number);
		this.setLicense_number(license_number);
		this.setStatus("Active");
		this.setProfile("Agent");
		this.setAgency_name(agency_name);
	}

}
