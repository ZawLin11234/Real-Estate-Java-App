package application.Controller;


import application.Entity.Property;
import application.Entity.PropertyListingEntity;
import application.Entity.SellerEntity;
import application.Entity.UseraccountEntity;
import application.Entity.buyListEntity;
import javafx.collections.ObservableList;

public class ViewPropertyListingsController {
	public static ObservableList<Property> retriveData() {
		PropertyListingEntity a = new PropertyListingEntity();
		ObservableList<Property> users = a.getAllPropertyListings();
		return users;
		
	}
	public static void saveProperty(String username,String profile,int id) {
		buyListEntity a = new buyListEntity();
		a.saveProperty(username, profile, id);
	}
	public static void addCount(int id) {
		SellerEntity a = new SellerEntity();
		a.addCount(id);
	}
	
}
