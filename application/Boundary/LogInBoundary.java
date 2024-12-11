package application.Boundary;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.LogInController;
import application.Entity.AccountPass;


public class LogInBoundary implements Initializable{
	public LogInBoundary() {
		
		
	}
	
	@FXML
	private Button button;
	
	@FXML
	private Label wrongLogin;
	private Label profileTypeLabel;
	
	@FXML
	private TextField username;
	
	@FXML
	private ChoiceBox<String> profileTypesChoiceBox;
	
	@FXML
	private PasswordField password;
	
	private String[] profileTypesArray = {"Admin","Buyer","Seller","Agent"};
	
	public void userLogin(ActionEvent event) throws IOException {
		Main m = new Main();
		String profile = profileTypesChoiceBox.getValue().toString();
//		LogInController loginController = new LogInController();
		String result = LogInController.checkLogin(username.getText().toString(), password.getText().toString(), profile);
		if(result.equals("Success")&& profile.equals("Admin") ) {
			AccountPass.userName = username.getText().toString();
			AccountPass.profile = profile;	
			wrongLogin.setText("Success");
			m.changeScene("afterLogin.fxml");
		}else if(result.equals("Success")&& profile.equals("Buyer")) {
			AccountPass.userName = username.getText().toString();
			AccountPass.profile = profile;
			wrongLogin.setText("Success");
			m.changeScene("afterLoginBuyer.fxml");
		}else if(result.equals("Empty")) {
			wrongLogin.setText("Please enter your data");
		}else {
			wrongLogin.setText("wrong username or password");
		}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		profileTypesChoiceBox.getItems().addAll(profileTypesArray);
		//String profile = profileTypesChoiceBox.getValue();
		
	}
	
}





