package application.Controller;

import application.Entity.Useraccount;
import application.Entity.UseraccountEntity;
import javafx.collections.ObservableList;

public class RateAgentMenuController {

	public static ObservableList<Useraccount> retrieveAgents() {
		UseraccountEntity a = new UseraccountEntity();
		ObservableList<Useraccount> users = a.getAgents();
		return users;
		
	}
	
}
