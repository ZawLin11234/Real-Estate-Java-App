package application.Controller;

import application.Entity.Profile;
import application.Entity.ProfileEntity;
import application.Entity.Useraccount;
import application.Entity.UseraccountEntity;
import javafx.collections.ObservableList;

public class manageUserProfileController {

	public static ObservableList<Profile> retriveData() {
		ProfileEntity a = new ProfileEntity();
		ObservableList<Profile> users = a.getProfiles();
		return users;
		
	}
	
}
