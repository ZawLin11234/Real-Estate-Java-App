package application.Boundary;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.ViewDetailedAdminController;
import application.Controller.ViewUserProfileController;
import application.Controller.manageUserProfileController;
import application.Entity.Buyer;
import application.Entity.ObjectPass;
import application.Entity.Profile;
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

public class ViewUserProfileBoundary implements Initializable {



    @FXML
    private TextField descriptionField;


    @FXML
    private Label profileLabel;

    @FXML
    private Label resultLabel;
	
	
	 ObservableList<Profile> array1 = manageUserProfileController.retriveData();
		
	 public void userCancel(ActionEvent event)throws IOException {
		 Main m = new Main();
		 m.changeScene("manageUserProfile.fxml");
		}
		
	 public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		profileLabel.setText(ObjectPass.userName);
		Profile displayAccount;
		for(Profile user:array1) {
			if(user.getName().toString().equals(ObjectPass.userName)) {
				displayAccount = user;
				descriptionField.setText(displayAccount.getDescription());
				profileLabel.setText(displayAccount.getName());
					
				break;
			}
		}
						
	}
	public void updateButtonAction(ActionEvent event)throws IOException{
		boolean result = ViewUserProfileController.updateUserProfile(profileLabel.getText().toString(), descriptionField.getText().toString(),"active");
		
		if(result == true) {
			resultLabel.setText("Successfully Updated");
		}else {
			resultLabel.setText("Failed");
		}
	}
	public void deactivateButtonAction(ActionEvent event)throws IOException{
		boolean result = ViewUserProfileController.updateUserProfile(profileLabel.getText().toString(), descriptionField.getText().toString(),"deactivate");
		
		if(result == true) {
			resultLabel.setText("Success!");
		}else {
			resultLabel.setText("Failed!");
		}
	}
		
	
}
