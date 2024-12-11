package application.Boundary;

import java.io.IOException;

import application.Main;
import application.Controller.CreateUserAccountSellerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateUserAccountSellerBoundary {
	
	
	@FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private PasswordField emailField;

    @FXML
    private Label fullName;

    @FXML
    private Button logout;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label phone;

    @FXML
    private TextField phoneField;

    @FXML
    private Label resultLabel;

    @FXML
    private TextField userNameField;

	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLogin.fxml");
	}
	
	public void createButtonAction(ActionEvent event)throws IOException{
		
		boolean result = CreateUserAccountSellerController.createSellerAccount(userNameField.getText().toString(), passwordField.getText().toString(), nameField.getText().toString(), emailField.getText().toString(), phoneField.getText().toString(), "null", "null", "Seller", "Active");
		if(result == true) {
			resultLabel.setText("Successfully Created");
		}else {
			resultLabel.setText("Failed");
		}
	}
	
}
