package application.Controller;

import application.Entity.UseraccountEntity;
import javafx.collections.ObservableList;

public class ViewDetailedAdminController {
	
	
	
	public static boolean updateAdminAccount(String username, String password, String name, String email, String phone_number, String agency_name, 
			String license_number, String profile, String status){
		UseraccountEntity a = new UseraccountEntity();
		boolean result = a.updateAccount(username, password, name, email, phone_number, agency_name, license_number, profile, status);
		return result;
		
	}
	public static boolean deactivate(String username, String password, String name, String email, String phone_number, String agency_name, 
			String license_number, String profile, String status){
		UseraccountEntity a = new UseraccountEntity();
		boolean result = a.updateAccount(username, password, name, email, phone_number, agency_name, license_number, profile, "Deactivate");
		return result;
		
	}
	
	
}
