package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreateUserAccountAgentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserAccountAgentBoundary {
	
	@FXML
    private TextField agencyTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private Label fullName;

    @FXML
    private TextField licenseTextField;

    @FXML
    private Button logout;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label phoneNumButton;

    @FXML
    private TextField phoneTextField;

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

		boolean result = CreateUserAccountAgentController.createAgentAccount(userNameTextField.getText().toString(), passwordField.getText().toString(), nameTextField.getText().toString(), emailTextField.getText().toString(), phoneTextField.getText().toString(), agencyTextField.getText().toString(), licenseTextField.getText().toString(), "Agent", "Active");
		if(result == true) {
			resultLabel.setText("Successfully Created");
		}else {
			resultLabel.setText("Failed");
		}
	}
}
