package application.Controller;

import application.Entity.ProfileEntity;


public class ViewUserProfileController {

	public static boolean updateUserProfile(String name,String description,String status){
		ProfileEntity a = new ProfileEntity();
		boolean result = a.updateProfile(name, description,status);
		return result;
		
	}
	
}
