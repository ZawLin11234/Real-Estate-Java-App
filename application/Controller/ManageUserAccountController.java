package application.Controller;

import application.Entity.Useraccount;
import application.Entity.UseraccountEntity;
import javafx.collections.ObservableList;

public class ManageUserAccountController {
	public static ObservableList<Useraccount> retriveData() {
		UseraccountEntity a = new UseraccountEntity();
		ObservableList<Useraccount> users = a.getUsers();
		return users;
		
	}
}
