package application.Controller;

import application.Entity.UseraccountEntity;

public class CreateUserAccountSellerController {

	public static boolean createSellerAccount(String username, String password, String name, 
			String email, String phone_number, String agency_name, 
			String license_number, String profile, String status) {
		UseraccountEntity a = new UseraccountEntity();
		boolean result = a.createAccount(username, password, name, email, phone_number, agency_name, license_number, profile, status);
		return result;
	}
	
}
