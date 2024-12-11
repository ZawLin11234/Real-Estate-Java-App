package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreateUserProfileController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserProfileBoundary {

	@FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField descriptionField;

    @FXML
    private Button logout;

    @FXML
    private TextField profileTextField;

    @FXML
    private Label resultLabel;
    
    public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLogin.fxml");
	}
	public void createButtonAction(ActionEvent event)throws IOException{

		boolean result = CreateUserProfileController.createProfile(profileTextField.getText().toString(), descriptionField.getText().toString(),"active");
		if(result == true) {
			resultLabel.setText("Successfully Created");
		}else {
			resultLabel.setText("Failed");
		}
	}
	
}
