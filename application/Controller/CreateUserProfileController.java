package application.Controller;

import application.Entity.ProfileEntity;
import application.Entity.UseraccountEntity;

public class CreateUserProfileController {

	public static boolean createProfile(String name, String description,String status) {
		ProfileEntity a = new ProfileEntity();
		boolean result = a.createProfile(name, description,status);
		return result;
	}
	
}
