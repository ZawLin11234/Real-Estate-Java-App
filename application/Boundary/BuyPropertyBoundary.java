package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.BuyPropertyController;
import application.Controller.ManageUserAccountController;
import application.Entity.IdPass;
import application.Entity.ObjectPass;
import application.Entity.Property;
import application.Entity.Useraccount;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BuyPropertyBoundary implements Initializable {

	
	@FXML
    private Label amountLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label interestLabel;

    @FXML
    private TextField monthTextField;

    @FXML
    private Label priceLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Button updateButton;
    
    ObservableList<Property> array1 = BuyPropertyController.retriveData();
	
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("viewPropertyListing.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Property displayProperty;
		for(Property property:array1) {
			if(property.getPropertyId()== IdPass.id) {
					displayProperty =property;	
					String price = String.valueOf(displayProperty.getPrice());
					String id = String.valueOf(displayProperty.getPropertyId());
					priceLabel.setText(price);
					idLabel.setText(id);
					interestLabel.setText("0.04");			
			}
		}
		
	}
	public void calculateButtonAction(ActionEvent event)throws IOException{
		String monthString = monthTextField.getText().toString();
		int month = Integer.parseInt(monthString);
		double price = 0;
		Property displayProperty;
		for(Property property:array1) {
			if(property.getPropertyId()== IdPass.id) {
					displayProperty =property;	
					price = displayProperty.getPrice();
					break;
			}
		}
		double mortgageAmount = BuyPropertyController.calculateMortgage(price, month);
		DecimalFormat df = new DecimalFormat("#.##");

        // Apply the format to the double value
        String formattedValue = df.format(mortgageAmount);
		amountLabel.setText(formattedValue);
	}
}
