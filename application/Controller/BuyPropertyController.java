package application.Controller;

import java.text.DecimalFormat;

import application.Entity.MortgageCalculator;
import application.Entity.Property;
import application.Entity.PropertyListingEntity;
import javafx.collections.ObservableList;

public class BuyPropertyController {

	
	public static ObservableList<Property> retriveData() {
		PropertyListingEntity a = new PropertyListingEntity();
		ObservableList<Property> properties = a.getAllPropertyListings();
		return properties;
	}
	public static double calculateMortgage(double price,int year) {
		double mortgageAmount = MortgageCalculator.calculateMortgage(price, year);

		return mortgageAmount;

	}
}
