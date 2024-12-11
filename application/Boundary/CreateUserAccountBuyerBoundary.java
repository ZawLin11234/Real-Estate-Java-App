package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreateUserAccountBuyerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserAccountBuyerBoundary {
	
	
	@FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private TextField emailField;

    @FXML
    private Label fullName;

    @FXML
    private Button logout;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneField;

    @FXML
    private Label phoneNumButton;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField userNameTextField;

	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLogin.fxml");
	}
	
	public void createButtonAction(ActionEvent event)throws IOException{

		boolean result = CreateUserAccountBuyerController.createBuyerAccount(userNameTextField.getText().toString(), passwordField.getText().toString(), nameField.getText().toString(), emailField.getText().toString(), phoneField.getText().toString(), "null", "null", "Buyer", "Active");
		if(result == true) {
			resultLabel.setText("Successfully Created");
		}else {
			resultLabel.setText("Failed");
		}
	}
	
}
