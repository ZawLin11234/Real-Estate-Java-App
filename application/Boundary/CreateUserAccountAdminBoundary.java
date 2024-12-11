package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreateUserAccountAdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserAccountAdminBoundary {
	
	@FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField emailField;

    @FXML
    private Button logout;

    @FXML
    private Label name;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userNameTextField;
    
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

		boolean result = CreateUserAccountAdminController.createAdminAccount(userNameTextField.getText().toString(), passwordField.getText().toString(), nameField.getText().toString(), emailField.getText().toString(), null, null, null, "Admin", "Active");
		if(result == true) {
			resultLabel.setText("Successfully Created");
		}else {
			resultLabel.setText("Failed");
		}
	}
}
