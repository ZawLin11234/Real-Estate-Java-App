package application.Boundary;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.ViewDetailedAdminController;
import application.Entity.ObjectPass;
import application.Entity.Useraccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class ViewDetailAgentBoundary implements Initializable {

	 @FXML
	 private TextField AgencyTextField;

	 @FXML
	    private TextField emailTextField;   

	 @FXML
	 private TextField fullNameTextField;

	 @FXML
	 private TextField licenseTextField;


	 @FXML
	 private TextField passwordTextField;


	 @FXML
	 private TextField phoneTextField;

	 @FXML
	 private Label userNameDetailLabel;
	 
	    @FXML
	    private Label resultLabel;
    
//		ObservableList<Useraccount> array1 = FXCollections.observableArrayList(
//				//super(username, password, name, email, phone_number, agency_name, license_number, profile, status);
//				new Admin("Zaw", "password4", "Zaw@example.com","Zaw Lin Htike"),
//				new Buyer("Matthew", "password3","Matthew Blah Blah", "Matthew@example.com","123456789"),
//				new Agent("Raymond", "password3","Raymond Blah", "Raymond@example.com","12312312312","Agency1", "12333333"),
//				new Seller("Jeff", "password3","Jeff Blah Blah","Jeff@example.com","12312321321")
//
//				);
	 ObservableList<Useraccount> array1 = ManageUserAccountController.retriveData();
	
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("manageUserAccount.fxml");
	}
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		userNameDetailLabel.setText(ObjectPass.userName);
		Useraccount displayAccount;
		for(Useraccount user:array1) {
			if(user.getUsername().toString().equals(ObjectPass.userName)&&user.getProfile().equals("Agent")) {
					Useraccount agent =user;	
					System.out.println(agent.getPassword());
					passwordTextField.setText(agent.getPassword());
					phoneTextField.setText(agent.getPhone_number());
					fullNameTextField.setText(agent.getName());
					emailTextField.setText(agent.getEmail());
					licenseTextField.setText(agent.getLicense_number());
					AgencyTextField.setText(agent.getAgency_name());
			}
		}
					
	}
	
	public void updateButtonAction(ActionEvent event)throws IOException{
//		System.out.println(userNameDetailLabel.getText().toString()+" "+ passwordTextField.getText().toString()+" "+ fullNameTextField.getText().toString()+ " "+emailTextField.getText().toString()+ " null"+ " null"+" null"+ " Admin"+ " Deactivate");

		boolean result = ViewDetailedAdminController.updateAdminAccount(userNameDetailLabel.getText().toString(), passwordTextField.getText().toString(), fullNameTextField.getText().toString(), emailTextField.getText().toString(), phoneTextField.getText().toString(), AgencyTextField.getText().toString(), licenseTextField.getText().toString(), "Agent", "active");
		
		if(result == true) {
			resultLabel.setText("Successfully Updated");
		}else {
			resultLabel.setText("Failed");
		}
	}
	public void deactivateButtonAction(ActionEvent event)throws IOException{
		
		boolean result = ViewDetailedAdminController.deactivate(userNameDetailLabel.getText().toString(), passwordTextField.getText().toString(), fullNameTextField.getText().toString(), emailTextField.getText().toString(), phoneTextField.getText().toString(), AgencyTextField.getText().toString(), licenseTextField.getText().toString(), "Agent", "Deactivate");
		
		
		if(result == true) {
			resultLabel.setText("Successfully Deactivated");
		}else {
			resultLabel.setText("Failed");
		}
	}
}
